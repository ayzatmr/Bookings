package com.example.repository;

import com.example.entity.HotelBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Ayzat on 26.01.2017.
 */
@Repository
public interface BookingsRepository extends JpaRepository<HotelBooking, Long> {

    List<HotelBooking> findByPricePerNightLessThan(int price);
}
