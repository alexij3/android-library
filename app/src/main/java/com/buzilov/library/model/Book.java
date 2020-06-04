package com.buzilov.library.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.buzilov.library.db.table.Books;

import java.util.List;

@Table(name = Books.TABLE_NAME)
public class Book extends Model {

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private String genres;

    @Column
    private String authors;

    @Column
    private Integer pagesCount;

    @Column
    private Integer year;

    public Book() {
        super();
    }

    public List<Review> reviews() {
        return getMany(Review.class, "Book");
    }
}
