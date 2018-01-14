package com.congfandi.quisgame.model;

/**
 * Created by congf on 14/01/2018.
 */

public class Quis {
    String soal;
    String jawabanA;
    String jawabanB;
    String jawabanC;
    char kunci;

    public Quis(String soal, String jawabanA, String jawabanB, String jawabanC, char kunci) {
        this.soal = soal;
        this.jawabanA = jawabanA;
        this.jawabanB = jawabanB;
        this.jawabanC = jawabanC;
        this.kunci = kunci;
    }

    public String getSoal() {
        return soal;
    }

    public void setSoal(String soal) {
        this.soal = soal;
    }

    public String getJawabanA() {
        return jawabanA;
    }

    public void setJawabanA(String jawabanA) {
        this.jawabanA = jawabanA;
    }

    public String getJawabanB() {
        return jawabanB;
    }

    public void setJawabanB(String jawabanB) {
        this.jawabanB = jawabanB;
    }

    public String getJawabanC() {
        return jawabanC;
    }

    public void setJawabanC(String jawabanC) {
        this.jawabanC = jawabanC;
    }

    public char getKunci() {
        return kunci;
    }

    public void setKunci(char kunci) {
        this.kunci = kunci;
    }
}
