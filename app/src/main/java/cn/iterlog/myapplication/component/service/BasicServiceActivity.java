package cn.iterlog.myapplication.component.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

import butterknife.ButterKnife;
import cn.iterlog.myapplication.BaseActivity;
import cn.iterlog.myapplication.R;

public class BasicServiceActivity extends BaseActivity {
    BasicService service;
    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            //Servie的OnBind方法需要返回binde对象
            BasicService.MyBinder myBinder = (BasicService.MyBinder) iBinder;
            service = myBinder.getService();
            handler.post(runnable);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            // 类ServiceConnection中的onServiceDisconnected()方法在正常情况下是不被调用的,
            // 它的调用时机是当Service服务被异外销毁时,例如内存的资源不足时
            // stopService和unBindService不会回调

            // This is called when the connection with the service has been
            // unexpectedly disconnected -- that is, its process crashed.
            // Because it is running in our same process, we should never
            // see this happen.
            service = null;
        }
    };

    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (service != null) {
                Log.i(BasicServiceActivity.class.getSimpleName(), "get num:" + service.getCount());
                handler.postDelayed(runnable, 1000);
            } else {
                Log.i(BasicServiceActivity.class.getSimpleName(), "service is numm");
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_basic);
        ButterKnife.bind(this);
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(new Intent(BasicServiceActivity.this, BasicService.class));
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(new Intent(BasicServiceActivity.this, BasicService.class));
            }
        });
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bindService(new Intent(BasicServiceActivity.this, BasicService.class), connection, BIND_AUTO_CREATE);
            }
        });
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                service = null;
                try {
                    unbindService(connection);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(service != null){
                    service.showDialog();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(service != null) {
            unbindService(connection);
        }
    }
}
