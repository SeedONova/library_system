package com.putubgs.LibSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.util.UUID;
import java.util.Date;

@Entity
@Table (name = "checkout_record")
public class CheckoutRecord {
    @Id
    
    private UUID checkoutId;
    private UUID bookId;
    private UUID userId;
    private Date checkoutDate;
    private Date returnDate;

    public void setBookId(UUID bookId){
        this.bookId = bookId;
    }

    public void setUserId(UUID userId){
        this.userId = userId;
    }

    public void setCheckoutDate(Date checkoutDate){
        this.checkoutDate = checkoutDate;
    }

    public void setReturnDate(Date returnDate){
        this.returnDate = returnDate;
    }
}
