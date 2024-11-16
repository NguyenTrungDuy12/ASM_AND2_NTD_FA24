package com.example.asm_and2_ntd_fa24.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "AND102", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String User = "CREATE TABLE USER(tendangnhap TEXT PRIMARY KEY, matkhau TEXT, hoten TEXT)";
        db.execSQL(User);

        String SanPham = "CREATE TABLE SANPHAM(masp INTEGER PRIMARY KEY AUTOINCREMENT, tensp TEXT, giaban INTEGER, soluong INTEGER)";
        db.execSQL(SanPham);

        String insertUser = "INSERT INTO USER " +
                "VALUES('duynt', '123', 'Nguyen Trung Duy')," +
                "('duyntv', '345', 'Nguyen Tran Trung Duy')";
        db.execSQL(insertUser);

        String insertSanPham = "INSERT INTO SANPHAM " +
                "VALUES(1, 'Banh', 5000, 30)," +
                "(2,'Keo', 4000, 20)," +
                "(3, 'Thach', 10000, 50)";
        db.execSQL(insertSanPham);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion){
            db.execSQL("DROP TABLE IF EXISTS USER");
            db.execSQL("DROP TABLE IF EXISTS SANPHAM");
            onCreate(db);
        }
    }
}
