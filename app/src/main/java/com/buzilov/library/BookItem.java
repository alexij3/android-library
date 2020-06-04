package com.buzilov.library;

import com.buzilov.library.dto.Book;

public class BookItem {

    private int imageResource;
    private String name;
    private String genres;
    private String authors;
    private int pages;
    private String description;
    private int year;

    public BookItem(int imageResource, String name, String genres, String authors, int pages, String description, int year) {
        this.imageResource = imageResource;
        this.name = name;
        this.genres = genres;
        this.authors = authors;
        this.pages = pages;
        this.description = description;
        this.year = year;
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

    public static BookItem from(Book book) {
        return new BookItem(
                R.drawable.ic_book_item,
                book.getTitle(),
                book.getGenres(),
                book.getAuthors(),
                book.getPagesCount(),
                book.getDescription(),
                book.getYear()
        );
    }
}
