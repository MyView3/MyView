package test.dy.com.myviewdemo.activity.bai;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;

import test.dy.com.myviewdemo.R;
import test.dy.com.myviewdemo.activity.bai.BaiView.MyScrollView1;

public class jian_xiActivity extends AppCompatActivity {

    private RelativeLayout tv_show;
    private TextView textView;
    private int height;
    private int tv_height;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jian_xi);


        MyScrollView1 scrollView = (MyScrollView1) findViewById(R.id.id_scrollview);
        tv_show = (RelativeLayout) findViewById(R.id.id_xianshi);
        textView = (TextView) findViewById(R.id.textview);
        final RelativeLayout id_img = (RelativeLayout) findViewById(R.id.id_img);

        id_img.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {



            @Override
            public void onGlobalLayout() {
                height = id_img.getHeight();
                tv_height = textView.getHeight();
            }
        });



        scrollView.setScrollViewListener(new MyScrollView1.ScrollViewListener() {
            @Override
            public void onScrollChanged(MyScrollView1 myScrollView1, int l, int t, int oldl, int oldt) {
                if(t>=height-tv_height){
                    tv_show.setVisibility(View.VISIBLE);

                }else{
                    tv_show.setVisibility(View.GONE);

                }

                if (t <= 0) {
                    textView.setBackgroundColor(Color.argb((int) 0, 227, 29, 26));//AGB由相关工具获得，或者美工提供
                } else if (t> 0 && t <= height-tv_height) {
                    float scale = (float) t / height;
                    float alpha = (255 * scale);
                    // 只是layout背景透明(仿知乎滑动效果)
                    textView.setBackgroundColor(Color.argb((int) alpha, 227, 29, 26));
                } else {
                    textView.setBackgroundColor(Color.argb((int) 255, 227, 29, 26));
                }
            }
        });


    }
}
