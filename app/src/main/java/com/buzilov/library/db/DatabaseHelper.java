package com.buzilov.library.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.buzilov.library.db.table.Books;
import com.buzilov.library.db.table.Reviews;
import com.buzilov.library.db.table.Users;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Library.db";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Books.getCreateTableQuery());
        db.execSQL(Users.getCreateTableQuery());
        db.execSQL(Reviews.getCreateTableQuery());
        db.execSQL("INSERT INTO " + Books.TABLE_NAME + " VALUES(1, 'First book title', 'First book description', 'Me', 'Sci-Fi', 100, 2020)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
