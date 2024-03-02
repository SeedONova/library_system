package com.putubgs.LibSystem;

import java.util.UUID;

import com.putubgs.LibSystem.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("library_system");
        EntityManager em = emf.createEntityManager();
        em.close();
    }

}
