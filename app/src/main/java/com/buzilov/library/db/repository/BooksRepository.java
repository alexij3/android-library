package com.buzilov.library.db.repository;

import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.buzilov.library.db.DatabaseHelper;
import com.buzilov.library.model.Book;

import java.util.List;

public class BooksRepository {

    private DatabaseHelper databaseHelper;

    public BooksRepository() {
    }

    public BooksRepository(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    public long create(com.buzilov.library.model.Book book) {
        return book.save();
    }

    public long update(com.buzilov.library.model.Book book, Long id) {
        final com.buzilov.library.model.Book bookToEdit = com.buzilov.library.model.Book.load(com.buzilov.library.model.Book.class, id);
        setNewValuesForBook(bookToEdit, book);
        return bookToEdit.save();
    }

    public List<com.buzilov.library.model.Book> getAll() {
        return new Select()
                .from(com.buzilov.library.model.Book.class)
                .orderBy("id ASC")
                .execute();
    }

    public void deleteById(Long id) {
        new Delete()
                .from(Book.class)
                .where("id = ?", id)
                .execute();
    }

    private void setNewValuesForBook(com.buzilov.library.model.Book bookToEdit, com.buzilov.library.model.Book newBook) {
        bookToEdit.setTitle(newBook.getTitle());
        bookToEdit.setDescription(newBook.getDescription());
        bookToEdit.setAuthors(newBook.getAuthors());
        bookToEdit.setGenres(newBook.getGenres());
        bookToEdit.setPagesCount(newBook.getPagesCount());
        bookToEdit.setYear(newBook.getYear());
    }
}
