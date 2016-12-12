package cn.iterlog.myapplication.widget;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import cn.iterlog.myapplication.BaseActivity;
import cn.iterlog.myapplication.R;
import cn.iterlog.myapplication.bottomnavigationViewpager.MainActivity;
import cn.iterlog.myapplication.component.service.MessenagerServiceActivity;
import cn.iterlog.myapplication.component.service.RemoteServiceActivity;

public class WidgetActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget);
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WidgetActivity.this, MainActivity.class));
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WidgetActivity.this, SearchActivity.class));
            }
        });

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WidgetActivity.this, RemoteServiceActivity.class));
            }
        });

        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WidgetActivity.this, MessenagerServiceActivity.class));
            }
        });

    }


}
