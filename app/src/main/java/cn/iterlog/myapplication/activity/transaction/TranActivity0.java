package cn.iterlog.myapplication.activity.transaction;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import cn.iterlog.myapplication.R;

public class TranActivity0 extends AppCompatActivity {
    Button button2;
    Button button3;
    ImageView iv4;
    Button button5;
    Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tran0);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityOptionsCompat compat = ActivityOptionsCompat.makeCustomAnimation(TranActivity0.this,
                        R.anim.activity_open_enter, R.anim.activity_open_exit);
                ActivityCompat.startActivity(TranActivity0.this,
                        new Intent(TranActivity0.this, TranActivity1.class), compat.toBundle());
            }
        });

        button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityOptionsCompat compat = ActivityOptionsCompat.makeScaleUpAnimation( button2,
                        button2.getWidth() / 2, button2.getHeight() / 2, 0, 0);
                ActivityCompat.startActivity(TranActivity0.this,
                        new Intent(TranActivity0.this, TranActivity1.class), compat.toBundle());
            }
        });
       bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityOptionsCompat compat = ActivityOptionsCompat.makeThumbnailScaleUpAnimation( button3,bitmap,
                        button3.getWidth() / 2, button3.getHeight() / 2);

                ActivityCompat.startActivity(TranActivity0.this,
                        new Intent(TranActivity0.this, TranActivity1.class), compat.toBundle());
            }
        });

        iv4 = (ImageView)findViewById(R.id.iv4);
        iv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityOptionsCompat compat = ActivityOptionsCompat.makeSceneTransitionAnimation(TranActivity0.this,
                        iv4, getString(R.string.image));
                ActivityCompat.startActivity(TranActivity0.this,
                        new Intent(TranActivity0.this, TranActivity1.class), compat.toBundle());
            }
        });
        button5 = (Button)findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pair<View, String> imagePair = Pair.create((View)iv4, getString(R.string.image));
                Pair<View, String> textPair = Pair.create((View)button5, getString(R.string.name));

                ActivityOptionsCompat compat = ActivityOptionsCompat.makeSceneTransitionAnimation(TranActivity0.this,
                        imagePair, textPair);
                ActivityCompat.startActivity(TranActivity0.this,
                        new Intent(TranActivity0.this, TranActivity1.class), compat.toBundle());
            }
        });

    }

}
