package com.buzilov.library;

import java.util.List;

public class BookItem {

    private int imageResource;
    private String name;
    private List<String> genres;
    private List<String> authors;
    private int pages;

    public BookItem(int mImageResource, String name, List<String> genres, List<String> authors, int pages) {
        this.imageResource = mImageResource;
        this.name = name;
        this.genres = genres;
        this.authors = authors;
        this.pages = pages;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getName() {
        return name;
    }

    public List<String> getGenres() {
        return genres;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public int getPages() {
        return pages;
    }
}
