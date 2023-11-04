package com.example.c2_prak2_13020200252;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.c2_prak2_13020200252.databinding.ActivityImplicitBinding;

public class ImplicitActivity extends AppCompatActivity {

    private ImageView imageView;
    private final int REQUEST_CODE_PERMIMSSION_READ_STORAGE = 1;
    private final int REQUEST_CODE_ACTIVITY_GALLERY = 1
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityImplicitBinding binding = ActivityImplicitBinding.inflate(getLayoutInflater())
        setContentView(binding.getRoot());

        imageView = findViewById(R.id.imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkPermission()){
                    bukaGallery();
                }
            }
        });
    }

    private void bukaGallery(){
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        Intent intent = new Intent(Intent.ACTION_PICK, uri);
        startActivityForResult(intent, REQUEST_CODE_ACTIVITY_GALLERY);
    }

    private void buttonBukaGalleryClick(View view){
        final int PERMISSION_READ_EXT_STORAGE = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        if (PERMISSION_READ_EXT_STORAGE != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_CODE_PERMIMSSION_READ_STORAGE);
            return;
        }
        bukaGallery();
    }
}