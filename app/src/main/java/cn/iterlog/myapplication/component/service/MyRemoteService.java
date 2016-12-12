package cn.iterlog.myapplication.component.service;

import android.app.Service;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.WindowManager;

import java.util.List;

import cn.iterlog.myapplication.R;

/**
 * service中弹出提示框：
 * AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
 * alertDialog.setMessage("有新消息，是否查看？");
 * alertDialog.setPositiveButton("否",
 * new DialogInterface.OnClickListener()
 * {
 * public void onClick(DialogInterface dialog, int which)
 * {
 * }
 * });
 * <p>
 * alertDialog.setNegativeButton("是",
 * new DialogInterface.OnClickListener()
 * {
 * public void onClick(DialogInterface dialog, int which)
 * {
 * }
 * });
 * <p>
 * ad = alertDialog.create();
 * <p>
 * ad.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
 * ad.setCanceledOnTouchOutside(false);//点击外面区域不会让dialog消失
 * ad.show();
 * <p>
 * <p>
 * 可别忘了在manifest上加上权限：
 * <uses-permission android:name="android.permission.SYSTEM_ALERT_WINDOW" />
 */
public class MyRemoteService extends Service {
    public static final String ACTION = "cn.iterlog.myapplication.component.service.action.remote_bb";
    private static final String TAG = MyRemoteService.class.getSimpleName();
    private List<Person> persons = Person.mockPersons();

    class IRemoteServiceBinder extends IRemoteService.Stub {

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public void addPerson(Person person) throws RemoteException {
            persons.add(person);
        }

        @Override
        public List<Person> getPersons() throws RemoteException {
            return persons;
        }

        @Override
        public void stop() throws RemoteException {
            stop();
        }

        public void buildDialog() throws RemoteException {
            showDialog();
        }
    }

    private void showDialog() {
        try {
            Looper.prepare();
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
//                            Intent intent = new Intent(getApplicationContext(), .class);
//                            startActivity(intent);
//                            Toast.makeText(getApplicationContext(), "Remote Servie Toast", Toast.LENGTH_SHORT).show();
                        }
                    });

            AlertDialog ad = alertDialog.create();
            ad.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
            ad.setCanceledOnTouchOutside(false);//点击外面区域不会让dialog消失
            ad.show();
            Looper.loop();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public MyRemoteService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate");

    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.i(TAG, "onStart");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand");
        return START_STICKY;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.i(TAG, "onConfigurationChanged");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Log.i(TAG, "onLowMemory");
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        Log.i(TAG, "onTrimMemory");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        Log.i(TAG, "onRebind");
        super.onRebind(intent);
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        Log.i(TAG, "onTaskRemoved");
        super.onTaskRemoved(rootIntent);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind");
        return new IRemoteServiceBinder();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestory");
    }
}
