package com.example.util;

import com.example.entity.HotelBooking;
import com.example.repository.BookingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ayzat on 26.01.2017.
 */
@Component
public class DatabaseSeeder implements CommandLineRunner {

    private BookingsRepository bookingsRepository;

    @Autowired
    public DatabaseSeeder(BookingsRepository bookingsRepository) {
        this.bookingsRepository = bookingsRepository;
    }


    @Override
    public void run(String... strings) throws Exception {
        List<HotelBooking> bookings = new ArrayList<>();
        bookings.add(new HotelBooking("Marriot", 100, 2));
        bookings.add(new HotelBooking("Ibis", 90, 4));
        bookings.add(new HotelBooking("Novotel", 140, 3));
        bookingsRepository.save(bookings);
    }
}
