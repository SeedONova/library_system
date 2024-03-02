package com.putubgs.LibSystem.controller;

import com.putubgs.LibSystem.view.UI;
import com.putubgs.LibSystem.model.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class LibCotroller {
    UI ui = new UI();
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("library_system");
    EntityManager em = emf.createEntityManager();
    User user = new User();
    Book book = new Book();

    public void menuController(String input){
        switch (input) {
            case "1":
                ui.addBookPage();
                break;
            case "2":
                ui.uiTest();
                break;
            case "3":
                ui.uiTest();
                break;
            case "4":
                ui.uiTest();
                break;
            case "5":
                ui.uiTest();
                break;
            case "6":
                ui.uiTest();
                break;
            case "7":
                ui.uiTest();
                break;
            default:
                ui.uiTest2();
                break;
        }
    }

    public void addBook(String title, String author){
        em.getTransaction().begin();
        book.setTitle(title);
        book.setAuthor(author);
        
        em.persist(book);

        em.getTransaction().commit();
        em.close();
    }

    public void addUser(String firstName, String lastName){
        em.getTransaction().begin();
        user.setFirstName(firstName);
        user.setLastName(lastName);

        em.persist(user);

        em.getTransaction().commit();
        em.close();
    }

}


