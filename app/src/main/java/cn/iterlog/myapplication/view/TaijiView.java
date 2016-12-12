package cn.iterlog.myapplication.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class TaijiView extends View {
    private int width = 400;
    private int height = 400;
    private Paint mWhitePaint;
    private Paint mBlackPaint;
    private int degree = 0;
    private Context context;
    public TaijiView(Context context) {
        this(context, null);
    }

    public TaijiView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TaijiView(Context context, AttributeSet attrs,
                     int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        this.context = context;
    }

    private void init() {
        mWhitePaint = new Paint();
        mWhitePaint.setAntiAlias(true);
        mWhitePaint.setColor(Color.WHITE);
        mBlackPaint = new Paint(mWhitePaint);
        mBlackPaint.setColor(Color.BLACK);
    }
    int radius = Math.min(width, height) / 2 - 100;
    int eyeRadius = radius / 8;
    int smallRadius = radius / 2;
    RectF rectF = new RectF(-radius, -radius, radius, radius);
    RectF rectF1 = new RectF(0, -smallRadius, radius, smallRadius);
    RectF rectF2 = new RectF(-radius, -smallRadius, 0, smallRadius);
    RectF rectF3 = new RectF(radius / 2 - eyeRadius, -eyeRadius, radius / 2 + eyeRadius, eyeRadius);
    RectF rectF4 = new RectF(-radius / 2 - eyeRadius, -eyeRadius, -radius / 2 + eyeRadius, eyeRadius);

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.i(TaijiView.class.getSimpleName(), "w:" + w + " h:" + h);
        width = w;
        height = h;
        rectF = new RectF(-radius, -radius, radius, radius);
        rectF1 = new RectF(0, -smallRadius, radius, smallRadius);
        rectF2 = new RectF(-radius, -smallRadius, 0, smallRadius);
        rectF3 = new RectF(radius / 2 - eyeRadius, -eyeRadius, radius / 2 + eyeRadius, eyeRadius);
        rectF4 = new RectF(-radius / 2 - eyeRadius, -eyeRadius, -radius / 2 + eyeRadius, eyeRadius);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec,
                             int heightMeasureSpec) {
        setMeasuredDimension(
                measureWidth(widthMeasureSpec),
                measureHeight(heightMeasureSpec));
    }

    private int measureWidth(int measureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = specSize;
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        return result;
    }

    private int measureHeight(int measureSpec) {
        int result = 200;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        return result;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.GRAY);
        canvas.translate(width / 2, height / 2);
        canvas.rotate(degree);

        canvas.drawArc(rectF, 0, 180, true, mBlackPaint);
        canvas.drawArc(rectF, 180, 180, true, mWhitePaint);
        canvas.drawArc(rectF1, 180, 180, true, mBlackPaint);
        canvas.drawArc(rectF2, 0, 180, true, mWhitePaint);
        canvas.drawArc(rectF3, 0, 360, true, mWhitePaint);
        canvas.drawArc(rectF4, 0, 360, true, mBlackPaint);
        rotate();
    }

    private void rotate() {

        degree -= 4;
        postInvalidate();

    }
}
