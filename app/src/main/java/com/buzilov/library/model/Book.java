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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public Integer getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(Integer pagesCount) {
        this.pagesCount = pagesCount;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
