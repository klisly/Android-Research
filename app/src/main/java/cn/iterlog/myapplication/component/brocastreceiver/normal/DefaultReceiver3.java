package cn.iterlog.myapplication.component.brocastreceiver.normal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by wizardholy on 2017/4/7.
 */

public class DefaultReceiver3 extends BroadcastReceiver {
    private static final String TAG = "DefaultReceiver3";
    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = intent.getStringExtra("msg");
        Log.i(TAG, msg);
    }
}
