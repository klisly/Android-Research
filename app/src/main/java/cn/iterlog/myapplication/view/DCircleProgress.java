package cn.iterlog.myapplication.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import cn.iterlog.myapplication.R;

public class DCircleProgress extends View {
    private static final int RED = 0xFFE5282C;
    private static final int YELLOW = 0xFF1F909A;
    private int innerColor;
    private int outerColor;
    private int innerRadius = 40;
    private int outerRadius = 80;


    private int innerStartAngle;
    private int innerSweepAngle;
    private int outerStartAngle;
    private int outerSweepAngle;
    private float boderWidth;
    private RectF innerRect;
    private RectF outterRect;

    private int mViewSize;
    private Point mCenter = new Point();
    private boolean mStartAnim = true;
    private int defaultStep = 6;
    private int step = 6;

    private Paint innerPaint;
    private Paint outerPaint;

    public DCircleProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public DCircleProgress(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);
    }

    private void init(AttributeSet attrs, int defStyle) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.DCircleProgress, defStyle, 0);
        innerColor = a.getColor(R.styleable.DCircleProgress_colorinner, RED);
        innerRadius = a.getInt(R.styleable.DCircleProgress_radiusinner, 50);
        outerColor = a.getColor(R.styleable.DCircleProgress_colorouter, YELLOW);
        outerRadius = a.getInt(R.styleable.DCircleProgress_radiusouter, 100);
        defaultStep = a.getInteger(R.styleable.DCircleProgress_step, 6);
        boderWidth = a.getDimension(R.styleable.DCircleProgress_width, 8f);
        a.recycle();

        innerPaint = new Paint();
        innerPaint.setAntiAlias(true);
        innerPaint.setStyle(Paint.Style.STROKE);
        innerPaint.setColor(innerColor);
        innerPaint.setStrokeWidth(boderWidth);

        outerPaint = new Paint();
        outerPaint.setAntiAlias(true);
        outerPaint.setStyle(Paint.Style.STROKE);
        outerPaint.setColor(outerColor);
        outerPaint.setStrokeWidth(boderWidth);

        initValueAnimator();
    }

    private void initValueAnimator() {
        ValueAnimator animator = ValueAnimator.ofInt(10, 7, 10, 7);
        animator.setInterpolator(new DecelerateInterpolator());
        animator.setRepeatCount(-1);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                step = (int) animation.getAnimatedValue() * defaultStep / 10;
            }
        });
        animator.start();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
//        Log.i("Dcircle", "w:" + w + " h：" + h);
        innerRadius = (mViewSize * innerRadius) / (2 * 100);
        innerRect = new RectF(mCenter.x - innerRadius, mCenter.y - innerRadius, mCenter.x + innerRadius, mCenter.y + innerRadius);
        outerRadius = (mViewSize * outerRadius) / (2 * 100);
        outterRect = new RectF(mCenter.x - outerRadius, mCenter.y - outerRadius, mCenter.x + outerRadius, mCenter.y + outerRadius);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int defaultSize = getResources().getDimensionPixelSize(R.dimen.default_circle_view_size);
        int width = getDefaultSize(defaultSize, widthMeasureSpec);
        int height = getDefaultSize(defaultSize, heightMeasureSpec);
        mViewSize = Math.min(width, height);
        setMeasuredDimension(mViewSize, mViewSize);
        mCenter.set(mViewSize / 2, mViewSize / 2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();
//        canvas.translate(mCenter.x, mCenter.y);

        canvas.drawArc(innerRect, innerStartAngle, innerSweepAngle, false, innerPaint);
        canvas.drawArc(outterRect, outerStartAngle, innerSweepAngle, false, outerPaint);

        canvas.restore();

        if (mStartAnim) {
            computeNext();
            postInvalidate();
        }
    }

    int maxSweepEngle = 260;
    int state = 0;
    private void computeNext() {
        if (state == 0) {
            innerSweepAngle += step;
            if (innerSweepAngle > maxSweepEngle) {
                state = 1;
            }
        } else if (state == 1) {
            innerStartAngle += step;
            if (innerStartAngle + innerSweepAngle >= 360) {
                state = 2;
            }
        } else if (state == 2) {
            innerStartAngle += step;
            innerSweepAngle -= step;
            if (innerSweepAngle <= 0) {
                state = 0;
                innerStartAngle = 0;
                innerSweepAngle = 0;
            }
        }
        innerStartAngle %= 360;
        outerStartAngle = innerStartAngle + 180;
    }


    public void startAnim() {
        mStartAnim = true;
        postInvalidate();
    }

    public void reset() {
        stopAnim();
        postInvalidate();
    }

    public void stopAnim() {
        mStartAnim = false;
    }

}
