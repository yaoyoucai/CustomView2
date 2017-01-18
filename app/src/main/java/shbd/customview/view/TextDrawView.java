package shbd.customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * 项目名称：CustomView2
 * 类描述：
 * 创建人：yh
 * 创建时间：2017/1/18 16:52
 * 修改人：yh
 * 修改时间：2017/1/18 16:52
 * 修改备注：
 */
public class TextDrawView extends View {
    private Paint mPaint;

    public TextDrawView(Context context) {
        this(context, null);
    }

    public TextDrawView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TextDrawView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(2f);
        mPaint.setTextSize(100f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // 文本(要绘制的内容)
        String str = "ABCDEFG";
        canvas.drawText(str, 200, 400, mPaint);
        canvas.drawText(str, 1, 3, 400, 500, mPaint);

        char[] chars = "ABCDEFG".toCharArray();

        canvas.drawText(chars, 1, 3, 800, 600, mPaint);

        String chinaStr = "文本要";

        canvas.drawPosText(chinaStr, new float[]{500,600,
                                                 600,700,
                                                 700,800,
                                                }, mPaint);
        super.onDraw(canvas);
    }
}
