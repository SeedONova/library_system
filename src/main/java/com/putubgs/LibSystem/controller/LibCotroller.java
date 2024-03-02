package com.putubgs.LibSystem.controller;

import com.putubgs.LibSystem.view.UI;
import com.putubgs.LibSystem.model.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class LibCotroller {
    UI ui = new UI();
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("library_system");
    EntityManager em = emf.createEntityManager();

    public void menuController(String input){
        switch (input) {
            case "1":
                ui.addBookPage();
                break;
            case "2":
                ui.addUserPage();
                break;
            case "3":
                ui.checkoutPage();
                break;
            case "4":
                ui.returnBookPage();
                break;
            case "5":
                ui.searchBookPage();
                break;
            case "6":
                ui.deleteBookPage();
                break;
            default:
                ui.uiTest2();
                break;
        }
    }

    public void addBook(String title, String author){
        Book book = new Book(title, author);
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
        em.close();
    }

    public void addUser(String firstName, String lastName){
        User user = new User(firstName, lastName);
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }

    public List<User> getAllUsers(EntityManager em){
        List<User> users = em.createQuery("SELECT u FROM User u", User.class).getResultList();
        return users;
    }

    public List<Book> getAllBooks(EntityManager em){
        List<Book> books = em.createQuery("SELECT b FROM Book b WHERE b.user IS NULL", Book.class).getResultList();
        return books;
    }

    public List<Book> getBorrowedBooks(EntityManager em){
        List<Book> books = em.createQuery("SELECT b FROM Book b WHERE user IS NOT NULL", Book.class).getResultList();
        return books;
    }

    public Book deleteBook(EntityManager em, String title){
        Book deletedBook = new Book();
        List<Book> books = em.createQuery("SELECT b FROM Book b WHERE b.title = :title", Book.class).setParameter("title", title).getResultList();
        if(books.isEmpty()){
            return null;
        }
        
        deletedBook = books.get(0);
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Book b WHERE b.title = :p").setParameter("p", title).executeUpdate();
        em.getTransaction().commit();
        em.close();



        return deletedBook;
    }
}


