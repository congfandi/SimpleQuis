package com.congfandi.quisgame.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.TextView;

import com.congfandi.quisgame.R;
import com.congfandi.quisgame.model.MyInterface;
import com.congfandi.quisgame.model.Quis;
import com.congfandi.quisgame.settings.Setting;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QuisActivity extends AppCompatActivity {
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
    private List<Quis> listSoal;
    private int benar = 0;
    private int salah = 0;

    @Override
    public void onBackPressed() {
        new Setting().gonextPage(QuisActivity.this, HalamanUtamaActivity.class, new MyInterface.Click() {
            @Override
            public void click() {
                finish();
            }
        });
    }

    private void setSoal() {
        listSoal = new ArrayList<>();
        listSoal.add(new Quis("Soal nomer 1", "Jawaban A", "Jawaban B", "Jawaban C", 'c'));
        listSoal.add(new Quis("Soal nomer 2", "Jawaban A", "Jawaban B", "Jawaban C", 'a'));
        listSoal.add(new Quis("Soal nomer 3", "Jawaban A", "Jawaban B", "Jawaban C", 'b'));
        listSoal.add(new Quis("Soal nomer 4", "Jawaban A", "Jawaban B", "Jawaban C", 'c'));
        listSoal.add(new Quis("Soal nomer 5", "Jawaban A", "Jawaban B", "Jawaban C", 'a'));
        listSoal.add(new Quis("Soal nomer 6", "Jawaban A", "Jawaban B", "Jawaban C", 'a'));
        listSoal.add(new Quis("Soal nomer 7", "Jawaban A", "Jawaban B", "Jawaban C", 'b'));
        listSoal.add(new Quis("Soal nomer 8", "Jawaban A", "Jawaban B", "Jawaban C", 'b'));
        listSoal.add(new Quis("Soal nomer 9", "Jawaban A", "Jawaban B", "Jawaban C", 'c'));
        listSoal.add(new Quis("Soal nomer 10", "Jawaban A", "Jawaban B", "Jawaban C", 'c'));
        //tambah sendiri seperti diatas ini ya
    }

    private void jawaban(final int index, final char jawaban) {

    }

    private void init() {//ini sialisasi awal semua variabel
        benar = 0;
        salah = 0;
        setSoal();
        setting = new Setting(this);
        index = new Random().nextInt(listSoal.size());
        soal.setText(listSoal.get(index).getSoal());
        jawaban_a.setText("a. " + listSoal.get(index).getJawabanA());
        jawaban_b.setText("b. " + listSoal.get(index).getJawabanB());
        jawaban_c.setText("c. " + listSoal.get(index).getJawabanC());
        setting.setClick(jawaban_a, R.drawable.background_soal, R.drawable.background_soal2, new MyInterface.Click() {
            @Override
            public void click() {

                try {
                    if (listSoal.get(index).getKunci() == 'a' | listSoal.get(index).getKunci() == 'A')
                        benar++;
                    else
                        salah++;
                    listSoal.remove(index);
                    index = new Random().nextInt(listSoal.size());
                    soal.setText(listSoal.get(index).getSoal());
                    jawaban_a.setText("a. " + listSoal.get(index).getJawabanA());
                    jawaban_b.setText("b. " + listSoal.get(index).getJawabanB());
                    jawaban_c.setText("c. " + listSoal.get(index).getJawabanC());
                } catch (Exception e) {
                    hasil();
                }

            }
        });
        setting.setClick(jawaban_b, R.drawable.background_soal, R.drawable.background_soal2, new MyInterface.Click() {
            @Override
            public void click() {

                try {
                    if (listSoal.get(index).getKunci() == 'b' | listSoal.get(index).getKunci() == 'B')
                        benar++;
                    else
                        salah++;
                    listSoal.remove(index);
                    index = new Random().nextInt(listSoal.size());
                    soal.setText(listSoal.get(index).getSoal());
                    jawaban_a.setText("a. " + listSoal.get(index).getJawabanA());
                    jawaban_b.setText("b. " + listSoal.get(index).getJawabanB());
                    jawaban_c.setText("c. " + listSoal.get(index).getJawabanC());
                } catch (Exception e) {
                    hasil();
                }

            }
        });
        setting.setClick(jawaban_c, R.drawable.background_soal, R.drawable.background_soal2, new MyInterface.Click() {
            @Override
            public void click() {

                try {
                    if (listSoal.get(index).getKunci() == 'c' | listSoal.get(index).getKunci() == 'C')
                        benar++;
                    else
                        salah++;
                    listSoal.remove(index);
                    index = new Random().nextInt(listSoal.size());
                    soal.setText(listSoal.get(index).getSoal());
                    jawaban_a.setText("a. " + listSoal.get(index).getJawabanA());
                    jawaban_b.setText("b. " + listSoal.get(index).getJawabanB());
                    jawaban_c.setText("c. " + listSoal.get(index).getJawabanC());
                } catch (Exception e) {
                    hasil();
                }

            }
        });
    }

    private void hasil() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder
                .setTitle("Hasil")
                .setMessage("Benar = " + benar + "\nSalah = " + salah)
                .setPositiveButton("Ulang", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        init();
                    }
                })
                .setNegativeButton("Tutup", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        new Setting().gonextPage(QuisActivity.this, HalamanUtamaActivity.class, new MyInterface.Click() {
                            @Override
                            public void click() {
                                finish();
                            }
                        });
                    }
                })
                .show();
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
