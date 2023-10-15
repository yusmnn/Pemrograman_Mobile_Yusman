package com.example.c2_prak1a_13020200252;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText txtStb, txtNama;
    private TextView txtNilaiAkhir, txtIndeks;
    static final String KEY_STB = "STB";
    static final String KEY_NAMA = "NAMA";
    static final String KEY_NILAI_TUGAS = "NILAI_TUGAS";
    static final String KEY_NILAI_MID = "NILAI_MID";
    static final String KEY_NILAI_FINAL = "NILAI_FINAL";
    static final int RESULT_OK = 1;
    static final int RESULT_CANCEL = 0;
    private final int REQ_CODE_ACTIVITY2 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtStb = findViewById(R.id.txt_edit_stb);
        txtNama = findViewById(R.id.txt_edit_nama);
        txtNilaiAkhir = findViewById(R.id.txt_nilai_akhir);
        txtIndeks = findViewById(R.id.txt_index);

        txtNilaiAkhir.setText(":");
        txtIndeks.setText(":");

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data == null) return;

        if (requestCode == REQ_CODE_ACTIVITY2) {
            if(resultCode == MainActivity.RESULT_OK) {
                float nilaiAkhir;
                float nTgs, nMid, nFinal;

                nTgs = Float.parseFloat(data.getStringExtra(KEY_NILAI_TUGAS));
                nMid = Float.parseFloat(data.getStringExtra(KEY_NILAI_MID));
                nFinal = Float.parseFloat(data.getStringExtra(KEY_NILAI_FINAL));

                nilaiAkhir = (nTgs + nMid + nFinal) / 3;

                txtNilaiAkhir.setText(": " + nilaiAkhir);

                char    indeks =' ';
                if(nilaiAkhir >= 90 && nilaiAkhir <= 100) indeks = 'A';
                else if(nilaiAkhir >= 80 && nilaiAkhir < 90) indeks = 'B';
                else if(nilaiAkhir >= 70 && nilaiAkhir < 80) indeks = 'C';
                else if(nilaiAkhir >= 45 && nilaiAkhir < 70) indeks = 'D';
                else if(nilaiAkhir < 45) indeks = 'E';

                txtIndeks.setText(": " + indeks);
            } else if (resultCode == RESULT_CANCEL) {
                txtStb.setText("");
                txtNama.setText("");
                txtNilaiAkhir.setText("");
                txtIndeks.setText("");
                Toast.makeText(this, "Input Nilai Dibatalkan...", Toast.LENGTH_SHORT).show();
                txtStb.requestFocus();
            }
        }
    }

    public void bukaActivity2(View view) {
        Intent intent = new Intent(this, Activity2.class);
        intent.putExtra(KEY_STB, txtStb.getText().toString());
        intent.putExtra(KEY_NAMA, txtNama.getText().toString());
        txtNilaiAkhir.setText(":");
        txtIndeks.setText(":");
        startActivityForResult(intent, REQ_CODE_ACTIVITY2);
    }
}