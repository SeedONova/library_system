package com.putubgs.LibSystem.model;

public class Book {
    private String bookId;
    private String title;
    private String author;
    private Boolean isCheckout;

    public Book(String bookId, String title, String author, Boolean isCheckout){
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isCheckout = isCheckout;
    }

    public void setBookId(String bookId){
        this.bookId = bookId;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void setIsCheckout(Boolean isCheckout){
        this.isCheckout = isCheckout;
    }

    @Override
    public String toString() {
        return String.format("Book { %s, %s, %s, %b}", bookId, title, author, isCheckout);
    }
}
