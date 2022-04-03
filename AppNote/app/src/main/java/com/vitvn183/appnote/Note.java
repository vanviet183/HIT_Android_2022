package com.vitvn183.appnote;

public class Note {
    private Integer id;
    private String title;
    private String content;

    public Note() {

    }

    public Note(Integer id, String title, String description) {
        this.id = id;
        this.title = title;
        this.content = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
