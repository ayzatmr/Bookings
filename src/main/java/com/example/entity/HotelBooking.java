package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Ayzat on 26.01.2017.
 */
@Entity
public class HotelBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String hotelName;
    private int pricePerNight;
    private int nbOfNights;

    public HotelBooking(){}

    public HotelBooking(String hotelName, int pricePerNight, int nbOfNights){
        this.hotelName = hotelName;
        this.pricePerNight = pricePerNight;
        this.nbOfNights = nbOfNights;
    }

    public int getNbOfNights() {
        return nbOfNights;
    }

    public String getHotelName() {
        return hotelName;
    }

    public int getPricePerNight() {
        return pricePerNight;
    }

    public int getTotalPrice(){
        return pricePerNight * nbOfNights;
    }

    public long getId() {
        return id;
    }
}