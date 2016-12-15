package cn.iterlog.myapplication.widget.listview.multitype;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cn.iterlog.myapplication.R;
import cn.iterlog.myapplication.widget.listview.multitype.model.Data1;
import cn.iterlog.myapplication.widget.listview.multitype.model.Data2;
import cn.iterlog.myapplication.widget.listview.multitype.model.Data3;
import cn.iterlog.myapplication.widget.listview.multitype.model.Data4;

public class MultiActivity extends AppCompatActivity {

    private ListView mListview;
    private MultiStyleListAdapter mAdapter;
    List<Object> dataAll=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_listview);
        mListview=(ListView)findViewById(R.id.list_view);
        mAdapter=new MultiStyleListAdapter(this);
        mListview.setAdapter(mAdapter);
        for(int i = 0; i< 100000; i++){
            createData();
        }
        mAdapter.notifyDataSetChanged();
    }

    private void createData(){
        dataAll.add(new Data1("打开链接快乐大脚"));
        dataAll.add(new Data2(R.drawable.ic_account_box_black_24dp));
        dataAll.add(new Data2(R.drawable.ic_account_box_black_24dp));
        dataAll.add(new Data1("萨达姆分，吗，"));
        dataAll.add(new Data3(R.drawable.ic_account_box_black_24dp,R.drawable.ic_account_box_black_24dp,R.drawable.ic_account_box_black_24dp));
        dataAll.add(new Data4("昂啥呢",true));
        dataAll.add(new Data3(R.drawable.ic_account_box_black_24dp,R.drawable.ic_account_box_black_24dp,R.drawable.ic_account_box_black_24dp));
        dataAll.add(new Data1("萨达姆分，吗，"));
        dataAll.add(new Data2(R.drawable.ic_account_box_black_24dp));
        dataAll.add(new Data2(R.drawable.ic_account_box_black_24dp));
        dataAll.add(new Data2(R.drawable.ic_account_box_black_24dp));
        dataAll.add(new Data1("暗红色的尽快和圣诞节快放假"));
        dataAll.add(new Data1("跨境开理发店了"));
        dataAll.add(new Data1("1434"));
        dataAll.add(new Data1("地方"));
        dataAll.add(new Data1("主线程执行"));
        dataAll.add(new Data4("ansdklma,sdm,",true));
        dataAll.add(new Data4("撒角度看",true));
        dataAll.add(new Data3(R.drawable.ic_account_box_black_24dp,R.drawable.ic_account_box_black_24dp,R.drawable.ic_account_box_black_24dp));
        dataAll.add(new Data1("暗红色的尽快和圣诞节快放假"));
        dataAll.add(new Data1("13123123"));
        dataAll.add(new Data1("154667678"));

        mAdapter.setList(dataAll);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dataAll.clear();
        dataAll = null;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

