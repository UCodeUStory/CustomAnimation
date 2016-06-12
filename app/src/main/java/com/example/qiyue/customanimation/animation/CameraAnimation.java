package com.example.qiyue.customanimation.animation;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

/**
 * Created by qiyue on 2016/6/10.
 */
public class CameraAnimation extends Animation {
    int mCenterX,mCenterY;

    Camera camera = new Camera();

    public CameraAnimation() {

    }

    @Override
    public void initialize(int width, int height, int parentWidth,
                           int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        //初始化中间坐标
        mCenterX = width/2;
        mCenterY = height/2;

        setDuration(2000);
        setFillAfter(true);
        setInterpolator(new LinearInterpolator());
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        Matrix matrix = t.getMatrix();
        camera.save();
        //x, y, z 由远到近
        camera.translate(0f, 0f, (1300 - 1300*interpolatedTime));
        //慢慢旋转360度
        camera.rotateY(360*interpolatedTime);
        camera.getMatrix(matrix);
        matrix.preTranslate(-mCenterX, -mCenterY);
        matrix.postTranslate(mCenterX,mCenterY);
        camera.restore();
    }
}
/**
 matrix.setScale(interpolatedTime, interpolatedTime);
 matrix.preTranslate(-centerX, -centerY);
 matrix.postTranslate(centerX, centerY);

 经常在中心缩放的应用中看到这段代码.

 preTranslate是指在setScale前,平移,postTranslate是指在setScale后平移

 注意他们参数是平移的距离,而不是平移目的地的坐标!

 由于缩放是以(0,0)为中心的,所以为了把界面的中心与(0,0)对齐,就要preTranslate(-centerX, -centerY),

 setScale完成后,调用postTranslate(centerX, centerY),再把图片移回来,这样看到的动画效果就是activity的界面图片从中心不停的缩放了

 注:centerX和centerY是界面中心的坐标
**/