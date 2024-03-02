package com.putubgs.LibSystem;

import java.util.UUID;

import com.putubgs.LibSystem.model.*;

public class App 
{
    public static void main( String[] args )
    {
        Book book = new Book(UUID.randomUUID().toString(), "Test", "Putu", true);
        System.out.println(book);
        User user = new User(UUID.randomUUID().toString(), "Putu");
        System.out.println(user);
    }

}
