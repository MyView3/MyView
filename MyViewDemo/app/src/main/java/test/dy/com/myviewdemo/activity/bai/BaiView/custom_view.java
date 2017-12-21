package test.dy.com.myviewdemo.activity.bai.BaiView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.List;

/**
 * Created by 31962 on 2017/12/21.
 */

public class custom_view extends View {

    private Paint xYpaint;
    private Paint textpaint;
    private Paint rectpaint;


    private String[] Xdate;
    private String[] Ydata;

    private float MaxY;
    private float margin = 30;

    private List<Integer> list;

    private float pointX;
    private float pointY;
    private float scalex;
    private float scaley;

    public custom_view(Context context) {
        this(context, null);
    }

    public custom_view(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        xYpaint = new Paint();
        xYpaint.setAntiAlias(true);
        xYpaint.setColor(Color.YELLOW);
        xYpaint.setStrokeWidth(4);
        xYpaint.setDither(true);
        xYpaint.setStyle(Paint.Style.STROKE);

        textpaint = new Paint();
        textpaint.setAntiAlias(true);
        textpaint.setColor(Color.RED);
        textpaint.setStrokeWidth(1);
        textpaint.setDither(true);
        textpaint.setTextSize(20);
        textpaint.setStyle(Paint.Style.STROKE);

        rectpaint = new Paint();
        rectpaint.setAntiAlias(true);
        rectpaint.setColor(Color.GRAY);
        rectpaint.setStrokeWidth(4);
        rectpaint.setDither(true);
        rectpaint.setStyle(Paint.Style.FILL);


    }

    private void initView() {
        pointX = margin;
        pointY = getHeight() - margin;

        scalex = (getWidth() - 2 * margin) / Xdate.length;
        scaley = (getHeight() - 2 * margin) / Ydata.length;

    }

    public void initdata(String[] Xdate, String[] Ydata, List<Integer> list) {

        this.Xdate = Xdate;
        this.Ydata = Ydata;
        this.list = list;

        MaxY = Float.parseFloat(Ydata[Ydata.length - 1]);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        initView();
        canvas.drawLine(pointX, pointY, getWidth() - margin, pointY, xYpaint);
        canvas.drawLine(pointX, pointY, pointX, margin, xYpaint);

        for (int i = 0; i < Xdate.length; i++) {
            float currentx = margin + scalex * (i + 1);
            //柱状图
            canvas.drawRect(currentx - 50, getHeight() - (list.get(i) / MaxY * (getHeight() - 2 * margin) + margin), currentx - 20, pointY, rectpaint);

            canvas.drawText(Xdate[i], currentx - 50, getHeight() - margin + 30, textpaint);
            //折线图

            if (i == 0) {

                canvas.drawLine(pointX,pointY,currentx-50,getHeight() - (list.get(i) / MaxY * (getHeight() - 2 * margin) + margin),textpaint);
                canvas.drawCircle(currentx-50,getHeight() - (list.get(i) / MaxY * (getHeight() - 2 * margin) + margin),5,textpaint);
            }else{
                canvas.drawLine(margin+scalex*i-50,getHeight() - (list.get(i-1) / MaxY * (getHeight() - 2 * margin) + margin),currentx-50,getHeight() - (list.get(i) / MaxY * (getHeight() - 2 * margin) + margin),textpaint);
                canvas.drawCircle(currentx-50,getHeight() - (list.get(i) / MaxY * (getHeight() - 2 * margin) + margin),5,textpaint);

            }
        }

        for (int i = 0; i < Ydata.length; i++) {
            float currenty = pointY - scaley * (i + 1);
            canvas.drawText(Ydata[i], pointX - 20, currenty, textpaint);
        }
    }
}
