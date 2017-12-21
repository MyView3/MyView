package test.dy.com.myviewdemo.activity.li;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import test.dy.com.myviewdemo.R;

public class LiActivity extends AppCompatActivity implements ObservableScrollView.ScrollViewListener, ObservableScrollView.OnScrollListener {

    @BindView(R.id.imageview)
    ImageView mImageview;

    @BindView(R.id.scrollview)
    ObservableScrollView mScrollview;
    @BindView(R.id.top_re)
    LinearLayout mTopRe;
    @BindView(R.id.top)
    LinearLayout mTop;
    @BindView(R.id.textview)
    TextView mTextview;

    private List<String> list = new ArrayList<>();
    private int imageHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_li);
        ButterKnife.bind(this);
        initListener();
    }

    private void initListener() {
        ViewTreeObserver vto = mImageview.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                mImageview.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                imageHeight = mImageview.getHeight();
                mScrollview.setScrollViewListener((ObservableScrollView.ScrollViewListener) LiActivity.this);
                mScrollview.setOnScrollListener(LiActivity.this);
            }
        });

    }

    @Override
    public void onScrollChanged(ObservableScrollView scrollView, int x, int y, int oldx, int oldy) {
        if (y <= 0) {
            mTextview.setBackgroundColor(Color.argb((int) 0, 227, 29, 26));
        } else if (y > 0 && y <= imageHeight) {
            float scale = (float) y / imageHeight;
            float alpha = (255 * scale);
            mTextview.setBackgroundColor(Color.argb((int) alpha, 227, 29, 26));
        } else {
            mTextview.setBackgroundColor(Color.argb((int) 255, 227, 29, 26));
        }
    }

    @Override
    public void onScroll(int scrollY) {

        Log.i("TAG", scrollY + "aaa");
        if (scrollY > imageHeight - mTop.getHeight()) {
            mTopRe.setVisibility(View.VISIBLE);
            mTop.setVisibility(View.INVISIBLE);
        } else {
            mTopRe.setVisibility(View.GONE);
        }
    }
}
