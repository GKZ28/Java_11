package ru.netology.qa65;

public class simpleTask extends Task {
    protected String title;

    public simpleTask (int id, String title) {
        super(id);
        this.title = title;
    }
    public String getTitle () {
        return title;
    }
}
