package com.example.c2_prak3_13020200252;

public class Mahasiswa {
    private String stb;
    private String nama;
    private int angkatan;

    public Mahasiswa(String stb, String nama, int angkatan) {
        this.stb = stb;
        this.nama = nama;
        this.angkatan = angkatan;
    }

    public String getStb() {
        return stb;
    }
    public String getNama() {
        return nama;
    }

    public int getAngkatan() {
        return angkatan;
    }
}
