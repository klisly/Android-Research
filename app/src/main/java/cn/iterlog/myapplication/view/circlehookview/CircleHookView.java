package cn.iterlog.myapplication.view.circlehookview;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

import cn.iterlog.myapplication.R;

/**
 * 具有波纹的视图
 */
public class CircleHookView extends View {
    // 点击控件的点
    private float mDensity;
    private float mRadius;

    private int mCircleColor = Color.GREEN;
    private int mHookColor = Color.GREEN;
    private float mHookSize;
    private float mCircleSize;
    private int mStartAngle = 0;

    private RectF mRectF;
    private Paint mCiclePaint;
    private Paint mHookPaint;

    private PointF hookStart;
    private PointF hookMiddle;
    private PointF hookEnd;

    private boolean mChecked = false;
    private float mFraction;
    private ValueAnimator mFractionAnimator;
    private boolean mIsAnimating = false;
    private int mDuration = 2000;
    private int mCircleDuration = mDuration;
    private int mHookDuration = mDuration;
    private int stage = -1;

    private int STAGE_CIRLE = 1;
    private int STAGE_HOOK = 2;

    public CircleHookView(Context context) {
        super(context);
        init(null, 0);
    }

    public CircleHookView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public CircleHookView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        mDensity = getContext().getResources().getDisplayMetrics().density;

        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.CircleHookView, defStyle, 0);
        mCircleColor = a.getColor(R.styleable.CircleHookView_circleColor, mCircleColor);
        mHookColor = a.getColor(R.styleable.CircleHookView_hookColor, mHookColor);
        mStartAngle = a.getInt(R.styleable.CircleHookView_startAngle, mStartAngle);
        mCircleSize = a.getDimension(R.styleable.CircleHookView_circleSize, dp2px(2));
        mHookSize = a.getDimension(R.styleable.CircleHookView_hookSize, dp2px(2));
        mDuration = a.getInt(R.styleable.CircleHookView_duration, mDuration);
        mHookDuration = (int) (mDuration * 0.4);
        mCircleDuration = (int) (mDuration * 0.6);
        a.recycle();

        mCiclePaint = new Paint(SYSTEM_UI_LAYOUT_FLAGS);
        mCiclePaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        mCiclePaint.setStrokeWidth(mCircleSize);
        mCiclePaint.setColor(mCircleColor);
        mCiclePaint.setStyle(Paint.Style.STROKE);

        mHookPaint = new Paint(SYSTEM_UI_LAYOUT_FLAGS);
        mHookPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        mHookPaint.setColor(mHookColor);
        mHookPaint.setStrokeWidth(mHookSize);
        mHookPaint.setStyle(Paint.Style.STROKE);
    }

    private void initValueAnimator(int duration) {
        mFractionAnimator = ValueAnimator.ofFloat(0, 1).setDuration(duration);
        mFractionAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        mFractionAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(final ValueAnimator valueAnimator) {
                mFraction = (Float) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        mFractionAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(final Animator animator) {
                Log.i("mFractionAnimator", "onAnimationStart");
                mIsAnimating = true;
            }

            @Override
            public void onAnimationEnd(final Animator animator) {
                Log.i("mFractionAnimator", "onAnimationEnd");
                mIsAnimating = false;
                switchStage();
            }

            @Override
            public void onAnimationCancel(final Animator animator) {
                Log.i("mFractionAnimator", "onAnimationCancel");
                mIsAnimating = false;
            }

            @Override
            public void onAnimationRepeat(final Animator animator) {
                Log.i("mFractionAnimator", "onAnimationRepeat");
            }
        });
    }

    private void switchStage() {
        if (stage == STAGE_CIRLE) {// 绘制完成CIRCL
            stage = STAGE_HOOK;
            initValueAnimator(mHookDuration);
            mFractionAnimator.start();
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    private int dp2px(final int dp) {
        return (int) (dp * mDensity + 0.5f);
    }

    @Override
    protected void onSizeChanged(final int w, final int h, final int oldw, final int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mRectF = new RectF(getPaddingLeft() + mCircleSize / 2, getPaddingTop() + mCircleSize / 2,
                w - getPaddingRight() - mCircleSize / 2, h - getPaddingBottom() - mCircleSize / 2);
        mRadius = Math.min(mRectF.width(), mRectF.height()) / 2;

        hookStart = new PointF(mRectF.centerX() - mRadius / 2, mRectF.centerY() + mRadius / 10);
        hookMiddle = new PointF(mRectF.centerX() - mRadius * 1 / 6, mRectF.centerY() + mRadius * 2 / 5);
        hookEnd = new PointF(mRectF.centerX() + mRadius / 2, mRectF.centerY() - mRadius * 2 / 5);

        stage = STAGE_CIRLE;
        initValueAnimator(mCircleDuration);
        mFractionAnimator.start();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (stage == STAGE_CIRLE) {
            canvas.drawArc(mRectF, mStartAngle, -360 * mFraction, false, mCiclePaint);
        } else {
            canvas.drawArc(mRectF, mStartAngle, 360, false, mCiclePaint);
        }

        if (stage == STAGE_HOOK && mFraction > 0) {// y1 - x1
            if (mFraction < 0.4) {
                canvas.drawLine(hookStart.x, hookStart.y, getr1x((float) (mFraction / 0.4)), getr1y((float) (mFraction / 0.4)), mHookPaint);
            } else {
                canvas.drawLine(hookStart.x, hookStart.y, hookMiddle.x, hookMiddle.y, mHookPaint);
                canvas.drawLine(hookMiddle.x, hookMiddle.y, getr2x((float) ((mFraction - 0.4) / 0.6)), getr2y((float) ((mFraction - 0.4f) / 0.6)), mHookPaint);
            }
        }
    }

    private float getr1y(float fraction) {
        return hookStart.y + (hookMiddle.y - hookStart.y) * fraction;
    }

    private float getr1x(float fraction) {
        return hookStart.x + (hookMiddle.x - hookStart.x) * fraction;
    }

    private float getr2y(float fraction) {
        return hookMiddle.y + (hookEnd.y - hookMiddle.y) * fraction;
    }

    private float getr2x(float fraction) {
        return hookMiddle.x + (hookEnd.x - hookMiddle.x) * fraction;
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mIsAnimating) {
            mFractionAnimator.cancel();
        }
    }
}
