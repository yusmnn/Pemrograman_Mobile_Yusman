package com.example.c2_prak3_13020200252;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {

    private ArrayList<Mahasiswa> arrListMhs = new ArrayList<>();

    public DbHelper(Context context) {
        super(context, "db_mhs", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String sql = "create table tb_mhs(stb text(11) primary key, nama text(50), angkatan text(4))";
        sqLiteDatabase.execSQL(sql);
    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertData(SQLiteDatabase db, Mahasiswa mhs) {
        ContentValues cv = new ContentValues();
        cv.put("stb", mhs.getStb());
        cv.put("nama", mhs.getNama());
        cv.put("angkatan", mhs.getAngkatan());
        db.insert("tb_mhs", null, cv);
//        db.insertWithOnConflict("tb_mhs", null, cv, SQLiteDatabase.CONFLICT_REPLACE);
    }


    public ArrayList<Mahasiswa> getArrListMhs(SQLiteDatabase db) {
        arrListMhs.clear();
        Cursor cursor = db.rawQuery("select * from tb_mhs", null);
        if(cursor.getCount() > 0) {
            cursor.moveToFirst();
            do{
                arrListMhs.add(new Mahasiswa(cursor.getString(0), cursor.getString(1), cursor.getInt(2) ));
            } while(cursor.moveToFirst());

        }
        return  arrListMhs;
    }

    public void hapusData(SQLiteDatabase db, String stb) {
        db.delete("tb_mhs", "stb=?", new String[]{stb});
    }

    public void editData(SQLiteDatabase db, Mahasiswa mhs, String stb) {
        ContentValues cv = new ContentValues();
        cv.put("stb", mhs.getStb());
        cv.put("nama", mhs.getNama());
        cv.put("angkatan", mhs.getAngkatan());
        db.update("tb_mhs", cv, "stb=?", new String[]{stb});
    }


}
