package cn.iterlog.myapplication.view.ripplechoice;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;

import cn.iterlog.myapplication.R;

/**
 * 具有波纹的视图
 */
public class RippleChoiceView extends View {
    // 点击控件的点
    private float mDensity;
    private float mRadius;

    private int mUnCheckColor = Color.WHITE;
    private int mCheckColor = Color.GREEN;
    private float mBorderWidth = dp2px(5);
    private RectF mRectF;
    private RectF mNRectF = new RectF();

    private Paint mUncheckPaint;
    private Paint mCheckPaint;
    private boolean mChecked = false;
    private float mThirdRadius;
    private OnClickListener mListener;
    private ValueAnimator mRadiusAnimator;
    private boolean mIsAnimating = false;
    private int isDrawHook;
    private long mDuration = 1200;

    public RippleChoiceView(Context context) {
        super(context);
        init(null, 0);
    }

    public RippleChoiceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public RippleChoiceView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        mDensity = getContext().getResources().getDisplayMetrics().density;
        // Load attributes
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.RippleChoiceView, defStyle, 0);
        mUnCheckColor = a.getColor(R.styleable.RippleChoiceView_uncheckColor, mUnCheckColor);
        mCheckColor = a.getColor(R.styleable.RippleChoiceView_checkColor, mCheckColor);
        mBorderWidth = a.getDimension(R.styleable.RippleChoiceView_borderWidth, dp2px(2));
        a.recycle();

        mUncheckPaint = new Paint(SYSTEM_UI_LAYOUT_FLAGS);
        mUncheckPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        mUncheckPaint.setStrokeWidth(mBorderWidth);
        mUncheckPaint.setColor(mUnCheckColor);
        mUncheckPaint.setStyle(Paint.Style.STROKE);
        mCheckPaint = new Paint(SYSTEM_UI_LAYOUT_FLAGS);
        mCheckPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        mCheckPaint.setColor(mCheckColor);
        mCheckPaint.setStyle(Paint.Style.STROKE);
    }

    private void initValueAnimator() {
        mRadiusAnimator = ValueAnimator.ofFloat(0, 1).setDuration(mDuration);
        mRadiusAnimator.setInterpolator(new AccelerateInterpolator());
        mRadiusAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mThirdRadius = (Float) valueAnimator.getAnimatedValue() * mRadius+ dp2px(1);
                if (mChecked) {
                    mCheckPaint.setStrokeWidth(mThirdRadius);
                } else {
                    mCheckPaint.setStrokeWidth(mRadius - mThirdRadius);
                }
                invalidate();
            }
        });
        mRadiusAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                Log.i("mRadiusAnimator", "onAnimationStart");
                mIsAnimating = true;
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                Log.i("mRadiusAnimator", "onAnimationEnd");
                mIsAnimating = false;
            }

            @Override
            public void onAnimationCancel(Animator animator) {
                Log.i("mRadiusAnimator", "onAnimationCancel");
                mIsAnimating = false;
            }

            @Override
            public void onAnimationRepeat(Animator animator) {
                Log.i("mRadiusAnimator", "onAnimationRepeat");
            }
        });
    }

    private int dp2px(int dp) {
        return (int) (dp * mDensity + 0.5f);
    }
    private int width;
    private int height;
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
        mRectF = new RectF(getPaddingLeft() + mBorderWidth / 2, getPaddingTop() + mBorderWidth / 2,
                w - getPaddingRight() - mBorderWidth / 2, h - getPaddingBottom() - mBorderWidth / 2);
        mRadius = Math.min(mRectF.width(), mRectF.height()) / 2;
        initValueAnimator();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                if (x + getLeft() < getRight() && y + getTop() < getBottom()) {
                    mChecked = !mChecked;
                    if (mIsAnimating) {
                        mRadiusAnimator.cancel();
                    }
                    mRadiusAnimator.start();
                    if (mListener != null) {
                        mListener.onClick(this);
                    }
                }
                break;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(mRectF.centerX(), mRectF.centerY(), mRadius - mBorderWidth, mUncheckPaint);
        if(!(mIsAnimating || mChecked)){
            return;
        }
        if (mChecked) {
            mNRectF.left = getPaddingLeft() + mThirdRadius / 2;
            mNRectF.top =getPaddingTop() + mThirdRadius / 2;
            mNRectF.right = width - getPaddingRight() - mThirdRadius / 2;
            mNRectF.bottom = height - getPaddingBottom() - mThirdRadius / 2;
        } else {
            mNRectF.left = getPaddingLeft() + (mRadius - mThirdRadius) / 2;
            mNRectF.top = getPaddingTop() + (mRadius - mThirdRadius) / 2;
            mNRectF.right = width- getPaddingRight() - (mRadius - mThirdRadius) / 2;
            mNRectF.bottom = height - getPaddingBottom() - (mRadius - mThirdRadius) / 2;
        }

        canvas.drawArc(mRectF, 0f, 360f, false, mUncheckPaint);
        canvas.drawArc(mNRectF, 0f, 360f, false, mCheckPaint);
        if(mChecked && !mIsAnimating){

        }
//        if (mIsAnimating) {
//            mCheckPaint.setAlpha(1);
//            mCheckPaint.setColor(mCheckColor);
//            canvas.drawCircle(mRect.centerX(), mRect.centerY(), mRadius, mCheckPaint);
//            mCheckPaint.setAlpha(0);
//            mCheckPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
//            canvas.drawCircle(mRect.centerX(), mRect.centerY(), mChecked ? mRadius - mThirdRadius : mThirdRadius, mCheckPaint);
//
//        } else {
//            if (mChecked) {
//                mCheckPaint.setAlpha(1);
//                mCheckPaint.setColor(mCheckColor);
//                canvas.drawCircle(mRect.centerX(), mRect.centerY(), mRadius, mCheckPaint);
//            }
//        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if(mIsAnimating){
            mRadiusAnimator.cancel();
        }
    }
}
