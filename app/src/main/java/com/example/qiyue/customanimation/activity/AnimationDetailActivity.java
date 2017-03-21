package com.example.qiyue.customanimation.activity;

import android.app.Activity;

/**
 * Created by Administrator on 2016/8/2 0002.
*/

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qiyue.customanimation.R;
import com.example.qiyue.customanimation.uitl.UiUtil;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.view.ViewHelper;


public class AnimationDetailActivity extends Activity implements View.OnClickListener{
    private static final String TAG = "YanZi";

    Button btn_start_anim;
    Button btn_reset_pos;
    Button btn_start_anim2;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_detail);
        initData();
        initUI();
    }

    private void initData(){
        UiUtil.initialize(getApplicationContext());
    }
    private void initUI(){
        btn_start_anim = (Button)findViewById(R.id.btn_start_anim);
        btn_start_anim.setOnClickListener(this);
        btn_start_anim2 = (Button)findViewById(R.id.btn_start_anim2);
        btn_start_anim2.setOnClickListener(this);
        btn_reset_pos = (Button)findViewById(R.id.btn_reset_pos);
        btn_reset_pos.setOnClickListener(this);
        text = (TextView)findViewById(R.id.text);
        text.setOnClickListener(this);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams)text.getLayoutParams();
        params.leftMargin = 0;
        params.rightMargin = 0;
        params.setMargins(0, 0, 0, 0);
        text.setLayoutParams(params);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_start_anim:
                playAnim1();
                break;
            case R.id.btn_start_anim2:
                //View动画
                playAnim2();
                break;
            case R.id.btn_reset_pos:
                resetPos();
                break;
            case R.id.text:
                printParams();
                break;
            default:break;
        }
    }

    public void printParams(){
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams)text.getLayoutParams();
        if(params != null){
            String s =  "leftMargin = " + params.leftMargin + " rightMargin = " + params.rightMargin
                    + " getLeft = " + text.getLeft() + " getRight = " + text.getRight() + " getWidth = " + text.getWidth();
            Log.i(TAG, s);
            int[] pos = new int[2];
            text.getLocationInWindow(pos);
            Log.i(TAG, "location, x = " + pos[0] + " y = " + pos[1]);
            Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
        }
    }
    private void playAnim1(){
        /**translationX 属性和margin是平级的属性，translationX改变margin不改变，但是效果和margin一样
         *
         */
        int w = text.getWidth();
        int screenW = UiUtil.getScreenWidth();
        int transX = screenW - w;
        ObjectAnimator transAnim = ObjectAnimator.ofFloat(text, "translationX", 0, transX);
        transAnim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        transAnim.setDuration(300);
        transAnim.start();
    }
    private void resetPos(){
        ViewHelper.setTranslationX(text, 0);
    }

    private void playAnim2(){
        int w = text.getWidth();
        int screenW = UiUtil.getScreenWidth();
        int transX = screenW - w;
        /**
         * 计算平移距离
         */
        TranslateAnimation transAnim = new TranslateAnimation(0, transX, 0, 0);
        transAnim.setDuration(300);
        /**
         * 这里设置true ,动画显示在结束位置，但是本身位置信息没有变化，点击事件还是不好使，而点击原来位置才可以
         * ，可以通过将setFillAfter设置成false,然后在onAnimationEnd处更新LayoutParams参数
         */
        transAnim.setFillAfter(false);
        transAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                updateParams();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        text.startAnimation(transAnim);
    }


    private void updateParams(){
        int w = text.getWidth();
        int screenW = UiUtil.getScreenWidth();
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) text.getLayoutParams();
        params.leftMargin = screenW - w;
        text.setLayoutParams(params);
    }
}
