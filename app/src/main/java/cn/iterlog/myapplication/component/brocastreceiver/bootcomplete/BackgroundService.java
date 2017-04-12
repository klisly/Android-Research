package cn.iterlog.myapplication.component.brocastreceiver.bootcomplete;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by wizardholy on 2017/4/7.
 */

public class BackgroundService extends Service {
    private static final String TAG = "BackgroundService";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreated Service");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand Service");
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
