package com.congfandi.quisgame.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.TextView;

import com.congfandi.quisgame.R;
import com.congfandi.quisgame.model.MyInterface;
import com.congfandi.quisgame.settings.Setting;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QuisActivity extends AppCompatActivity {
    private char[] jawaban = new char[12];
    private char[] kunci = {'a', 'c', 'a', 'b', 'c', 'a', 'b', 'a', 'b', 'c', 'b', 'b'};//kunnci jawaban
    private int index = 0;
    @BindView(R.id.soal)
    protected TextView soal;
    @BindView(R.id.jawaban_a)
    protected TextView jawaban_a;
    @BindView(R.id.jawaban_b)
    protected TextView jawaban_b;
    @BindView(R.id.jawaban_c)
    protected TextView jawaban_c;
    private Setting setting;

    @Override
    public void onBackPressed() {
        new Setting().gonextPage(QuisActivity.this, HalamanUtamaActivity.class, new MyInterface.Click() {
            @Override
            public void click() {
                finish();
            }
        });
    }

    private void setSoal(final int index, final char jawaban) {
        if (index < getResources().getStringArray(R.array.soal).length) {//untuk mengambil soal
            this.jawaban[index - 1] = jawaban;
            soal.setText((index + 1) + "." + getResources().getStringArray(R.array.soal)[index]);
            jawaban_a.setText("a. " + getResources().getStringArray(R.array.jawaban_a)[index]);
            jawaban_b.setText("b. " + getResources().getStringArray(R.array.jawaban_b)[index]);
            jawaban_c.setText("c. " + getResources().getStringArray(R.array.jawaban_c)[index]);
        } else {
            int benar = 0;
            int salah = 0;
            for (int i = 0; i < kunci.length; i++) {
                if (kunci[i] == this.jawaban[i])
                    benar++;
                else
                    salah++;
            }
            AlertDialog.Builder hasil = new AlertDialog.Builder(this);//dialog untuk menampilkan hasil
            hasil
                    .setCancelable(false)
                    .setTitle("Hasil")
                    .setMessage("Benar : " + benar + "\n" +
                            "Salah : " + salah)
                    .setPositiveButton("Tutup", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {//jika menkan tutup
                            new Setting().gonextPage(QuisActivity.this, MainActivity.class, new MyInterface.Click() {
                                @Override
                                public void click() {
                                    finish();
                                }
                            });
                        }
                    })
                    .setNegativeButton("Ulang", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {//jika menekan ulang
                            init();
                        }
                    })
                    .show();
        }
    }

    private void init() {//ini sialisasi awal semua variabel
        setting = new Setting(this);
        index = 0;
        soal.setText((index + 1) + "." + getResources().getStringArray(R.array.soal)[0]);
        jawaban_a.setText("a. " + getResources().getStringArray(R.array.jawaban_a)[0]);
        jawaban_b.setText("b. " + getResources().getStringArray(R.array.jawaban_b)[0]);
        jawaban_c.setText("c. " + getResources().getStringArray(R.array.jawaban_c)[0]);
        setting.setClick(jawaban_a, R.drawable.background_soal, R.drawable.background_soal2, new MyInterface.Click() {
            @Override
            public void click() {
                index++;
                setSoal(index, 'a');
            }
        });
        setting.setClick(jawaban_b, R.drawable.background_soal, R.drawable.background_soal2, new MyInterface.Click() {
            @Override
            public void click() {
                index++;
                setSoal(index, 'b');
            }
        });
        setting.setClick(jawaban_c, R.drawable.background_soal, R.drawable.background_soal2, new MyInterface.Click() {
            @Override
            public void click() {
                index++;
                setSoal(index, 'c');
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_quis);
        ButterKnife.bind(this);
        init();
    }
}
