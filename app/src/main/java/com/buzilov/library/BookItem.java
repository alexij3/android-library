package com.buzilov.library;

import com.buzilov.library.model.Book;

public class BookItem {

    private int imageResource;
    private String name;
    private String genres;
    private String authors;
    private int pages;
    private String description;
    private int year;
    private long id;

    public BookItem(int imageResource, String name, String genres, String authors, int pages, String description, int year) {
        this.imageResource = imageResource;
        this.name = name;
        this.genres = genres;
        this.authors = authors;
        this.pages = pages;
        this.description = description;
        this.year = year;
    }

    public BookItem(int imageResource, String name, String genres, String authors, int pages, String description, int year, long id) {
        this.imageResource = imageResource;
        this.name = name;
        this.genres = genres;
        this.authors = authors;
        this.pages = pages;
        this.description = description;
        this.year = year;
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getName() {
        return name;
    }

    public String getGenres() {
        return genres;
    }

    public String getAuthors() {
        return authors;
    }

    public int getYear() {
        return year;
    }

    public int getPages() {
        return pages;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public static BookItem from(Book book) {
        return new BookItem(
                R.drawable.ic_book_item,
                book.getTitle(),
                book.getGenres(),
                book.getAuthors(),
                book.getPagesCount(),
                book.getDescription(),
                book.getYear(),
                book.getId()
        );
    }
}
