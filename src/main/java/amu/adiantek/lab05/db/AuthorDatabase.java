package amu.adiantek.lab05.db;

import amu.adiantek.lab05.container.AuthorContainer;

import java.util.HashMap;

public class AuthorDatabase {
    private HashMap<Long, AuthorContainer> authors = new HashMap<>();
    private long autoIncrement = 0;

    public void addAuthor(AuthorContainer author) {
        synchronized (this) {
            author.setId(autoIncrement);
            authors.put(autoIncrement++, author);
        }
    }

    public AuthorContainer getAuthor(long id) {
        synchronized (this) {
            return authors.get(id);
        }
    }

    public boolean deleteAuthor(long id) {
        synchronized (this) {
            return authors.remove(id) != null;
        }
    }

    public void updateAuthor(AuthorContainer author) {

    }
}
