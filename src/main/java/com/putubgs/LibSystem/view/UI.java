package com.putubgs.LibSystem.view;

import java.util.Scanner;
import java.util.List;

import com.putubgs.LibSystem.controller.LibCotroller;
import com.putubgs.LibSystem.model.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UI {
    Scanner input = new Scanner(System.in);
    public void homePage(){
        LibCotroller controller = new LibCotroller();
        System.out.println("==============================");
        System.out.println("Welcome to Predana's Library");
        System.out.println("==============================");
        System.out.println("1. Add New Book");
        System.out.println("2. Add New User");
        System.out.println("3. Check Out Book");
        System.out.println("4. Return Book");
        System.out.println("5. Search Book by Title");
        System.out.println("6. Delete book");
        System.out.println("7. Exit");
        System.out.print("Input: ");
        String inputValue = input.nextLine();
        controller.menuController(inputValue);
    }

    public void checkoutPage(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("library_system");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        User selectedUser = new User();
        Book selectedBook = new Book();
        LibCotroller controller = new LibCotroller();
        System.out.println("==============================");
        System.out.println("Checkout Page");
        System.out.println("==============================");

        List<User> users = controller.getAllUsers(em);
        int index = 1;
        for(User user : users){
            System.out.println(String.format("%d. %s %s", index, user.getFirstName(), user.getLastName()));
            index++;
        }
        System.out.println("Which user who wants to borrow a book?");
        System.out.print("Select user by index: ");
        int inputValue = input.nextInt();
        index = 1;
        for(User user : users){
            if(index == inputValue){
                selectedUser = user;
            }
        }
        System.out.println(selectedUser);

        List<Book> books = controller.getAllBooks(em);
        index = 1;
        for(Book book : books){
            System.out.println(String.format("%d. %s, %s", index, book.getTitle(), book.getAuthor()));
            index++;
        }
        System.out.println("Which book that user wants to borrow?");
        System.out.print("Select input based on index: ");
        inputValue = input.nextInt();
        index = 1;
        for(Book book : books){
            if(index == inputValue){
                selectedBook = book;
            }
        }
        System.out.println(selectedBook);
        selectedBook.setUser(selectedUser);
        em.persist(selectedBook);
        em.getTransaction().commit();
        em.close();
    }

    public void searchBookPage(){
        LibCotroller controller = new LibCotroller();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("library_system");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        System.out.println("==============================");
        System.out.println("Search Book Page");
        System.out.println("==============================");
        System.out.print("Enter The Book Title: ");
        String inputValue = input.nextLine();
        List<Book> books = controller.getAllBooks(em);
        for(Book book : books){
            if(inputValue.equals(book.getTitle())){
                System.out.println(String.format("Searched Book:%n%s - %s - %s", book.getBookId(), book.getTitle(), book.getAuthor()));
            }
        }
        em.getTransaction().commit();
        em.close();
    }

    public void returnBookPage(){
        LibCotroller controller = new LibCotroller();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("library_system");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Book selectedBook = new Book();
        System.out.println("==============================");
        System.out.println("Add Book Page");
        System.out.println("==============================");
        List<Book> books = controller.getBorrowedBooks(em);
        int index = 1;
        for(Book book : books){
            System.out.println(String.format("%d. %s, %s", index, book.getTitle(), book.getAuthor()));
            index++;
        }
        System.out.println("Which book that user wants to borrow?");
        System.out.print("Select input based on index: ");
        int inputValue = input.nextInt();
        index = 1;
        for(Book book : books){
            if(index == inputValue){
                selectedBook = book;
            }
        }
        selectedBook.setUser(null);
        em.persist(selectedBook);
        em.getTransaction().commit();
        em.close();
    }

    public void addBookPage(){
        LibCotroller controller = new LibCotroller();
        System.out.println("==============================");
        System.out.println("Add Book Page");
        System.out.println("==============================");
        System.out.print("Book Title: ");
        String bookTitle = input.nextLine();
        System.out.print("Book Author: ");
        String bookAuthor = input.nextLine();
        controller.addBook(bookTitle, bookAuthor);
    }

    public void addUserPage(){
        LibCotroller controller = new LibCotroller();
        System.out.println("==============================");
        System.out.println("Add User Page");
        System.out.println("==============================");
        System.out.print("First Name: ");
        String firstName = input.nextLine();
        System.out.print("Last Name: ");
        String lastName = input.nextLine();
        controller.addUser(firstName, lastName);
    }

    public void deleteBookPage(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("library_system");
        EntityManager em = emf.createEntityManager();
        Book deletedBook = new Book();
        LibCotroller controller = new LibCotroller();
        System.out.println("==============================");
        System.out.println("Add User Page");
        System.out.println("==============================");
        List<Book> books = controller.getAllBooks(em);
        int index = 1;
        for(Book book : books){
            System.out.println(String.format("%d. %s, %s", index, book.getTitle(), book.getAuthor()));
            index++;
        }
        System.out.println("Which book that user wants to delete?");
        System.out.print("Select input based on title: ");
        String title = input.nextLine();
        deletedBook = controller.deleteBook(em, title);
        System.out.println("Deleted Book: " + deletedBook);
    }

    public void uiTest(){
        System.out.println("Correct");
    }

    public void uiTest2(){
        System.out.println("Wrong");
    }
}
