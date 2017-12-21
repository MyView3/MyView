package test.dy.com.myviewdemo.activity.du;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Arrays;
import java.util.List;

/**
 * Created by dy on 2017/12/21.
 */

public class DuView extends View {
    //数据
    private String[] xData = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
    private String[] yData = {"100","200","300","400","500","600","700","800","900","1000"};
    private List<Integer> list = Arrays.asList(300,200,460,120,730,240,80);
    //偏移量
    private int margin=20;
    private int marginX=30;
    private int marginY=30;
    //原点
    private int pointX;
    private int pointY;
    //平均值
    private int scaleX;
    private int scaleY;
    //画笔
    private Paint paintXY;
    private Paint paintRect;
    private Paint paintValue;
    public DuView(Context context) {
        this(context,null);
    }

    public DuView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DuView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public void init(){
        pointX = margin+marginX;
        pointY = getHeight() - (margin + marginY);
        scaleX = (getWidth() - 2*margin - marginX)/xData.length;
        scaleY = (getHeight() - 2*margin - marginY)/yData.length;

        paintXY = new Paint();
        paintXY.setStyle(Paint.Style.STROKE);
        paintXY.setAntiAlias(true);
        paintXY.setDither(true);
        paintXY.setColor(Color.BLACK);
        paintXY.setStrokeWidth(3);

        paintValue = new Paint();
        paintValue.setStyle(Paint.Style.STROKE);
        paintValue.setDither(true);
        paintValue.setAntiAlias(true);
        paintValue.setColor(Color.BLACK);
        paintValue.setTextSize(15);

        paintRect = new Paint();
        paintRect.setStyle(Paint.Style.FILL);
        paintRect.setDither(true);
        paintRect.setAntiAlias(true);
        paintRect.setStrokeWidth(1);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        init();

        //绘制X轴
        canvas.drawLine(pointX,pointY,getWidth() - margin,pointY,paintXY);
        //绘制Y轴
        canvas.drawLine(pointX,pointY,pointX,margin,paintXY);
        //绘制X轴箭头
        canvas.drawLine(getWidth() - margin,pointY,getWidth() - margin-20,pointY-20,paintXY);
        canvas.drawLine(getWidth() - margin,pointY,getWidth() - margin-20,pointY+20,paintXY);
        //绘制Y轴箭头
        canvas.drawLine(pointX,margin,pointX+20,margin+20,paintXY);
        canvas.drawLine(pointX,margin,pointX-20,margin+20,paintXY);
        //画X轴数据
        for (int i=1;i<=xData.length;i++){

            int height=pointY-margin;
            int single = height / yData.length ;
            int marginLeft = pointX + scaleX * i;
            canvas.drawText(xData[i-1],marginLeft - 53,pointY + 25, paintValue);
            canvas.drawCircle(marginLeft - 30,height-(list.get(i-1)),10, paintRect);
            if(i==1){
                canvas.drawLine(pointX,pointY,marginLeft-30,height-(list.get(i-1)),paintXY);
            }
            if(!(i==xData.length)){
                canvas.drawLine(marginLeft-30,height-(list.get(i-1)),pointX + scaleX * (i+1)-30,height-(list.get(i)),paintXY);
            }
        }
        //画Y轴数据
        for(int i=1;i<=yData.length;i++){
            int marginTop = scaleY * i;
            canvas.drawText(yData[i-1],pointX,pointY-marginTop,paintValue);
        }
    }
}
