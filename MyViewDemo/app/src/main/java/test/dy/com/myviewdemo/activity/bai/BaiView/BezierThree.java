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
 * Created by 31962 on 2017/12/20.
 */

public class BezierThree extends View {

    private Paint mPaint;
    private PointF start;
    private PointF end;
    private PointF fingerPointOne;
    private PointF fingerPointTwo;
    private int centerX;
    private int centerY;
    private boolean mode = true;

    public BezierThree(Context context) {
        this(context,null);
    }

    public BezierThree(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(8);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setTextSize(60);

        start = new PointF(0, 0);
        end = new PointF(0, 0);
        fingerPointOne = new PointF(0, 0);
        fingerPointTwo = new PointF(0, 0);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w / 2;
        centerY = h / 2;

        start.x = 10;
        start.y = centerY;
        end.x = w-10;
        end.y = centerY;

        fingerPointOne.x = centerX;
        fingerPointOne.y = centerY - 100;
        fingerPointTwo.x = centerX;
        fingerPointTwo.y = centerY - 100;


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if(mode){
            fingerPointOne.x = event.getX();
            fingerPointOne.y = event.getY();
        }else{
            fingerPointTwo.x = event.getX();
            fingerPointTwo.y = event.getY();
        }
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
        canvas.drawPoint(fingerPointOne.x,fingerPointOne.y,mPaint);
        canvas.drawPoint(fingerPointTwo.x,fingerPointTwo.y,mPaint);

        mPaint.setStrokeWidth(4);
        canvas.drawLine(start.x,start.y,fingerPointOne.x,fingerPointOne.y,mPaint);
        canvas.drawLine(fingerPointOne.x,fingerPointOne.y,fingerPointTwo.x,fingerPointTwo.y,mPaint);
        canvas.drawLine(fingerPointTwo.x,fingerPointTwo.y,end.x,end.y,mPaint);

        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(8);
        Path path = new Path();
        path.moveTo(start.x,start.y);

        path.cubicTo(fingerPointOne.x,fingerPointOne.y,fingerPointTwo.x,fingerPointTwo.y,end.x,end.y);
        canvas.drawPath(path,mPaint);
    }
}
