package cn.iterlog.myapplication.component.common;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import cn.iterlog.myapplication.BaseActivity;
import cn.iterlog.myapplication.R;

public class CommonActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CommonActivity.this, AsynTaskActivity.class));
            }
        });


    }


}
