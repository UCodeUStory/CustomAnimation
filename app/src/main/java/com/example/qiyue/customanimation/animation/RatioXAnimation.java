package com.example.qiyue.customanimation.animation;

import android.graphics.Matrix;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by qiyue on 2016/6/9.
 *
 */
public class RatioXAnimation extends Animation{


    private int halfWidth;

    private int halfHeight;

    /**
     * 动画初始化方法
     * @param width 开启动画view的宽度
     * @param height
     * @param parentWidth
     * @param parentHeight
     */
    @Override
    public void initialize(int width, int height, int parentWidth,
                           int parentHeight) {

        super.initialize(width, height, parentWidth, parentHeight);
        /** 设置完成时间 **/
        setDuration(1500);
        /**fillBefore（true）是指动画结束时画面停留在第一帧**/
        /** 动画结束时画面停留在最后一帧不消失**/
        setFillAfter(true);
        //保存View的中心点
        halfWidth = width / 2;
        halfHeight = height / 2;
        /**设置加减速插值器**/
        setInterpolator(new AccelerateDecelerateInterpolator());

    }

    /**
     * applyTransformation 一直会被调用，interpolatedTime 重0变化到1，1表示动画完成
     * @param interpolatedTime
     * @param t
     */
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        /**矩阵变换 **/
        /** interpolatedTime**/
        /** Matrix，中文里叫矩阵，高等数学里有介绍，在图像处理方面，主要是用于平面的缩放、平移、旋转等操作。
         在Android里面，Matrix由9个float值构成，是一个3*3的矩阵
         **/
        final Matrix matrix = t.getMatrix();
        if (interpolatedTime < 0.8) {
           // matrix.preScale(2f, 1,halfWidth,halfHeight);
            matrix.preScale(1+interpolatedTime, 1-interpolatedTime/0.8f,halfWidth,halfHeight);
        }else{
            matrix.preScale(7.5f*(1-interpolatedTime),0.01f,halfWidth,halfHeight);
        }
    }



}
