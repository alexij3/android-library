package com.buzilov.library;

import java.util.List;

public class BookItem {

    private int imageResource;
    private String name;
    private List<String> genres;
    private List<String> authors;
    private int pages;
    private String description;

    public BookItem(int mImageResource, String name, List<String> genres, List<String> authors, int pages, String description) {
        this.imageResource = mImageResource;
        this.name = name;
        this.genres = genres;
        this.authors = authors;
        this.pages = pages;
        this.description = description;
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

    public List<String> getGenres() {
        return genres;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public int getPages() {
        return pages;
    }

    public String getGenresListAsString() {
        String delimiter = ",";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < genres.size(); i++) {
            sb.append(genres.get(i));
            if (i + 1 != genres.size()) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public String getAuthorsListAsString() {
        String delimiter = ",";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < authors.size(); i++) {
            sb.append(authors.get(i));
            if (i + 1 != authors.size()) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
