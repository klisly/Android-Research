package cn.iterlog.myapplication.widget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;

import cn.iterlog.myapplication.R;
import cn.iterlog.myapplication.widget.dummy.DummyContent;

public class SearchActivity extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener {
    private String TAG = SearchActivity.class.getSimpleName();
    private SearchView mSearchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        mSearchView = (SearchView) findViewById(R.id.searchView);
        // 设置搜索文本监听
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            // 当点击搜索按钮时触发该方法
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.i(TAG,"query String:"+query);
                return false;
            }

            // 当搜索内容改变时触发该方法
            @Override
            public boolean onQueryTextChange(String newText) {
                Log.i(TAG,"String:"+newText);
                return false;
            }
        });
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frameLayout, ItemFragment.newInstance(12))
                .commit();

    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}
