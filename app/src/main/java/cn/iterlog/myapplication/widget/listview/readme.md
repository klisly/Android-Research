使用技巧：
1.使用ViewHolder模式提高ListView使用效率，推测能提高50%效率
2.给ListView设置分割线，只需设置如下两个属性：
  android:divider="#000" //设置分割线显示颜色, 也可以设置Drawable
  android:dividerHeight="1px" //此处非0，否则无效
3.隐藏ListView滚动条
  android:scrollbars = "none"
4.取消item的点击效果
  android:listSelector="#00000000" //设置透明
5.设置ListView要显示再第几页
  listView.setSelection(N)
  
  如果要平滑移动
    mListView.smoothScrollToPosition(15);
    如果再页面初始化的时候调用该方法会失效， 可以如下操作
    mListView.post(new Runnable() {
                @Override
                public void run() {
                    mListView.smoothScrollToPosition(15);
    
                }
            });
6.动态修改
    mData.add("new");
    mAdapter.notifyDataSetChanged();
7.遍历所有的item
    for (int i = 0; i < mListView.getChildCount(); i++) {
        View view = mListView.getChildAt(i);
    }
8.ListView弹性滑动
    
    
  好文推荐：http://www.cnblogs.com/SZ2015/p/4558462.html
  给ListView设置分割线，只需设置如下两个属性：
  重写
    @Override
      protected boolean overScrollBy(int deltaX, int deltaY,
                                     int scrollX, int scrollY,
                                     int scrollRangeX, int scrollRangeY,
                                     int maxOverScrollX, int maxOverScrollY,
                                     boolean isTouchEvent) {
          return super.overScrollBy(deltaX, deltaY,
                  scrollX, scrollY,
                  scrollRangeX, scrollRangeY,
                  maxOverScrollX, mMaxOverDistance,
                  isTouchEvent);
      }
      
  android:divider="#000" //设置分割线显示颜色
  
  android:dividerHeight="1px" //此处非0，否则无效
  
  <ListView android:id="@+id/listView"         
  
      android:layout_width="fill_parent"        
      
      android:layout_height="fill_parent"         
      
      android:divider="#FFF"        
      
      android:dividerHeight="1px"        
      
      android:layout_margin="10dip"/> 
  
   
  
  个人认为比较特别的属性，通过设置这样的属性可以做出更加美观的列表
  
   
  
  首先是stackFromBottom属性，这只该属性之后你做好的列表就会显示你列表的最下面，值为true和false
  
  android:stackFromBottom="true"
  
         
  
  第二是transciptMode属性，需要用ListView或者其它显示大量Items的控件实时跟踪或者查看信息，并且希望最新的条目可以自动滚动到可视范围内。通过设置的控件transcriptMode属性可以将Android平台的控件（支持ScrollBar）自动滑动到最底部。 android:transcriptMode="alwaysScroll" 
  
   
  
  第三cacheColorHint属性，很多人希望能够改变一下它的背景，使他能够符合整体的UI设计，改变背景背很简单只需要准备一张图片然后指定属性android:background="@drawable/bg"，不过不要高兴地太早，当你这么做以后，发现背景是变了，但是当你拖动，或者点击list空白位置的时候发现ListItem都变成黑色的了，破坏了整体效果。
  
  如果你只是换背景的颜色的话，可以直接指定android:cacheColorHint为你所要的颜色，如果你是用图片做背景的话，那也只要将android:cacheColorHint指定为透明（#00000000）就可以了
  
   
  
  第四divider属性，该属性作用是每一项之间需要设置一个图片做为间隔，或是去掉item之间的分割线
  
  android:divider="@drawable/list_driver"  其中  @drawable/list_driver 是一个图片资源，如果不想显示分割线则只要设置为android:divider="@drawable/@null"就可以了
  
   
  
  第五fadingEdge属性，上边和下边有黑色的阴影
  
  android:fadingEdge="none"设置后没有阴影了~
  
   
  
  第六scrollbars属性，作用是隐藏listView的滚动条，
  
  android:scrollbars="none"与setVerticalScrollBarEnabled(true);的效果是一样的，不活动的时候隐藏，活动的时候也隐藏
  
   
  
  第七fadeScrollbars属性，android:fadeScrollbars="true"  配置ListView布局的时候，设置这个属性为true就可以实现滚动条的自动隐藏和显示。
  
   
  
  第八fastScrollEnabled属性 ,
  
  很多开发者不知道ListView列表控件的快速滚动滑块是如何启用的，这里Android开发网告诉大家，
  辅助滚动滑块只需要一行代码就可以搞定，如果你使用XML布局只需要在ListView节点中加入 
   android:fastScrollEnabled="true" 这个属性即可，
   而对于Java代码可以通过myListView.setFastScrollEnabled(true); 
   来控制启用，参数false为隐藏。 还有一点就是当你的滚动内容较小，
   不到当前ListView的3个屏幕高度时则不会出现这个快速滚动滑块，
   同时该方法仍然是AbsListView的基础方法，可以在ListView或GridView等子类中使用快速滚动辅助。
  
   
  
  第九drawSelectorOnTop属性
  
  When set to true, the selector will be drawn over the selecteditem. Otherwise the selector is drawn behind the selected item. Thedefault value is false.
  
  android:drawSelectorOnTop="true" 点击某一条记录，颜色会显示在最上面，记录上的文字被遮住，所以点击文字不放，文字就看不到
  
  android:drawSelectorOnTop="false"点击某条记录不放，颜色会在记录的后面，成为背景色，但是记录内容的文字是可见的 
  
   
  
  关于Android ListView组件中android:drawSelectorOnTop含义 
  
  android:drawSelectorOnTop="true"  点击某一条记录，颜色会显示在最上面，记录上的文字被遮住，所以点击文字不放，文字就看不到。 
  
  android:drawSelectorOnTop="false" 点击某条记录不放，颜色会在记录的后面，成为背景色，但是记录内容的文字是可见的 
  
  Read the docs of ListActivity.It says you should have a ListView with the id: android:id="@android:id/list". 
  
  ListView列表控件的快速滚动滑块是如何启用的 （android通讯录中手动拖动滚动条滑动效果如何添加）？
  
  
  在listView很多数据，但是加载的很慢，可以加入一个属性来提高　android:fastScrollEnabled="true" 
  
  <ListView android:layout_height="fill_parent" 
          android:layout_width="fill_parent" 
          android:id="@+id/android:list" 
          android:fastScrollEnabled="true"></ListView> 