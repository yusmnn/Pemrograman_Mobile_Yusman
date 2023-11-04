package com.example.mid_13020200252;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText nilai1, nilai2, hasil;
    private RadioGroup radioGroup;
    private RadioButton tambah, kurang, kali,bagi;
    private Button clear;

    private RadioGroup.OnCheckedChangeListener radioButton = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            hitung();
        }
    };
    private TextWatcher eventChangeText = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            hitung();
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            hitung();
        }

        @Override
        public void afterTextChanged(Editable editable) {
            hitung();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nilai1 = findViewById(R.id.nilai1);
        nilai2 = findViewById(R.id.nilai2);
        hasil = findViewById(R.id.hasil);
        radioGroup = findViewById(R.id.radioGroup);
        tambah = findViewById(R.id.tambah);
        kurang = findViewById(R.id.kurang);
        kali = findViewById(R.id.kali);
        bagi = findViewById(R.id.bagi);
        clear = findViewById(R.id.buttonClear);

        nilai1.addTextChangedListener(eventChangeText);
        nilai2.addTextChangedListener(eventChangeText);
        radioGroup.setOnCheckedChangeListener(radioButton);
    }

    public void hitung() {
        float a, b,c= 0;

        try {
            a = Float.parseFloat(nilai1.getText().toString());
        }catch (Exception e) {
            a = 0;
        }
        try {
            b = Float.parseFloat(nilai2.getText().toString());
        }catch (Exception e) {
            b = 0;
        }
        int checkedId = radioGroup.getCheckedRadioButtonId();

        if (checkedId == R.id.tambah) {
            c = a + b;
        } else if (checkedId == R.id.kurang) {
            c = a - b;
        } else if (checkedId == R.id.kali) {
            c = a * b;
        } else if (checkedId == R.id.bagi) {
            c = a / b;
        }
        hasil.setText(String.valueOf(c));
    }

    public void onClick(View v) {
        nilai1.setText("");
        nilai2.setText("");
        nilai1.requestFocus();
        radioGroup.clearCheck();
        hasil.setText("");
    }
}