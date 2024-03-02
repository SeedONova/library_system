package com.putubgs.LibSystem.view;

import java.util.Scanner;

import com.putubgs.LibSystem.controller.LibCotroller;

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
        System.out.println("5. List All Books");
        System.out.println("6. Search Book by Title");
        System.out.println("7. Exit");
        System.out.print("Input: ");
        String inputValue = input.nextLine();
        controller.menuController(inputValue);
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
        LibCotroller conCotroller = new LibCotroller();
        System.out.println("==============================");
        System.out.println("Add User Page");
        System.out.println("==============================");
        System.out.print("First Name: ");
        String firstName = input.nextLine();
        System.out.print("Last Name: ");
        String lastName = input.nextLine();
    }

    public void uiTest(){
        System.out.println("Correct");
    }

    public void uiTest2(){
        System.out.println("Wrong");
    }
}
