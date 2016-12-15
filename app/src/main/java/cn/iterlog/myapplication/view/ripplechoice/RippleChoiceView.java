package cn.iterlog.myapplication.view.ripplechoice;

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
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;

import cn.iterlog.myapplication.R;

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
    private float mFraction = 0.0f;
    private OnCheckedChangeListener mListener;
    private ValueAnimator mFractionAnimator;
    private boolean mIsAnimating = false;
    private int mDuration = 1200;
    private int mCircleDuration = 800;
    private int mHookDuration = 400;

    private PointF hookStart;
    private PointF hookMiddle;
    private PointF hookEnd;

    private boolean mChecked = true;
    private boolean isHookShow = false;

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
        mDuration = a.getInt(R.styleable.RippleChoiceView_rippleduration, mDuration);
        a.recycle();
        mHookDuration = (int) (mDuration * 0.3);
        mCircleDuration = mDuration - mHookDuration;
        mUncheckPaint = new Paint();
        mUncheckPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        mUncheckPaint.setStrokeWidth(mBorderWidth);
        mUncheckPaint.setColor(mUnCheckColor);
        mUncheckPaint.setStyle(Paint.Style.STROKE);
        mCheckPaint = new Paint();
        mCheckPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        mCheckPaint.setColor(mCheckColor);
        mCheckPaint.setStyle(Paint.Style.STROKE);
        isHookShow = mChecked;
        mFraction = mChecked ? 1.0f : 0.0f;
    }

    private void initValueAnimator(long duration) {
        mFractionAnimator = ValueAnimator.ofFloat(0, 1).setDuration(duration);
        mFractionAnimator.setInterpolator(new AccelerateInterpolator());
        mFractionAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mFraction = (Float) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        mFractionAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                Log.i("mFractionAnimator", "onAnimationStart");
                mIsAnimating = true;
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                Log.i("mFractionAnimator", "onAnimationEnd");
                mIsAnimating = false;
                switchState();
            }

            @Override
            public void onAnimationCancel(Animator animator) {
                Log.i("mFractionAnimator", "onAnimationCancel");
                mIsAnimating = false;
            }

            @Override
            public void onAnimationRepeat(Animator animator) {
                Log.i("mFractionAnimator", "onAnimationRepeat");
            }
        });
    }

    private void switchState() {
        if (mChecked && !isHookShow) {
            isHookShow = !isHookShow;
            initValueAnimator(mHookDuration);
            mFractionAnimator.start();
        } else if (!mChecked && isHookShow) {
            isHookShow = !isHookShow;
            initValueAnimator(mCircleDuration);
            mFractionAnimator.start();
        }
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
        mRectF = new RectF(getPaddingLeft(), getPaddingTop(),
                w - getPaddingRight(), h - getPaddingBottom());
        mRadius = Math.min(mRectF.width(), mRectF.height()) / 2;

        hookStart = new PointF(mRectF.centerX() - mRadius / 2, mRectF.centerY() + mRadius / 10);
        hookMiddle = new PointF(mRectF.centerX() - mRadius * 1 / 6, mRectF.centerY() + mRadius * 2 / 5);
        hookEnd = new PointF(mRectF.centerX() + mRadius / 2, mRectF.centerY() - mRadius * 2 / 5);
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
                if (mIsAnimating) {
                    return true;
                }
                if (x + getLeft() < getRight() && y + getTop() < getBottom()) {
                    mChecked = !mChecked;
                    if (mIsAnimating) {
                        mFractionAnimator.cancel();
                    }
                    if (mChecked) {
                        initValueAnimator(mCircleDuration);
                    } else {
                        initValueAnimator(mHookDuration);
                    }
                    mFractionAnimator.start();
                    if (mListener != null) {
                        mListener.onCheckedChanged(this, mChecked);
                    }
                }
                break;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mUncheckPaint.setColor(Color.argb(128, 255, 255, 255));
        mUncheckPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(mRectF.centerX(), mRectF.centerY(), mRadius - mBorderWidth, mUncheckPaint);
        mUncheckPaint.setColor(mUnCheckColor);
        mUncheckPaint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(mRectF.centerX(), mRectF.centerY(), mRadius - mBorderWidth + 1, mUncheckPaint);
        if (mChecked || mIsAnimating) {
            float stroke = mFraction * mRadius;
            if (mChecked) {
                mCheckPaint.setStrokeWidth(stroke);
            } else {
                mCheckPaint.setStrokeWidth(mRadius - stroke);
            }

            if (isHookShow) {
                mNRectF.left = getPaddingLeft() + mRadius / 2;
                mNRectF.top = getPaddingTop() + mRadius / 2;
                mNRectF.right = width - getPaddingRight() - mRadius / 2;
                mNRectF.bottom = height - getPaddingBottom() - mRadius / 2;
                mCheckPaint.setStrokeWidth(mRadius);
            } else if (mChecked) {
                mNRectF.left = getPaddingLeft() + stroke / 2;
                mNRectF.top = getPaddingTop() + stroke / 2;
                mNRectF.right = width - getPaddingRight() - stroke / 2;
                mNRectF.bottom = height - getPaddingBottom() - stroke / 2;
            } else {
                mNRectF.left = getPaddingLeft() + (mRadius - stroke) / 2;
                mNRectF.top = getPaddingTop() + (mRadius - stroke) / 2;
                mNRectF.right = width - getPaddingRight() - (mRadius - stroke) / 2;
                mNRectF.bottom = height - getPaddingBottom() - (mRadius - stroke) / 2;
            }

            canvas.drawArc(mNRectF, 0f, 360f, false, mCheckPaint);
        }
        if (!mChecked && isHookShow) {
            mFraction = 1 - mFraction;
        }

        if (isHookShow && mFraction > 0) {// y1 - x1
            Log.i("isHookShow", isHookShow + " " + mFraction);
            if (mFraction < 0.4) {
                canvas.drawLine(hookStart.x, hookStart.y, getr1x((float) (mFraction / 0.4)), getr1y((float) (mFraction / 0.4)), mUncheckPaint);
            } else {
                canvas.drawLine(hookStart.x, hookStart.y, hookMiddle.x + 2, hookMiddle.y + 2, mUncheckPaint);
                canvas.drawLine(hookMiddle.x, hookMiddle.y, getr2x((float) ((mFraction - 0.4) / 0.6)), getr2y((float) ((mFraction - 0.4f) / 0.6)), mUncheckPaint);
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

    public static interface OnCheckedChangeListener {
        void onCheckedChanged(RippleChoiceView view, boolean isChecked);
    }

}
