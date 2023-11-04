package com.example.c2_prak2_13020200252;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText txtStb, txtNama;
    private Spinner spinner;
    private RadioGroup rgProdi;
    private CheckBox cb1, cb2, cb3, cb4, cb5, cb6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.sp_angkatan);
        txtStb = findViewById(R.id.et_stb);
        txtNama = findViewById(R.id.et_nama);
        rgProdi = findViewById(R.id.rg_prodi);
        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);
        cb4 = findViewById(R.id.cb4);
        cb5 = findViewById(R.id.cb5);
        cb6 = findViewById(R.id.cb6);

        String kontentSpinner[] = {"-Pilih Angkatan-", "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016","2015", "2014",};
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, kontentSpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void onClick(View view) {

        String valueStb = txtStb.getText().toString();
        String valueNama = txtNama.getText().toString();
        String valueMinat = "";

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("stambuk", valueStb);
        intent.putExtra("nama", valueNama);
        intent.putExtra("angkatan", spinner.getSelectedItem().toString());
        intent.putExtra("prodi", ((RadioButton) findViewById(rgProdi.getCheckedRadioButtonId())).getText().toString());

        if (cb1.isChecked()) {
            valueMinat += "- Badan Eksekutif Mahasiswa\n";
        } if (cb2.isChecked()) {
            valueMinat += "- Penulisan Karya Ilmiah\n";
        } if (cb3.isChecked()) {
            valueMinat += "- Kewirausahaan\n";
        } if (cb4.isChecked()) {
            valueMinat += "- Kesenian\n";
        } if (cb5.isChecked()) {
            valueMinat += "- Jurnalistik\n";
        } if (cb6.isChecked()) {
            valueMinat += "- Olahraga\n";
        }

        intent.putExtra("minat", valueMinat);

        startActivity(intent);
    }
}