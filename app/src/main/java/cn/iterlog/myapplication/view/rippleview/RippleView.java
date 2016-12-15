package cn.iterlog.myapplication.view.rippleview;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;

import cn.iterlog.myapplication.R;

import static android.content.ContentValues.TAG;

/**
 * 具有波纹的视图
 */
public class RippleView extends Button {
    // 点击控件的点
    private float mDownX;
    private float mDownY;
    private float mDensity;
    private float mRadius;
    private float mMaxRadius;

    private int mRippleColor = Color.GREEN;
    private float mAlphaFactor = 0.4f;
    private boolean mHover = true; // 是否显示波纹
    private Path mPath = new Path();
    private RadialGradient mRadialGradient;
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private ObjectAnimator mRadiusAnimator;
    private ObjectAnimator finalRadiusAnimator;
    private boolean mAnimIsCancle;
    private Rect mRect;
    private boolean mIsAnimating = false;
    private int mDefaultRadius;
    private int curAnimValue;
    private int SHORT_LEVEL_DURATION = 400;
    private int LONG_LEVEL_DURATION = 600;

    public RippleView(Context context) {
        super(context);
        init(null, 0);
    }

    public RippleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public RippleView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        // Load attributes
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.RippleView, defStyle, 0);
        mRippleColor = a.getColor(R.styleable.RippleView_rippleColor, mRippleColor);
        mAlphaFactor = a.getFloat(R.styleable.RippleView_alphaFactor, mAlphaFactor);
        mHover = a.getBoolean(R.styleable.RippleView_hover, mHover);
        a.recycle();
        mDensity = getContext().getResources().getDisplayMetrics().density;
        // Set up a default TextPaint object
        mPaint = new Paint();
        mPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        mPaint.setTextAlign(Paint.Align.LEFT);
        mDefaultRadius = dp2px(50);
        // init Animation
        mRadiusAnimator = ObjectAnimator.ofFloat(this, "radius", 0, mDefaultRadius).setDuration(SHORT_LEVEL_DURATION);
        mRadiusAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
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
        mRadiusAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Float cur = (Float) valueAnimator.getAnimatedValue();
                curAnimValue = cur.intValue();
                Log.d("curAnimValue", String.valueOf(curAnimValue));
                setRadius(curAnimValue);
            }
        });
    }

    private int dp2px(int dp) {
        return (int) (dp * mDensity + 0.5f);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mMaxRadius = (float) Math.sqrt(w * w + h * h);
        mRect = new Rect(getLeft(), getTop(), getRight(), getBottom());
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("OnTouchEvent", String.valueOf(event.getActionMasked()));
        Log.d("mIsAnimating", String.valueOf(mIsAnimating));
        Log.d("mAnimIsCancle", String.valueOf(mAnimIsCancle));

        mDownX = event.getX();
        mDownY = event.getY();

        boolean result = super.onTouchEvent(event);
        if (event.getActionMasked() == MotionEvent.ACTION_DOWN
                && isEnabled() && mHover) {
            Log.d("onTouchEvent", "start anim");
            mAnimIsCancle = false;
            mRadiusAnimator.start();
            return true;
        } else if (event.getActionMasked() == MotionEvent.ACTION_MOVE) {
            if (!mAnimIsCancle && mRect.contains((int) event.getX(), (int) event.getY())) {
                if (!mIsAnimating) {
                    setRadius(mDefaultRadius);
                }
            } else {
                setRadius(0);
            }
            return true;
        } else if (event.getActionMasked() == MotionEvent.ACTION_UP) {
            float tmpRadius = (int) Math.sqrt(mDownX * mDownX + mDownY * mDownY);
            float finalRadius = Math.min(mMaxRadius, tmpRadius);
            if (mIsAnimating) {
                mRadiusAnimator.cancel();
            }
            finalRadiusAnimator = ObjectAnimator.ofFloat(this, "radius", curAnimValue, finalRadius)
                    .setDuration(LONG_LEVEL_DURATION);
            finalRadiusAnimator
                    .setInterpolator(new AccelerateDecelerateInterpolator());
            finalRadiusAnimator.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {
                    mIsAnimating = true;
                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    curAnimValue = 0;
                    setRadius(curAnimValue);
                    setAlpha(1);
                    mIsAnimating = false;
                }

                @Override
                public void onAnimationCancel(Animator animator) {

                }

                @Override
                public void onAnimationRepeat(Animator animator) {

                }
            });
            finalRadiusAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Float cur = (Float) valueAnimator.getAnimatedValue();
                    curAnimValue = cur.intValue();
                    Log.d("curAnimValue", String.valueOf(curAnimValue));
                    setRadius(curAnimValue);
                }
            });
            finalRadiusAnimator.start();
            return true;
        }
        return result;
    }

    private void setRadius(int radius) {
        Log.i(TAG, "set radius " + radius);
        mRadius = radius;
        if (mRadius > 0) {
            mRadialGradient = new RadialGradient(mDownX, mDownY, mRadius,
                    adjustAlpha(mRippleColor, mAlphaFactor), mRippleColor,
                    Shader.TileMode.MIRROR);
            mPaint.setShader(mRadialGradient);
        }
        postInvalidate();
    }

    private int adjustAlpha(int mRippleColor, float mAlphaFactor) {
        int alpha = Math.round(Color.alpha(mRippleColor) * mAlphaFactor);
        int red = Color.red(mRippleColor);
        int green = Color.green(mRippleColor);
        int blur = Color.blue(mRippleColor);
        return Color.argb(alpha, red, green, blur);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (isInEditMode()) {
            return;
        }
        canvas.save(Canvas.CLIP_SAVE_FLAG);
        mPath.reset();
        mPath.addCircle(mDownX, mDownY, mRadius, Path.Direction.CW);
        canvas.clipPath(mPath);
        canvas.restore();
        canvas.drawCircle(mDownX, mDownY, mRadius, mPaint);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        finalRadiusAnimator.cancel();
        mRadiusAnimator.cancel();
    }
}
