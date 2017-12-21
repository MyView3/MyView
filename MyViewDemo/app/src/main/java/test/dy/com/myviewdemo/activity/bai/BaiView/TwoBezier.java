package test.dy.com.myviewdemo.activity.bai.BaiView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by 31962 on 2017/12/19.
 */

public class TwoBezier extends View {

    private Paint mPaint;
    private PointF start;
    private PointF end;
    private PointF fingerPoint;
    private int centerX;
    private int centerY;

    public TwoBezier(Context context) {
        this(context,null);

    }

    public TwoBezier(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setStrokeWidth(3);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setTextSize(60);
        start = new PointF(0, 0);
        end = new PointF(0, 0);
        fingerPoint = new PointF(0, 0);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        fingerPoint.x = event.getX();
        fingerPoint.y = event.getY();
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.GRAY);
        mPaint.setStrokeWidth(20);
        canvas.drawPoint(start.x,start.y,mPaint);
        canvas.drawPoint(end.x,end.y,mPaint);
        canvas.drawPoint(fingerPoint.x,fingerPoint.y,mPaint);

        mPaint.setStrokeWidth(4);
        canvas.drawLine(start.x,start.y,fingerPoint.x,fingerPoint.y,mPaint);
        canvas.drawLine(end.x,end.y,fingerPoint.x,fingerPoint.y,mPaint);

        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(8);

        Path path = new Path();
        path.moveTo(start.x,start.y);
        path.quadTo(fingerPoint.x,fingerPoint.y,end.x,end.y);

        canvas.drawPath(path,mPaint);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w / 2;
        centerY = h / 2;
        start.x = centerX - 200;
        start.y = centerY;

        end.x = centerX+200;
        end.y = centerY;

        fingerPoint.x = centerX;
        fingerPoint.y = centerY - 100;
    }
}
