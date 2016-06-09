# CustomAnimation
自定义动画
Matrix，中文里叫矩阵，高等数学里有介绍，在图像处理方面，主要是用于平面的缩放、平移、旋转等操作。
 在Android里面，Matrix由9个float值构成，是一个3*3的矩阵
 
 ==Matrix==
 
  ====注意：后调用的pre操作先执行，而后调用的post操作则后执行。== set方法一旦调用即会清空之前matrix中的所有变换，例如：==
  * 1.matrix.preScale(0.5f, 1);
 2.matrix.preTranslate(10, 0);
 3.matrix.postScale(0.7f, 1);
 4.matrix.postTranslate(15, 0);

 等价于：

 translate(10, 0) -> scale(0.5f, 1) -> scale(0.7f, 1) -> translate(15, 0)

 注意：后调用的pre操作先执行，而后调用的post操作则后执行。

 set方法一旦调用即会清空之前matrix中的所有变换，例如：
 1.matrix.preScale(0.5f, 1);
 2.matrix.setScale(1, 0.6f);
 3.matrix.postScale(0.7f, 1);
 4.matrix.preTranslate(15, 0);

 等价于

 translate(15, 0) -> scale(1, 0.6f) ->  scale(0.7f, 1)

 matrix.preScale (0.5f, 1)将不起作用。
  
  Matrix 的主要方法
    
    preScale(sx,sy);  //缩放图片后靠左对齐
    preScale(sx,sy,px,py); //向中心（px,py）缩放
    sx ,sy 如果取值范围是0~1f, 值越小缩的越小
    sx ,sy 如果取值1 不缩放
    sx ,sy 如果大于1 值越大放大的越大
    
Matrix 可以处理图片旋转平移等，还可以变换view的动画    
  
