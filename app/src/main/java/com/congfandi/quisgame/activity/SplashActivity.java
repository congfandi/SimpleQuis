package com.congfandi.quisgame.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

import com.congfandi.quisgame.R;

public class SplashActivity extends AppCompatActivity {
    View mContentView;
    Handler handler;
    Thread thread;
    int SPLASH_SCREEN_TIME_IN_MILLIS = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        mContentView = findViewById(R.id.vi);
        handler = new Handler();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.hide();
    }


    @Override
    public void onBackPressed() {
    }

    @Override
    protected void onResume() {
        super.onResume();
        thread = new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(SPLASH_SCREEN_TIME_IN_MILLIS);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            goToNextScreen();
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

    protected void goToNextScreen() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}
