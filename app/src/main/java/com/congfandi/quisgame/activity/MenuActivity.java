package com.congfandi.quisgame.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.congfandi.quisgame.R;
import com.congfandi.quisgame.model.MyInterface;
import com.congfandi.quisgame.settings.Setting;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MenuActivity extends AppCompatActivity {


    @OnClick(R.id.kerongkongan)
    protected void kerongkongan() {
        goNext("kerongkongan");
    }

    @OnClick(R.id.rumen)
    protected void rumen() {
        goNext("rumen_retikulum");
    }

    @OnClick(R.id.omasuum)
    protected void omasum() {
        goNext("omasum");
    }

    @OnClick(R.id.abomasum)
    protected void abomasum() {
        goNext("abomasum");
    }

    @OnClick(R.id.usu_halus)
    protected void usu_halus() {
        goNext("usus_halus");
    }

    @OnClick(R.id.kembali)
    protected void kembali() {
        gohome();
    }

    private void goNext(String value) {
        finish();
        Intent intent = new Intent(this, MateriActivity.class);
        intent.putExtra("materi", value);
        startActivity(intent);
    }

    private void gohome() {
        new Setting().gonextPage(this, HalamanUtamaActivity.class, new MyInterface.Click() {
            @Override
            public void click() {
                finish();
            }
        });
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
        setContentView(R.layout.activity_menu);

        ButterKnife.bind(this);
    }
}
