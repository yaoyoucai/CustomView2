package shbd.customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * 项目名称：CustomView2
 * 类描述：二阶贝塞尔曲线
 * 创建人：yh
 * 创建时间：2017/1/18 17:32
 * 修改人：yh
 * 修改时间：2017/1/18 17:32
 * 修改备注：
 */
public class DrawSecondoryBessellView extends View {
    private Paint mPaint;

    private int centerX, centerY;

    private PointF start, end, control;

    public DrawSecondoryBessellView(Context context) {
        this(context, null);
    }

    public DrawSecondoryBessellView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawSecondoryBessellView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
        start = new PointF(0, 0);
        end = new PointF(0, 0);
        control = new PointF(0, 0);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w / 2;
        centerY = h / 2;

        start.x = centerX - 200;
        start.y = centerY;

        end.x = centerX + 200;
        end.y = centerY;

        control.x = centerX;
        control.y = centerY - 100;
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        control.x = event.getX();
        control.y = event.getY();
        invalidate();
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //1.绘制数据点，控制点
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(10f);
        canvas.drawPoints(new float[]{
                start.x, start.y,
                end.x, end.y,
                control.x, control.y,
        }, mPaint);

        //2.绘制辅助线
        mPaint.setStrokeWidth(5f);
        mPaint.setColor(Color.BLACK);
        canvas.drawLines(new float[]{
                start.x, start.y, control.x, control.y,
                end.x, end.y, control.x, control.y,
        }, mPaint);

        //3.绘制贝塞尔曲线
        mPaint.setColor(Color.RED);
        Path path = new Path();
        path.moveTo(start.x, start.y);
        path.quadTo(control.x, control.y, end.x, end.y);
        canvas.drawPath(path, mPaint);
        super.onDraw(canvas);
    }
}
