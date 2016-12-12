package cn.iterlog.myapplication.component.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;

import butterknife.ButterKnife;
import cn.iterlog.myapplication.BaseActivity;
import cn.iterlog.myapplication.R;

import static cn.iterlog.myapplication.component.service.MessengerService.MSG_SET_COUNT;

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
public class MessenagerServiceActivity extends BaseActivity {
    private final static String TAG = MessenagerServiceActivity.class.getSimpleName();
    Messenger mService = null;
    boolean mIsBound;

    class IncomingHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MessengerService.MSG_SET_VALUE:
                    Log.i(TAG, "Received from service: " + msg.arg1);
                    break;
                case MSG_SET_COUNT:
                    Log.i(TAG, "Received from service count: " + msg.arg1);
                    break;
                default:
                    super.handleMessage(msg);
            }
        }
    }
    private Handler handler = new IncomingHandler();
    final Messenger mMessenger = new Messenger(handler);


    /**
     * Class for interacting with the main interface of the service.
     */
    private ServiceConnection mConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            // This is called when the connection with the service has been
            // established, giving us the service object we can use to
            // interact with the service.  We are communicating with our
            // service through an IDL interface, so get a client-side
            // representation of that from the raw service object.
            mService = new Messenger(service);
            Log.i(TAG, "Attached.");
            sendData();
            // We want to monitor the service for as long as we are
            // connected to it.
            try {
                Message msg = Message.obtain(null,
                        MessengerService.MSG_REGISTER_CLIENT);
                msg.replyTo = mMessenger;
                mService.send(msg);

                // Give it some value as an example.
                msg = Message.obtain(null,
                        MessengerService.MSG_SET_VALUE, this.hashCode(), 0);
                mService.send(msg);
            } catch (RemoteException e) {
                // In this case the service has crashed before we could even
                // do anything with it; we can count on soon being
                // disconnected (and then reconnected if it can be restarted)
                // disconnected (and then reconnected if it can be restarted)
                // so there is no need to do anything here.
            }
        }

        public void onServiceDisconnected(ComponentName className) {
            // This is called when the connection with the service has been
            // unexpectedly disconnected -- that is, its process crashed.
            mService = null;
            Log.i(TAG, "Disconnected.");
        }
    };

    void doBindService() {
        // Establish a connection with the service.  We use an explicit
        // class name because there is no reason to be able to let other
        // applications replace our component.
        bindService(new Intent(MessenagerServiceActivity.this,
                MessengerService.class), mConnection, Context.BIND_AUTO_CREATE);
        mIsBound = true;
        Log.i(TAG, "Binding.");
    }

    void doUnbindService() {
        if (mIsBound) {
            // If we have received the service, and hence registered with
            // it, then now is the time to unregister.
            if (mService != null) {
                try {
                    Message msg = Message.obtain(null,
                            MessengerService.MSG_UNREGISTER_CLIENT);
                    msg.replyTo = mMessenger;
                    mService.send(msg);
                } catch (RemoteException e) {
                    // There is nothing special we need to do if the service
                    // has crashed.
                }
            }

            // Detach our existing connection.
            unbindService(mConnection);
            mIsBound = false;
            Log.i(TAG, "Unbinding.");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_remote_messenger);
        ButterKnife.bind(this);

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                doBindService();
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                doUnbindService();
            }
        });

    }

    private int count  = 0;
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if(mIsBound){
                count ++;
                if (mService != null) {
                    try {
                        Message msg = Message.obtain(null,
                                MessengerService.MSG_SEND_COUNT, count, 0);
                        msg.replyTo = mMessenger;
                        mService.send(msg);
                    } catch (RemoteException e) {
                        // There is nothing special we need to do if the service
                        // has crashed.
                    }
                }
                handler.postDelayed(runnable, 2000);
            }
        }
    };
    private void sendData() {
        handler.postDelayed(runnable, 200);
    }
}
