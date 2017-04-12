package cn.iterlog.myapplication.component.service;

import android.app.Service;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.WindowManager;

import cn.iterlog.myapplication.ItemListActivity;
import cn.iterlog.myapplication.R;

public class BasicService extends Service {
    public static final String TAG = BasicService.class.getSimpleName();
    private int count = 0;
    private MyBinder mBinder = new MyBinder();
    private Thread thread = null;
    private boolean coutinue = true;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate() executed");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand------and startId = " + startId); // startService启动
        Log.d(TAG, "onStartCommand------and intent = " + intent);
        startInc();
        // 实验中，可轮换这几个值测试
        return START_STICKY;
        // START_CONTINUATION_MASK|START_FLAG_REDELIVERY|START_FLAG_RETRY|START_REDELIVER_INTENT|START_STICKY|START_STICKY_COMPATIBILITY;// | START_STICKY | START_STICKY_COMPATIBILITY |
        // START_REDELIVER_INTENT;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        coutinue = false;
        thread = null;
        Log.d(TAG, "onDestroy() executed");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind() executed");
        startInc();
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind() executed");
        if(thread != null){
            coutinue = false;
            thread = null;
        }
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        Log.d(TAG, "onRebind() executed");
        super.onRebind(intent);
    }

    class MyBinder extends Binder {
        public BasicService getService() {
            return BasicService.this;
        }
    }

    public int getCount() {
        return count;
    }

    public void showDialog() {
        try {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(this, R.style.AlertDialogCustom);
            alertDialog.setMessage("有新消息，是否查看？");
            alertDialog.setPositiveButton("否",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });

            alertDialog.setNegativeButton("是",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(getApplicationContext(), ItemListActivity.class);
                            startActivity(intent);
//                            Toast.makeText(getApplicationContext(), "Remote Servie Toast", Toast.LENGTH_SHORT).show();
                        }
                    });

            AlertDialog ad = alertDialog.create();
            ad.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
            ad.setCanceledOnTouchOutside(true);//点击外面区域不会让dialog消失
            ad.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startInc() {
        coutinue = true;
        try {
            if (thread == null) {
                thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (count < 1000 && coutinue) {
                            count++;
                            try {
                                Thread.currentThread().sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            }
            if (!thread.isAlive()) {
                thread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
