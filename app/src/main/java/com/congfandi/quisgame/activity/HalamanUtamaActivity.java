package com.congfandi.quisgame.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.congfandi.quisgame.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class HalamanUtamaActivity extends AppCompatActivity {
    @OnClick(R.id.materi)
    protected void materi() {
        startActivity(new Intent(this, MenuActivity.class));
        finish();
    }

    @OnClick(R.id.animasi)
    protected void animasi() {
        Intent intent = new Intent(this, AnimasiActivity.class);
        intent.putExtra("video", "sapi");
        startActivity(intent);
    }

    @OnClick(R.id.kuis)
    protected void kuis() {
        startActivity(new Intent(this, QuisActivity.class));
        finish();
    }

    private void gohome() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
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
        setContentView(R.layout.activity_halaman_utama);
        ButterKnife.bind(this);

    }
}
