package cn.iterlog.myapplication.widget.listview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cn.iterlog.myapplication.R;
import cn.iterlog.myapplication.widget.listview.multitype.MultiActivity;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }


    public void btnViewHolder(View view) {
        startActivity(new Intent(this, ListViewHolderScrollHideActivity.class));
    }


    public void btnFlexible(View view) {
        startActivity(new Intent(this, OverScrollActivity.class));
    }


    public void btnMultiType(View view) {
        startActivity(new Intent(this, MultiActivity.class));
    }

}
