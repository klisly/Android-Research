package cn.iterlog.myapplication.component.brocastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cn.iterlog.myapplication.R;
import cn.iterlog.myapplication.component.brocastreceiver.normal.DefaultReceiver2;
import cn.iterlog.myapplication.component.brocastreceiver.normal.DefaultReceiver3;
import cn.iterlog.myapplication.component.brocastreceiver.order.OrderReceiver;
import cn.iterlog.myapplication.component.brocastreceiver.order.OrderReceiver2;
import cn.iterlog.myapplication.component.brocastreceiver.order.OrderReceiver3;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class BroadCastReceiverActivity extends AppCompatActivity {
    DefaultReceiver2 receiver2;
    DefaultReceiver3 receiver3;
    OrderReceiver orderReceiver;
    OrderReceiver2 orderReceiver2;
    OrderReceiver3 orderReceiver3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //普通广播对于多个接收者来说是完全异步的，通常每个接收者都无需等待即可以接收到广播，
        // 接收者相互之间不会有影响。
        // 对于这种广播，接收者无法终止广播，即无法阻止其他接收者的接收动作。
        setContentView(R.layout.activity_broadcast);
         receiver2 = new DefaultReceiver2();
         receiver3 = new DefaultReceiver3();

        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.MY_BROADCAST");
        registerReceiver(receiver3, filter);
        registerReceiver(receiver2, filter);

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.MY_BROADCAST");
                intent.putExtra("msg", "brocast receiver");
                sendBroadcast(intent);
            }
        });

        orderReceiver = new OrderReceiver();
        orderReceiver2 = new OrderReceiver2();
        orderReceiver3 = new OrderReceiver3();
        filter.setPriority(500);
        registerReceiver(orderReceiver, filter);
        filter.setPriority(700);
        registerReceiver(orderReceiver2, filter);
        filter.setPriority(900);
        registerReceiver(orderReceiver3, filter);

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.MY_BROADCAST");
                intent.putExtra("msg", "order brocast receiver");
                sendOrderedBroadcast(intent,"klisly.permission.MY_BROADCAST_PERMISSION");
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver2);
        unregisterReceiver(receiver3);
        unregisterReceiver(orderReceiver);
        unregisterReceiver(orderReceiver2);
        unregisterReceiver(orderReceiver3);
    }
}
