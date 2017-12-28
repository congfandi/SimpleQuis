package com.congfandi.quisgame.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.congfandi.quisgame.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ButterKnife.bind(this);
    }
}
