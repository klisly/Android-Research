package cn.iterlog.myapplication.widget.expandfloatbutton;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.OvershootInterpolator;

import cn.iterlog.myapplication.R;
import cn.iterlog.myapplication.util.AnimateUtils;

public class ExpandFloatBtnActivity extends AppCompatActivity {

    View fadeView;
    CardView cvDrawClear;
    FloatingActionButton fabDrawClear;
    CardView cvDrawSave;
    FloatingActionButton fabDrawSave;
    CardView cvDrawMode;
    FloatingActionButton fabDrawMode;
    CardView cvDrawTool;
    FloatingActionButton fabDrawTool;
    CardView cvDrawBackground;
    FloatingActionButton fabDrawBackground;
    CardView cvDrawAttrs;
    FloatingActionButton fabDrawAttrs;
    FloatingActionButton fabActions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expand_float_btn);
        fadeView = findViewById(R.id.fade_view);
        fabActions = (FloatingActionButton) findViewById(R.id.fab_actions);
        fabDrawAttrs = (FloatingActionButton) findViewById(R.id.fab_draw_attrs);
        fabDrawBackground = (FloatingActionButton) findViewById(R.id.fab_draw_background);
        fabDrawTool = (FloatingActionButton) findViewById(R.id.fab_draw_tool);
        fabDrawMode = (FloatingActionButton) findViewById(R.id.fab_draw_mode);
        fabDrawSave = (FloatingActionButton) findViewById(R.id.fab_draw_save);
        fabDrawClear = (FloatingActionButton) findViewById(R.id.fab_draw_clear);
        cvDrawAttrs = (CardView) findViewById(R.id.cv_draw_attrs);
        cvDrawBackground = (CardView) findViewById(R.id.cv_draw_background);
        cvDrawTool = (CardView) findViewById(R.id.cv_draw_tool);
        cvDrawMode = (CardView) findViewById(R.id.cv_draw_mode);
        cvDrawSave = (CardView) findViewById(R.id.cv_draw_save);
        cvDrawClear = (CardView) findViewById(R.id.cv_draw_clear);
        fabActions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickMenu();
            }
        });

    }

    void clickMenu(){
        int status = Integer.parseInt(fabActions.getTag().toString());
        if(status == 0){
            status = 1;
            fabActions.animate().rotation(45).setInterpolator(new OvershootInterpolator()).setDuration(800).start();
            AnimateUtils.FadeInAnimation(fadeView, 0, 100, new AccelerateDecelerateInterpolator(), true);

            AnimateUtils.ScaleInAnimation(fabDrawAttrs, 50, 150, new OvershootInterpolator(), true);
            AnimateUtils.ScaleInAnimation(cvDrawAttrs, 50, 150, new OvershootInterpolator(), true);
            AnimateUtils.ScaleInAnimation(fabDrawBackground, 100, 150, new OvershootInterpolator(), true);
            AnimateUtils.ScaleInAnimation(cvDrawBackground, 100, 150, new OvershootInterpolator(), true);
            AnimateUtils.ScaleInAnimation(fabDrawTool, 150, 150, new OvershootInterpolator(), true);
            AnimateUtils.ScaleInAnimation(cvDrawTool, 150, 150, new OvershootInterpolator(), true);
            AnimateUtils.ScaleInAnimation(fabDrawMode, 200, 150, new OvershootInterpolator(), true);
            AnimateUtils.ScaleInAnimation(cvDrawMode, 200, 150, new OvershootInterpolator(), true);
        } else {
            status = 0;
            fabActions.animate().rotation(-45).setInterpolator(new OvershootInterpolator()).setDuration(800).start();
            AnimateUtils.FadeInAnimation(fadeView, 100, 0, new AccelerateDecelerateInterpolator(), true);
            AnimateUtils.ScaleOutAnimation(cvDrawMode, 50, 150, new OvershootInterpolator(), true);
            AnimateUtils.ScaleOutAnimation(fabDrawMode, 50, 150, new OvershootInterpolator(), true);
            AnimateUtils.ScaleOutAnimation(fabDrawTool, 100, 150, new OvershootInterpolator(), true);
            AnimateUtils.ScaleOutAnimation(cvDrawTool, 100, 150, new OvershootInterpolator(), true);
            AnimateUtils.ScaleOutAnimation(fabDrawBackground, 150, 150, new OvershootInterpolator(), true);
            AnimateUtils.ScaleOutAnimation(cvDrawBackground, 150, 150, new OvershootInterpolator(), true);
            AnimateUtils.ScaleOutAnimation(fabDrawAttrs, 200, 150, new OvershootInterpolator(), true);
            AnimateUtils.ScaleOutAnimation(cvDrawAttrs, 200, 150, new OvershootInterpolator(), true);
        }
        fabActions.setTag(status);

    }

    @Override
    public void onBackPressed() {
        if (Integer.parseInt(fabActions.getTag().toString()) == 1)
            fabActions.performClick();
        else
            super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
