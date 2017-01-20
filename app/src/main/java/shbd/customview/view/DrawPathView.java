package shbd.customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * 项目名称：CustomView2
 * 类描述：
 * 创建人：yh
 * 创建时间：2017/1/18 17:32
 * 修改人：yh
 * 修改时间：2017/1/18 17:32
 * 修改备注：
 */
public class DrawPathView extends View {
    private Paint mPaint;

    public DrawPathView(Context context) {
        this(context, null);
    }

    public DrawPathView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawPathView(Context context, AttributeSet attrs, int defStyleAttr) {
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
        canvas.translate(getMeasuredWidth() / 2, getMeasuredHeight() / 2);

        Path path = new Path();

        RectF rect = new RectF(-200, -200, 200, 200);
        path.addArc(rect, 45, 350);

        canvas.drawLines(new float[]{
                -800, 0, 800, 0,
                0, -800, 0, 800
        }, mPaint);
        canvas.drawPath(path, mPaint);
        super.onDraw(canvas);
    }
}
