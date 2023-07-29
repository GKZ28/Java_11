package ru.netology.qa65;

public class SimpleTask extends Task {
    protected String title;

    public SimpleTask (int id, String title) {
        super(id);
        this.title = title;
    }
    public String getTitle () {
        return title;
    }
}