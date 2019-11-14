package amu.adiantek.lab05.db;

import amu.adiantek.lab05.container.AuthorContainer;

import java.util.HashMap;

public class AuthorDatabase {
    private HashMap<Long, AuthorContainer> authors = new HashMap<>();
    private long autoIncrement = 0;

    public void addAuthor(AuthorContainer author) {
        author.validate();
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

    public boolean removeAuthor(long id) {
        synchronized (this) {
            AuthorContainer author = authors.get(id);
            if (author == null) {
                return false;
            }
            if (!author.getBookContainers().isEmpty()) {
                throw new IllegalArgumentException("Author has books");
            }
            authors.remove(id);
            return true;
        }
    }

    public boolean updateAuthor(AuthorContainer author) {
        synchronized (this) {
            AuthorContainer v = authors.get(author.getId());
            if (v == null) {
                return false;
            }
            if (author.getName() != null && !author.getName().isEmpty()) {
                v.setName(author.getName());
            }
            if (author.getSurname() != null && !author.getSurname().isEmpty()) {
                v.setSurname(author.getSurname());
            }
            return true;
        }
    }
}
