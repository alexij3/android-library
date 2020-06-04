package com.buzilov.library.dto;

public class Book {

    private Long id;
    private String title;
    private String description;
    private String genres;
    private String authors;
    private Integer pagesCount;
    private Integer year;

    public Book(String title, String description, String genres, String authors, Integer pagesCount, Integer year) {
        this.title = title;
        this.description = description;
        this.genres = genres;
        this.authors = authors;
        this.pagesCount = pagesCount;
        this.year = year;
    }

    public Book(Long id, String title, String description, String genres, String authors, Integer pagesCount, Integer year) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.genres = genres;
        this.authors = authors;
        this.pagesCount = pagesCount;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
