package cn.iterlog.myapplication.component.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;

import butterknife.ButterKnife;
import cn.iterlog.myapplication.BaseActivity;
import cn.iterlog.myapplication.R;

/**
 * IntentService与Service的区别
 * 从属性 & 作用上来说
 * Service：依赖于应用程序的主线程（不是独立的进程 or 线程）
 * <p>
 * 不建议在Service中编写耗时的逻辑和操作，否则会引起ANR；
 * IntentService：创建一个工作线程来处理多线程任务
 * <p>
 * Service需要主动调用stopSelft()来结束服务，而IntentService不需要
 * （在所有intent被处理完后，系统会自动关闭服务）
 * 此外：
 * <p>
 * IntentService为Service的onBingd()方式提供了默认实现：返回null
 * IntentService为Service的onStartCommand（）方法提供了默认实现：将请求的intent添加到队列中
 * 8.2 IntentService与其他线程的区别
 * IntentService内部采用了HandlerThread实现，作用类似于后台线程；
 * 与后台线程相比，IntentService是一种后台服务，优势是：优先级高（不容易被系统杀死），从而保证任务的执行
 * 对于后台线程，若进程中没有活动的四大组件，则该线程的优先级非常低，容易被系统杀死，无法保证任务的执行
 */
public class RemoteServiceActivity extends BaseActivity {
    IRemoteService service;
    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            // 此处不能使用强制转换, 应该调用Stub类的静态方法获得IRemoteService接口的实例对象
            service = IRemoteService.Stub.asInterface(iBinder);
            handler.post(runnable);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            // 类ServiceConnection中的onServiceDisconnected()方法在正常情况下是不被调用的,
            // 它的调用时机是当Service服务被异外销毁时,例如内存的资源不足时, 或者Service使用stop自己的时候通知
            service = null;
        }
    };

    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (service != null) {
                try {
                    Log.i(RemoteServiceActivity.class.getSimpleName(), "get num:" + service.getPersons().size());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                handler.postDelayed(runnable, 1000);
            } else {
                Log.i(RemoteServiceActivity.class.getSimpleName(), "service is numm");
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_aidl);
        ButterKnife.bind(this);

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 创建一个指向RemoteService的intent
                // 隐式启动一个Service
                Intent intent = new Intent(MyRemoteService.ACTION);
                bindService(intent, connection,
                        Service.BIND_AUTO_CREATE);
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(service != null){
                   try {
                       int size = service.getPersons().size();
                       service.addPerson(new Person(size, "person"+size, size));
                   } catch (RemoteException e) {
                       e.printStackTrace();
                   }
               }
            }
        });

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    service.stop();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    service.buildDialog();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
