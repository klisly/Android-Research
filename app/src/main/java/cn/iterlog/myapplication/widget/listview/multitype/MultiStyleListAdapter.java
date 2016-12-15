package cn.iterlog.myapplication.widget.listview.multitype;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import cn.iterlog.myapplication.R;
import cn.iterlog.myapplication.widget.listview.multitype.model.Data1;
import cn.iterlog.myapplication.widget.listview.multitype.model.Data2;
import cn.iterlog.myapplication.widget.listview.multitype.model.Data3;
import cn.iterlog.myapplication.widget.listview.multitype.model.Data4;

public class MultiStyleListAdapter extends AbstractListAdapter<Object> {
	private Class[] dataClasses;

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		int viewType=getItemViewType(position);
		if (viewType==0) {
			view = getStyle1View(position, view, parent);
		}else if (viewType==1) {
			view = getStyle2View(position, view, parent);
		} else if(viewType==2){
			view = getStyle3View(position, view, parent);
		}else if(viewType==3){
			view=getStyle4View(position, view, parent);
		}

		return view;
	}

	public MultiStyleListAdapter(Context context) {
		super(context);
		dataClasses=new Class[]{Data1.class,Data2.class,Data3.class,Data4.class};
	}

    /**
     * 注意返回的类型：
     * 如果只有1种布局类型，那么返回的type是0；
     * 如果2种类型，必须是0,1
     * 如果3种类型，必须是0,1,2
     * 。。。。
     * 依次类推
     * @param position 根据position返回对应位置的视图类型
     * @return
     */
	@Override
	public int getItemViewType(int position) {
		// TODO Auto-generated method stub
		Object object=getItem(position);
		for(int i=0,size=dataClasses.length;i<size;i++){
			if(object.getClass()== dataClasses[i]){
				return i;
			}
		}
		return 0;
	}

    /**
     * @return 返回值是，布局种类总数
     */
	@Override
	public int getViewTypeCount() {
		// TODO Auto-generated method stub
		return dataClasses.length;
	}
	

	private View getStyle1View(final int position, View convertView,
			ViewGroup parent) {
		final Styly1ViewHolder holder;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_style_1, null);
			holder = new Styly1ViewHolder(convertView);
			convertView.setTag(holder);
		} else {
			holder = (Styly1ViewHolder) convertView.getTag();
		}
		final Data1 item=(Data1)mList.get(position);
		holder.tvIndex.setText("index="+position);
		holder.content.setText(item.content);
		return convertView;
	}

	private View getStyle2View(final int position, View convertView,
							   ViewGroup parent) {
		final Styly2ViewHolder holder;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_style_2, null);
			holder = new Styly2ViewHolder(convertView);
			convertView.setTag(holder);
		} else {
			holder = (Styly2ViewHolder) convertView.getTag();
		}
		final Data2 item=(Data2)mList.get(position);
		holder.tvIndex.setText("index="+position);
		holder.pic.setImageResource(item.img);
		return convertView;
	}

	private View getStyle3View(final int position, View convertView,
							   ViewGroup parent) {
		final Styly3ViewHolder holder;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_style_3, null);
			holder = new Styly3ViewHolder(convertView);
			convertView.setTag(holder);
		} else {
			holder = (Styly3ViewHolder) convertView.getTag();
		}
		final Data3 item=(Data3)mList.get(position);
		holder.tvIndex.setText("index="+position);
		holder.pic1.setImageResource(item.img1);
		holder.pic2.setImageResource(item.img2);
		holder.pic3.setImageResource(item.img3);
		return convertView;
	}

	private View getStyle4View(final int position, View convertView,
							   ViewGroup parent) {
		final Styly4ViewHolder holder;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_style_4, null);
			holder = new Styly4ViewHolder(convertView);
			convertView.setTag(holder);
		} else {
			holder = (Styly4ViewHolder) convertView.getTag();
		}
		final Data4 item=(Data4)mList.get(position);
		holder.tvIndex.setText("index="+position);
		holder.checkBox.setText(item.content);
		holder.checkBox.setChecked(item.isChecked);
		return convertView;
	}


	class Styly1ViewHolder {
		TextView tvIndex;
		TextView content;
		
		public Styly1ViewHolder(View root){
			content=(TextView)root.findViewById(R.id.content);
			tvIndex=(TextView)root.findViewById(R.id.index);
		}

	}

	class Styly2ViewHolder {
		TextView tvIndex;
		ImageView pic;

		public Styly2ViewHolder(View root){
			pic=(ImageView)root.findViewById(R.id.content);
			tvIndex=(TextView)root.findViewById(R.id.index);
		}

	}

	class Styly3ViewHolder {
		TextView tvIndex;
		ImageView pic1;
		ImageView pic2;
		ImageView pic3;

		public Styly3ViewHolder(View root){
			pic1=(ImageView)root.findViewById(R.id.img1);
			pic2=(ImageView)root.findViewById(R.id.img2);
			pic3=(ImageView)root.findViewById(R.id.img3);
			tvIndex=(TextView)root.findViewById(R.id.index);
		}

	}

	class Styly4ViewHolder {
		TextView tvIndex;
		CheckBox checkBox;

		public Styly4ViewHolder(View root){
			checkBox=(CheckBox)root.findViewById(R.id.checkbox);
			tvIndex=(TextView)root.findViewById(R.id.index);
		}

	}


}
