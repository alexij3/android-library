package com.buzilov.library.db.table;

public class Users {

    private static final String TABLE_NAME = "users";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_DISPLAY_NAME = "display_name";

    public static String getCreateTableQuery() {
        return String.format(
                "CREATE TABLE IF NOT EXISTS %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT, %s TEXT)",
                TABLE_NAME, COLUMN_ID, COLUMN_EMAIL, COLUMN_PASSWORD, COLUMN_DISPLAY_NAME);
    }

}
