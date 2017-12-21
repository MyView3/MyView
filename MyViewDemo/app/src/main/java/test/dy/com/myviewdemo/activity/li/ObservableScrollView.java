package test.dy.com.myviewdemo.activity.li;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by dy on 2017/12/21.
 */

public class ObservableScrollView extends ScrollView {

    private ScrollViewListener scrollViewListener=null;
    public interface ScrollViewListener{
        void onScrollChanged(ObservableScrollView scrollView,int x,int y,int oldx,int oldy);
    }
    public void setScrollViewListener (ScrollViewListener scrollViewListener){
        this.scrollViewListener=scrollViewListener;
    }


    private OnScrollListener onScrollListener=null;
    public interface OnScrollListener{
        void onScroll(int scrollY);
    }
    public void setOnScrollListener(OnScrollListener onScrollListener){
        this.onScrollListener=onScrollListener;
    }

    public ObservableScrollView(Context context) {
        this(context,null);
    }

    public ObservableScrollView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ObservableScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if(scrollViewListener != null){
            scrollViewListener.onScrollChanged(this,l,t,oldl,oldt);
        }
        if(onScrollListener != null){
            onScrollListener.onScroll(t);
        }
    }
}
