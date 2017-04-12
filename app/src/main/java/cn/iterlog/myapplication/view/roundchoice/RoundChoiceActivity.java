package cn.iterlog.myapplication.view.roundchoice;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import cn.iterlog.myapplication.R;

public class RoundChoiceActivity extends AppCompatActivity {
    RoundChoiceView rippleChoiceView;
    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            rippleChoiceView.setmNumber(rippleChoiceView.getmNumber() + 1);
            handler.postDelayed(runnable, 2000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xm_ripple_choice_view);
        rippleChoiceView = (RoundChoiceView) findViewById(R.id.choicview);
        rippleChoiceView.setOnCheckedChangeListener(new RoundChoiceView.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RoundChoiceView view, boolean isChecked) {
                Log.i("onCheckedChanged", "onCheckedChanged:" + isChecked);
            }
        });
        handler.postDelayed(runnable, 2000);

//        rippleChoiceView.setEnabled(false);
    }
}
