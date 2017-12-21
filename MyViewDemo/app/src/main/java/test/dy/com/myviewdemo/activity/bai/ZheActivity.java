package test.dy.com.myviewdemo.activity.bai;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

import test.dy.com.myviewdemo.R;
import test.dy.com.myviewdemo.activity.bai.BaiView.custom_view;

public class ZheActivity extends AppCompatActivity {

    private String[] xData = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六","杜岩"};
    private String[] yData = {"100", "200", "300", "400", "500", "600", "700", "800", "900", "1000"};
    private List<Integer> list = Arrays.asList(300,200,460,120,730,920,80,500);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhe);
        custom_view custom_view = (test.dy.com.myviewdemo.activity.bai.BaiView.custom_view) findViewById(R.id.custom_view);

        custom_view.initdata(xData,yData,list);
    }
}
