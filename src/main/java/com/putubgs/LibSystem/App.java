package com.putubgs.LibSystem;

import java.util.UUID;

import com.putubgs.LibSystem.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import com.putubgs.LibSystem.view.UI;

public class App 
{  
    public static void main( String[] args )
    {
        UI ui = new UI();
        ui.homePage();
    }

}
