package com.example.booklists;

public class Book {
    private String name;
    private String author;
    private String date;
    private String imgURL;
    private boolean isExpended;

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", date='" + date + '\'' +
                ", imgURL='" + imgURL + '\'' +
                '}';
    }

    public Book(String name, String author, String date, String imgURL) {
        this.name = name;
        this.author = author;
        this.date = date;
        this.imgURL = imgURL;
        isExpended=false;
    }

    public boolean isExpended() {
        return isExpended;
    }

    public void setExpended(boolean expended) {
        isExpended = expended;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }
}
