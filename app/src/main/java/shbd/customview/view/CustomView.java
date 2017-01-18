package shbd.customview.view;

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
 * 创建时间：2017/1/17 8:05
 * 修改人：yh
 * 修改时间：2017/1/17 8:05
 * 修改备注：
 */
public class CustomView extends View {
    private Paint mPaint;
    private Canvas mCanvas;

    public CustomView(Context context) {
        this(context, null);
    }

    public CustomView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(2f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.aaa);

        canvas.translate(getMeasuredWidth() / 2, getMeasuredHeight() / 2);

        canvas.drawBitmap(bitmap, new Rect(0,0,600,600), new RectF(0,0,300,300), mPaint);

        super.onDraw(canvas);
    }

    public void drawBitMap() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.aaa);

        mCanvas.translate(getMeasuredWidth() / 2, getMeasuredHeight() / 2);

        mCanvas.drawBitmap(bitmap, new Rect(0,0,200,200), new RectF(0,0,50,50), mPaint);

        invalidate();
    }
}
