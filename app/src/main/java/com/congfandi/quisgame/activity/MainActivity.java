package com.congfandi.quisgame.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ImageView;

import com.congfandi.quisgame.R;
import com.congfandi.quisgame.model.MyInterface;
import com.congfandi.quisgame.settings.Setting;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private Setting setting;

    @BindView(R.id.play)
    protected ImageView play;

    @OnClick(R.id.play)
    protected void setPlay() {
        setting.gonextPage(this, QuisActivity.class, new MyInterface.Hasil() {
            @Override
            public void hasil() {
                finish();
            }
        });
    }

    private void init() {
        setting = new Setting(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }
}
