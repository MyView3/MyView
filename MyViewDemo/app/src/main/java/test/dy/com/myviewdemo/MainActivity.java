package test.dy.com.myviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import test.dy.com.myviewdemo.activity.bai.BaiActivity;
import test.dy.com.myviewdemo.activity.bai.BaiView.PiaoActivity;
import test.dy.com.myviewdemo.activity.bai.Bezier2Activity;
import test.dy.com.myviewdemo.activity.bai.Bezier3Activity;
import test.dy.com.myviewdemo.activity.bai.WaveActivity;
import test.dy.com.myviewdemo.activity.bai.ZheActivity;
import test.dy.com.myviewdemo.activity.bai.jian_xiActivity;
import test.dy.com.myviewdemo.activity.chang.Xuan;
import test.dy.com.myviewdemo.activity.du.DuActivity;
import test.dy.com.myviewdemo.activity.li.LiActivity;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.czf)
    Button mCzf;
    @BindView(R.id.by)
    Button mBy;
    @BindView(R.id.lyh)
    Button mLyh;
    @BindView(R.id.dy)
    Button mDy;
    @BindView(R.id.erjie)
    Button erjie;
    @BindView(R.id.sanjie)
    Button sanjie;
    @BindView(R.id.zz)
    Button zz;
    @BindView(R.id.jb_xd)
    Button jbXd;
    @BindView(R.id.px)
    Button px;
    @BindView(R.id.water)
    Button water;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.czf, R.id.by, R.id.lyh, R.id.dy})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.czf:
                Intent intent = new Intent(MainActivity.this, Xuan.class);
                startActivity(intent);
                break;
            case R.id.by:
                Intent intent2 = new Intent(MainActivity.this, BaiActivity.class);
                startActivity(intent2);
                break;
            case R.id.lyh:
                Intent inten3 = new Intent(MainActivity.this, LiActivity.class);
                startActivity(inten3);
                break;
            case R.id.dy:
                Intent inten4 = new Intent(MainActivity.this, DuActivity.class);
                startActivity(inten4);
                break;
        }
    }

    @OnClick({R.id.erjie, R.id.sanjie, R.id.zz, R.id.jb_xd,R.id.px, R.id.water})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.erjie:
                Intent intent = new Intent(MainActivity.this, Bezier2Activity.class);
                startActivity(intent);
                break;
            case R.id.sanjie:

                startActivity(new Intent(MainActivity.this, Bezier3Activity.class));
                break;
            case R.id.zz:
                startActivity(new Intent(MainActivity.this, ZheActivity.class));
                break;
            case R.id.jb_xd:
                startActivity(new Intent(MainActivity.this, jian_xiActivity.class));
                break;
            case R.id.px:
                startActivity(new Intent(MainActivity.this, PiaoActivity.class));
                break;
            case R.id.water:
                startActivity(new Intent(MainActivity.this, WaveActivity.class));

                break;
        }
    }



}
