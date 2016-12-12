package cn.iterlog.myapplication.component.service;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
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
public class IntentServiceActivity extends BaseActivity {
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
            service = null;
        }
    };

    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (service != null) {
                Log.i(IntentServiceActivity.class.getSimpleName(), "get num:" + service.getCount());
                handler.postDelayed(runnable, 1000);
            } else {
                Log.i(IntentServiceActivity.class.getSimpleName(), "service is numm");
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_intent);
        ButterKnife.bind(this);
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //同一服务只会开启一个工作线程
                //在onHandleIntent函数里依次处理intent请求。
                MyIntentService.startActionBaz(IntentServiceActivity.this, "1","11");
                MyIntentService.startActionFoo(IntentServiceActivity.this, "2","22");
            }
        });
    }
}
