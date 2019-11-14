package amu.adiantek.lab05.container;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class AuthorContainer {
    private Long id;
    private String name;
    private String surname;
    private Set<Long> books = new HashSet<>();
    private transient Set<BookContainer> bookContainers = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean addBook(BookContainer book) {
        if (this.bookContainers.add(book)) {
            return books.add(book.getId());
        }
        return false;
    }

    public boolean removeBook(BookContainer book) {
        if (this.bookContainers.remove(book)) {
            return books.remove(book.getId());
        }
        return false;
    }

    public Collection<BookContainer> getBookContainers() {
        return Collections.unmodifiableSet(bookContainers);
    }

    public void validate() {
        if (getName() == null || getName().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null nor empty");
        }
        if (getSurname() == null || getSurname().isEmpty()) {
            throw new IllegalArgumentException("Surname cannot be null nor empty");
        }
    }
}
