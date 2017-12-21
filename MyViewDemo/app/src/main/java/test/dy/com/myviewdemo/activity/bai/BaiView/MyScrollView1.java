package test.dy.com.myviewdemo.activity.bai.BaiView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by 31962 on 2017/12/19.
 */

public class MyScrollView1 extends ScrollView {

    public ScrollViewListener scrollViewListener = null;
    public MyScrollView1(Context context) {
        super(context);
    }

    public MyScrollView1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }



   public void setScrollViewListener(ScrollViewListener scrollViewListener){
       this.scrollViewListener = scrollViewListener;

   }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if(scrollViewListener!=null){
            scrollViewListener.onScrollChanged(this,l,t,oldl,oldt);

        }
    }

    public interface ScrollViewListener {
        void onScrollChanged(MyScrollView1 myScrollView1, int l, int t, int oldl, int oldt);
    }

}
