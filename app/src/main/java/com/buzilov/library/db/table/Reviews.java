package com.buzilov.library.db.table;

public class Reviews {

    public static final String TABLE_NAME = "reviews";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_CONTENT = "content";
    private static final String COLUMN_BOOK_ID = "book_id";

    public static String getCreateTableQuery() {
        return String.format(
                "CREATE TABLE IF NOT EXISTS %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s INTEGER, FOREIGN KEY (%s) REFERENCES %s(%s))",
                TABLE_NAME, COLUMN_ID, COLUMN_CONTENT, COLUMN_BOOK_ID, COLUMN_BOOK_ID, Books.TABLE_NAME, Books.COLUMN_ID);
    }

}
