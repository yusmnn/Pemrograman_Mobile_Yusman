package com.example.praktikum0101;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int REQUEST_GALLERY = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button cameraButton = findViewById(R.id.btn_camera);
        Button imageView = findViewById(R.id.btn_galery);
        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent();
            }
        });

        Button galleryButton = findViewById(R.id.btn_galery);
        galleryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

    }

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, REQUEST_GALLERY);
    }


    private void dispatchTakePictureIntent() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            // Jika izin kamera belum diberikan, minta izin kamera secara dinamis.
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, REQUEST_IMAGE_CAPTURE);
        } else {
            // Izin kamera sudah diberikan, Anda dapat memulai aktivitas kamera.
            startCameraActivity();
        }
    }


    // Metode untuk memulai aktivitas kamera.
    private void startCameraActivity() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    // Handle hasil permintaan izin.
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_IMAGE_CAPTURE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Izin kamera diberikan oleh pengguna, Anda dapat memulai aktivitas kamera.
                startCameraActivity();
            } else {
                // Izin kamera ditolak oleh pengguna, Anda dapat memberikan pesan kesalahan atau mengambil tindakan lain.
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            // Gambar telah diambil dari kamera, dan Anda dapat melakukan apa yang Anda inginkan dengan gambar tersebut.
            // Dapatkan gambar dari hasil intent.
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");

            // Temukan ImageView Anda.
            ImageView imageView = findViewById(R.id.imageView);

            // Setel gambar yang diambil ke ImageView.
            imageView.setImageBitmap(imageBitmap);
        } else if (requestCode == REQUEST_GALLERY && resultCode == RESULT_OK) {
            // Gambar telah dipilih dari galeri.
            // Dapatkan URI gambar yang dipilih.
            Uri selectedImageUri = data.getData();

            // Setel gambar yang dipilih dari galeri ke ImageView.
            ImageView imageView = findViewById(R.id.imageView);
            imageView.setImageURI(selectedImageUri);
        }
    }




}