package com.congfandi.quisgame.settings;

import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.congfandi.quisgame.model.MyInterface;

/**
 * Created by congf on 18/12/2017.
 */

public class Setting {
    Context context;

    public Setting() {
    }

    public Setting(Context context) {
        this.context = context;
    }

    public void gonextPage(Context context, Class<?> target, MyInterface.Click hasil) {
        Intent intent = new Intent(context, target);
        context.startActivity(intent);
        hasil.click();
    }

    public void setClick(final ImageView btn, final int idle, final int click, final MyInterface.Click hasil) {
        btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    btn.setImageResource(idle);
                    hasil.click();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                    btn.setImageResource(click);
                return true;
            }
        });
    }

    public void setClick(ImageView btn, final MyInterface.Click click) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click.click();
            }
        });
    }

    public void setClick(final TextView btn, final int idle, final int clicked, final MyInterface.Click click) {
        btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    btn.setBackgroundResource(idle);
                    click.click();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                    btn.setBackgroundResource(clicked);
                return true;
            }
        });
    }
}
