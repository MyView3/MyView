package test.dy.com.myviewdemo.activity.chang;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import test.dy.com.myviewdemo.R;

/**
 * Created by Administrator on 2017/12/22.
 */

public class Xuan extends AppCompatActivity {

    private Button resetBtn, msgCountBtn;
    private DragBallView dragBallView;
    private EditText msgCountEt;


    private AnimationButton animationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fei_activity);
        animationButton = (AnimationButton) findViewById(R.id.animation_btn);

        resetBtn = (Button) findViewById(R.id.reset_btn);
        msgCountBtn = (Button) findViewById(R.id.msg_count_btn);
        dragBallView = (DragBallView) findViewById(R.id.drag_ball_view);
        msgCountEt = (EditText) findViewById(R.id.msg_count_et);

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dragBallView.reset();
            }
        });

        msgCountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(msgCountEt.getText().toString().trim())) {
                    int count = Integer.valueOf(msgCountEt.getText().toString().trim());
                    dragBallView.setMsgCount(count);
                }
            }
        });

        dragBallView.setOnDragBallListener(new DragBallView.OnDragBallListener() {
            @Override
            public void onDisappear() {
                Toast.makeText(Xuan.this, "消失了", Toast.LENGTH_SHORT).show();
            }
        });


        animationButton.setAnimationButtonListener(new AnimationButton.AnimationButtonListener() {
            @Override
            public void onClickListener() {

                animationButton.start();
            }

            @Override
            public void animationFinish() {
                Toast.makeText(Xuan.this, "执行完毕", Toast.LENGTH_SHORT).show();
//                finish();
            }
        });


    }


}
