package shbd.customview.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import shbd.customview.R;

/**
 * 项目名称：CustomView2
 * 类描述：
 * 创建人：yh
 * 创建时间：2017/1/18 9:14
 * 修改人：yh
 * 修改时间：2017/1/18 9:14
 * 修改备注：
 */
public class CheckButtonView extends View {
    private Paint mPaint;

    Bitmap mBitmap;
    private int mBitmapWidthPer = -1;

    public CheckButtonView(Context context) {
        this(context, null);
    }

    public CheckButtonView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CheckButtonView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();

        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.checkmark);

    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(2f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.translate(getMeasuredWidth() / 2, getMeasuredHeight() / 2);

        mPaint.setColor(Color.BLUE);
        canvas.drawCircle(0, 0, 500, mPaint);

        int bitmapWidth = mBitmap.getWidth();
        int bitmapHeight = mBitmap.getHeight();
        Rect rect = new Rect(bitmapWidth * mBitmapWidthPer / 13, 0, bitmapWidth * (mBitmapWidthPer + 1) / 13, bitmapHeight);
        RectF dist = new RectF(-bitmapWidth / 26, -bitmapHeight / 2, bitmapWidth / 26, bitmapHeight / 2);

        canvas.drawBitmap(mBitmap, rect, dist, mPaint);

        super.onDraw(canvas);
    }

    public void check() {
        ValueAnimator animator = ValueAnimator.ofInt(-1, 12);
        animator.setDuration(500);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mBitmapWidthPer = (int) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        animator.start();
    }

    public void unCheck() {
        ValueAnimator animator = ValueAnimator.ofInt(12, -1);
        animator.setDuration(500);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mBitmapWidthPer = (int) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        animator.start();
    }
}
