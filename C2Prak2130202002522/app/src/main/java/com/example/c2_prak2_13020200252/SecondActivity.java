package com.example.c2_prak2_13020200252;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView rs1, rs2, rs3, rs4, rs5;
    String stb, nama, angkatan, prodi, minat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        rs1 = findViewById(R.id.rs1);
        rs2 = findViewById(R.id.rs2);
        rs3 = findViewById(R.id.rs3);
        rs4 = findViewById(R.id.rs4);
        rs5 = findViewById(R.id.rs5);

        stb = getIntent().getStringExtra("stambuk");
        nama = getIntent().getStringExtra("nama");
        angkatan = getIntent().getStringExtra("angkatan");
        prodi = getIntent().getStringExtra("prodi");
        minat = getIntent().getStringExtra("minat");

        rs1.setText(stb);
        rs2.setText(nama);
        rs3.setText(angkatan);
        rs4.setText(prodi);
        rs5.setText(minat);
    }
}