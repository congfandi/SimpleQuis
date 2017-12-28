package com.congfandi.quisgame.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ImageView;

import com.congfandi.quisgame.R;
import com.congfandi.quisgame.model.MyInterface;
import com.congfandi.quisgame.settings.Setting;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private Setting setting;
    private boolean bunyi = true;
    @BindView(R.id.play)
    protected ImageView play;
    @BindView(R.id.keluar)
    protected ImageView keluar;
    @BindView(R.id.sound)
    protected ImageView sound;

    private void close() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder
                .setTitle("Tutup Game")
                .setMessage("Anda yakin akan menutup game ini?")
                .setPositiveButton("oke", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .show();
    }

    private void init() {
        setting = new Setting(this);
        setting.setClick(play, R.drawable.tbl_mulai, R.drawable.tbl_mulai_roll, new MyInterface.Click() {
            @Override
            public void click() {
                setting.gonextPage(MainActivity.this, QuisActivity.class, new MyInterface.Click() {
                    @Override
                    public void click() {
                        finish();
                    }
                });
            }
        });
        setting.setClick(keluar, R.drawable.tbl_keluar, R.drawable.tbl_keluar_roll, new MyInterface.Click() {
            @Override
            public void click() {
                close();
            }
        });
        setting.setClick(sound, bunyi ? R.drawable.tbl_bunyi : R.drawable.tbl_diam, bunyi ? R.drawable.tbl_diam_roll : R.drawable.tbl_bunyi_roll, new MyInterface.Click() {
            @Override
            public void click() {
                if (bunyi)
                    bunyi = false;
                else
                    bunyi = true;
                sound.setImageResource(bunyi ? R.drawable.tbl_bunyi : R.drawable.tbl_diam);
            }
        });
    }

    @Override
    public void onBackPressed() {
        close();
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
