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

    public boolean updateAuthor(AuthorContainer author) {
        synchronized (this) {
            AuthorContainer v = authors.get(author.getId());
            if (v == null) {
                return false;
            }
            v.setName(author.getName());
            v.setSurname(author.getSurname());
            return true;
        }
    }
}
