package com.example.asm_and2_ntd_fa24.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.asm_and2_ntd_fa24.database.DBHelper;

public class UserDAO {
    private DBHelper dbHelper;

    public UserDAO(Context context) {
        dbHelper = new DBHelper(context);
    }

    //login
    public boolean checkLogin(String username, String password){
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM USER WHERE tendangnhap = ? AND matkhau = ?", new String[]{username, password});
        if (cursor.getCount() > 0){
            return true;
        }
        return false;
    }

    //register
    public boolean checkRegister(String username, String password, String fullname){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("tendangnhap", username);
        contentValues.put("matkhau", password);
        contentValues.put("hoten", fullname);

        long check = sqLiteDatabase.insert("USER", null, contentValues);
        if (check != -1){
            return true;
        }
        return false;
    }
}
