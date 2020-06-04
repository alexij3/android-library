package com.buzilov.library.db.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.buzilov.library.db.DatabaseHelper;
import com.buzilov.library.db.table.Books;
import com.buzilov.library.dto.Book;
import com.buzilov.library.util.ConvertingUtils;

import java.util.ArrayList;
import java.util.List;

public class BooksRepository {

    private DatabaseHelper databaseHelper;

    public BooksRepository(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    public long create(Book book) {
        SQLiteDatabase database = databaseHelper.getWritableDatabase();

        try {
            ContentValues contentValues = ConvertingUtils.convertObjectToContentValues(book);
            return database.insert(Books.TABLE_NAME, null, contentValues);
        } catch (IllegalAccessException e) {
            Log.e("BooksRepository", "Error when creating a book", e);
        }

        return -1;
    }

    public List<Book> getAll() {
        final SQLiteDatabase database = databaseHelper.getReadableDatabase();

        /*final String[] projection = {
                Books.COLUMN_ID,
                Books.COLUMN_TITLE,
                Books.COLUMN_DESCRIPTION,
                Books.COLUMN_AUTHORS,
                Books.COLUMN_GENRES,
                Books.COLUMN_PAGES_COUNT
        };*/

        String sortOrder = Books.COLUMN_ID + " ASC";

        Cursor cursor = database.query(
                Books.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                sortOrder
        );

        List<Book> books = new ArrayList<>();
        while (cursor.moveToNext()) {
            books.add(convertCursorResultToBook(cursor));
        }
        return books;
    }

    public Book getById(int id) {
        final SQLiteDatabase database = databaseHelper.getReadableDatabase();

        /*final String[] projection = {
                Books.COLUMN_ID,
                Books.COLUMN_TITLE,
                Books.COLUMN_DESCRIPTION,
                Books.COLUMN_AUTHORS,
                Books.COLUMN_GENRES,
                Books.COLUMN_PAGES_COUNT
        };*/

        String selection = Books.COLUMN_ID + " = ?";
        String[] selectionArgs = { String.valueOf(id)};

        Cursor cursor = database.query(
                Books.TABLE_NAME,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        cursor.close();

        if (cursor.moveToNext()) {
            return convertCursorResultToBook(cursor);
        }
        return null;
    }

    public Book getByTitle(String title) {
        final SQLiteDatabase database = databaseHelper.getReadableDatabase();

        /*final String[] projection = {
                Books.COLUMN_ID,
                Books.COLUMN_TITLE,
                Books.COLUMN_DESCRIPTION,
                Books.COLUMN_AUTHORS,
                Books.COLUMN_GENRES,
                Books.COLUMN_PAGES_COUNT
        };*/

        String selection = Books.COLUMN_TITLE + " = ?";
        String[] selectionArgs = { title };

        Cursor cursor = database.query(
                Books.TABLE_NAME,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        cursor.close();

        if (cursor.moveToNext()) {
            return convertCursorResultToBook(cursor);
        }
        return null;
    }

    public int deleteByTitle(String title) {
        SQLiteDatabase database = databaseHelper.getReadableDatabase();
        String selection = Books.COLUMN_TITLE + " LIKE ?";
        String[] selectionArgs = { title };

        return database.delete(Books.TABLE_NAME, selection, selectionArgs);
    }

    public int update(Book book) {
        SQLiteDatabase database = databaseHelper.getWritableDatabase();

        try {
            ContentValues contentValues = ConvertingUtils.convertObjectToContentValues(book);
            String selection = Books.COLUMN_TITLE + " LIKE ?";
            String[] selectionArgs = {book.getTitle()};
            return database.update(Books.TABLE_NAME,
                    contentValues,
                    selection,
                    selectionArgs);
        } catch (IllegalAccessException e) {
            Log.e("BooksRepository", "Error when creating a book", e);
        }

        return -1;
    }

    private Book convertCursorResultToBook(Cursor cursor) {
        int idIndex = cursor.getColumnIndexOrThrow(Books.COLUMN_ID);
        int titleIndex = cursor.getColumnIndexOrThrow(Books.COLUMN_TITLE);
        int descriptionIndex = cursor.getColumnIndexOrThrow(Books.COLUMN_DESCRIPTION);
        int authorsIndex = cursor.getColumnIndexOrThrow(Books.COLUMN_AUTHORS);
        int genresIndex = cursor.getColumnIndexOrThrow(Books.COLUMN_GENRES);
        int pagesCountIndex = cursor.getColumnIndexOrThrow(Books.COLUMN_PAGES_COUNT);
        int yearIndex = cursor.getColumnIndexOrThrow(Books.COLUMN_YEAR);

        int id = cursor.getInt(idIndex);
        String title = cursor.getString(titleIndex);
        String description = cursor.getString(descriptionIndex);
        String authors = cursor.getString(authorsIndex);
        String genres = cursor.getString(genresIndex);
        int pagesCount = cursor.getInt(pagesCountIndex);
        int year = cursor.getInt(yearIndex);

        cursor.close();

        return new Book(id, title, description, genres, authors, pagesCount, year);
    }
}
