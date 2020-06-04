package com.buzilov.library.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.buzilov.library.db.table.Reviews;

@Table(name = Reviews.TABLE_NAME)
public class Review extends Model {

    @Column
    private String content;

    @Column
    private Book book;

    public Review() { super(); }

}
