package com.putubgs.LibSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table (name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID bookId;

    @Column(name = "book_title", nullable = false)
    private String title;
    
    @Column(name = "book_author", nullable = false)
    private String author;

    @Column(name = "checkout_status")
    private Boolean isCheckout = false;

    // public Book(UUID bookId, String title, String author, Boolean isCheckout){
    //     this.bookId = bookId;
    //     this.title = title;
    //     this.author = author;
    //     this.isCheckout = isCheckout;
    // }

    // public void setBookId(UUID bookId){
    //     this.bookId = bookId;
    // }

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
