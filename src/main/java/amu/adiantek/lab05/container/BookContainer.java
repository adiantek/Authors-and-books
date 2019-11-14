package amu.adiantek.lab05.container;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookContainer {
    private Long id;
    private String title;
    private int year;
    private ArrayList<Long> authors = new ArrayList<>();
    private transient ArrayList<AuthorContainer> authorContainers = new ArrayList<>();

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean addAuthor(AuthorContainer author) {
        if (authorContainers.contains(author)) {
            return false;
        }
        this.authorContainers.add(author);
        this.authors.add(author.getId());
        return true;
    }

    public boolean removeAuthor(AuthorContainer author) {
        if (authorContainers.size() == 1 && authorContainers.contains(author)) {
            throw new IllegalArgumentException("Book must have at least one author");
        }
        if (authorContainers.remove(author)) {
            return authors.remove(author.getId());
        }
        return false;
    }

    public List<AuthorContainer> getAuthorContainers() {
        return Collections.unmodifiableList(authorContainers);
    }
}
