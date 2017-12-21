package test.dy.com.myviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import test.dy.com.myviewdemo.activity.bai.BaiActivity;
import test.dy.com.myviewdemo.activity.ChangActivity;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @butterknife.OnClick({R.id.czf, R.id.by, R.id.lyh, R.id.dy})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.czf:
                Intent intent = new Intent(MainActivity.this, ChangActivity.class);
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
}
