package cn.iterlog.myapplication.component.brocastreceiver.order;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by wizardholy on 2017/4/7.
 */

public class OrderReceiver extends BroadcastReceiver {
    private static final String TAG = "OrderReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = getResultExtras(true).getString("tata");
        Log.i(TAG, msg);
        Bundle bundle = new Bundle();
        bundle.putString("tata", "jk");
        setResultExtras(bundle);

    }
}
