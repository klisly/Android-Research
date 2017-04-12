package cn.iterlog.myapplication.component.brocastreceiver;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.util.Log;

public class BatteryReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        int currLevel = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);  //当前电量
        int total = intent.getIntExtra(BatteryManager.EXTRA_SCALE, 1);      //总电量
        int percent = currLevel * 100 / total;
        Log.i("BatteryReceiver", "battery: " + percent + "%");
    }
}
