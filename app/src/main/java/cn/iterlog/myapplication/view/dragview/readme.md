拖动控件的7大方法
1.layout
相对坐标，getX(), getY()
 layout(getLeft() + offsetX,
                        getTop() + offsetY,
                        getRight() + offsetX,
                        getBottom() + offsetY);
2.layout
绝对坐标，getRawX(), getRawY()

 layout(getLeft() + offsetX,
                        getTop() + offsetY,
                        getRight() + offsetX,
                        getBottom() + offsetY);  
3.改变控件的LayoutParams
  int offsetX = x - lastX;
                int offsetY = y - lastY;
                ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
//                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
                layoutParams.leftMargin = getLeft() + offsetX;
                layoutParams.topMargin = getTop() + offsetY;
                setLayoutParams(layoutParams);
4.父控件 scrollBy / scrollTo的方式 这类方式可以方便重置位置
   ((View) getParent()).scrollBy(-offsetX, -offsetY);

5.offset实现
 int offsetX = rawX - lastX;
                int offsetY = rawY - lastY;
                // 在当前left、top、right、bottom的基础上加上偏移量
                offsetLeftAndRight(offsetX);
                offsetTopAndBottom(offsetY);
                
6.ViewDragHelper  
             