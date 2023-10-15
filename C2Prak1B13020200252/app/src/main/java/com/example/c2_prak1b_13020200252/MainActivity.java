package com.example.c2_prak1b_13020200252;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private final int REQUEST_CODE_PERMISSION_BACA_STORAGE = 1;
    private final int REQUEST_CODE_ACTIVITY_GALLERY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
    }

    private void bukaGallery() {
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

        Intent intent = new Intent(Intent.ACTION_PICK, uri);

        startActivityForResult(intent, REQUEST_CODE_ACTIVITY_GALLERY);
    }

    public void buttonBukaGalleryClick(View view) {
        final int PERMISSION_BACA_EXT_STORAGE = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        if (PERMISSION_BACA_EXT_STORAGE != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_CODE_PERMISSION_BACA_STORAGE);
            return;
        }

        bukaGallery();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_CODE_PERMISSION_BACA_STORAGE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                bukaGallery();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_ACTIVITY_GALLERY && resultCode == RESULT_OK) {
            Cursor cursor;
            String col = "_data";
            String[] projection = {col};

            cursor = getContentResolver().query(data.getData(), projection, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
                int index = cursor.getColumnIndexOrThrow(col);
                String pathGambar = cursor.getString(index);
                cursor.close();
                Bitmap gambar = BitmapFactory.decodeFile(pathGambar);
                imageView.setImageBitmap(gambar);
            }
        }
    }
}
