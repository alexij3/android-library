package com.buzilov.library.db.table;

public class Books {

    public static final String TABLE_NAME = "books";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_AUTHORS = "authors";
    public static final String COLUMN_GENRES = "genres";
    public static final String COLUMN_PAGES_COUNT = "pages";
    public static final String COLUMN_YEAR = "year";

    private Books() {}

    public static String getCreateTableQuery() {
        return String.format(
                "CREATE TABLE IF NOT EXISTS %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s INTEGER, %s INTEGER)",
                TABLE_NAME, COLUMN_ID, COLUMN_TITLE, COLUMN_DESCRIPTION, COLUMN_AUTHORS, COLUMN_GENRES, COLUMN_PAGES_COUNT, COLUMN_YEAR);
    }

}
