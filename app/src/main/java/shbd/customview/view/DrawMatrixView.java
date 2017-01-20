package shbd.customview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import shbd.customview.R;

/**
 * 项目名称：CustomView2
 * 类描述：
 * 创建人：yh
 * 创建时间：2017/1/20 10:17
 * 修改人：yh
 * 修改时间：2017/1/20 10:17
 * 修改备注：
 */
public class DrawMatrixView extends View {
    private Paint mPaint;
    private Bitmap mBitmap;

    private Matrix mPolyMatrix;

    public DrawMatrixView(Context context) {
        this(context, null);
    }

    public DrawMatrixView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawMatrixView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
        initBitmapAndMatrix();
    }

    private void initBitmapAndMatrix() {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.aaa);
        mPolyMatrix = new Matrix();

        float[] src = new float[]{
                0, 0,
                mBitmap.getWidth(), 0,
                mBitmap.getWidth(), mBitmap.getHeight(),
                0, mBitmap.getHeight()
        };

        float[] dst = new float[]{
                0, 0,
                mBitmap.getWidth() , 200,
                mBitmap.getWidth(), mBitmap.getHeight()-100,
                0, mBitmap.getHeight()
        };
        mPolyMatrix.setPolyToPoly(src, 0, dst, 0, src.length >> 1);
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

        canvas.drawBitmap(mBitmap,mPolyMatrix, mPaint);

        super.onDraw(canvas);
    }
}
