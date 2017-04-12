package cn.iterlog.myapplication.component.brocastreceiver.bootcomplete;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BootCompleteReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("BootCompleteReceiver","BootCompleteReceiver reveice");
        Intent my = new Intent(context, BackgroundService.class);
        context.startService(my);
    }
}
