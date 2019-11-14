package amu.adiantek.lab05.db;

import amu.adiantek.lab05.container.BookContainer;

import java.util.ArrayList;
import java.util.HashMap;

public class BookDatabase {
    private HashMap<Long, BookContainer> books = new HashMap<>();
    private long autoIncrement = 0;

    public void addBook(BookContainer book) {
        if (!book.getAuthorContainers().isEmpty()) {
            throw new IllegalArgumentException("Book must have at least one author");
        }
        synchronized (this) {
            book.setId(autoIncrement);
            books.put(autoIncrement++, book);
        }
    }

    public BookContainer getBook(long id) {
        synchronized (this) {
            return books.get(id);
        }
    }

    public boolean removeBook(long id) {
        synchronized (this) {
            BookContainer book = books.get(id);
            if (book == null) {
                return false;
            }
            book.getAuthorContainers().forEach(author-> author.removeBook(book));
            books.remove(id);
            return true;
        }
    }

    public boolean updateBook(BookContainer book) {
        synchronized (this) {
            BookContainer v = books.get(book.getId());
            if (v == null) {
                return false;
            }
            v.setTitle(book.getTitle());
            v.setYear(book.getYear());
            return true;
        }
    }
}
