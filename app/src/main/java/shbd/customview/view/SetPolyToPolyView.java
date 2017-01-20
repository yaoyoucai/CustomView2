package shbd.customview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.gcssloop.view.utils.CanvasAidUtils;

import shbd.customview.R;

/**
 * 项目名称：CustomView2
 * 类描述：
 * 创建人：yh
 * 创建时间：2017/1/20 15:12
 * 修改人：yh
 * 修改时间：2017/1/20 15:12
 * 修改备注：
 */
public class SetPolyToPolyView extends View {
    private Paint mPointPaint;

    private int testPoint = 0;

    private Bitmap mBitmap;

    public SetPolyToPolyView(Context context) {
        this(context, null);
    }

    public SetPolyToPolyView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SetPolyToPolyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();

        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.aaa);
    }

    private void initPaint() {
        mPointPaint = new Paint();
        mPointPaint.setStrokeWidth(50);
        mPointPaint.setColor(Color.GRAY);
        mPointPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.translate(100, 100);

        //绘制坐标系
        CanvasAidUtils.set2DAxisLength(800, 0, 1200, 0);
        CanvasAidUtils.draw2DCoordinateSpace(canvas);

        //绘制点
        super.onDraw(canvas);
    }
}
