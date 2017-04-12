package cn.iterlog.myapplication.component.brocastreceiver.order;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by wizardholy on 2017/4/7.
 */

public class OrderReceiver3 extends BroadcastReceiver {
    private static final String TAG = "OrderReceiver3";
    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = intent.getStringExtra("msg");
        Bundle bundle = new Bundle();
        bundle.putString("tata", "jk");
        setResultExtras(bundle);
        Log.i(TAG, msg);
    }
}
