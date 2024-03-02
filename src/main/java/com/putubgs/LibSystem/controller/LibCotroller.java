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

    public void menuController(String input){
        switch (input) {
            case "1":
                ui.addBookPage();
                break;
            case "2":
                ui.addUserPage();
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

}


