package com.buzilov.library.util;

import android.content.ContentValues;

import java.lang.reflect.Field;

public class ConvertingUtils {

    public static ContentValues convertObjectToContentValues(Object o) throws IllegalAccessException {
        ContentValues cv = new ContentValues();

        for (Field field : o.getClass().getFields()) {
            Object value = field.get(o);
            if (value instanceof Double || value instanceof Integer || value instanceof String || value instanceof Boolean
                    || value instanceof Long || value instanceof Float || value instanceof Short) {
                cv.put(field.getName(), value.toString());
            } else if (value instanceof java.util.Date) {
                cv.put(field.getName(), value.toString());
            }
        }

        return cv;
    }

}
