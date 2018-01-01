package com.congfandi.quisgame.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.TextView;

import com.congfandi.quisgame.R;
import com.congfandi.quisgame.model.MyInterface;
import com.congfandi.quisgame.settings.Setting;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MateriActivity extends AppCompatActivity {
    private String data;
    private String name;
    @BindView(R.id.tv_materi)
    protected TextView materi;

    @OnClick(R.id.putar)
    protected void putar() {
        Intent intent = new Intent(this, AnimasiActivity.class);
        intent.putExtra("video", name);
        startActivity(intent);
    }

    @OnClick(R.id.kembali)
    protected void kembali() {
        gohome();
    }

    private void gohome() {
        new Setting().gonextPage(this, MenuActivity.class, new MyInterface.Click() {
            @Override
            public void click() {
                finish();
            }
        });
    }

    private void init() {
        name  = getIntent().getStringExtra("materi");
        String[] materi = getResources().getStringArray(R.array.materi);
        switch (name) {
            case "kerongkongan":
                data = materi[1];
                break;
            case "rumen_retikulum":
                data = materi[3];
                break;
            case "omasum":
                data = materi[2];
                break;
            case "abomasum":
                data = materi[0];
                break;
            case "usus_halus":
                data = materi[4];
                break;
        }
        this.materi.setText(data);
    }

    @Override
    public void onBackPressed() {
        gohome();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_materi);
        ButterKnife.bind(this);
        init();
    }
}
