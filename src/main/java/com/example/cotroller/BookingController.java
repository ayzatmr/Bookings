package com.example.cotroller;

import com.example.repository.BookingsRepository;
import com.example.entity.HotelBooking;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.pojo.ApiStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Ayzat on 26.01.2017.
 */
@RestController
@RequestMapping(value = "/bookings")
@Api(name = "Hotel Booking API", description = "Provides a list of methods that manage hotel bookings", stage = ApiStage.RC)
public class BookingController {

    BookingsRepository bookingsRepository;

    @Autowired
    public BookingController(BookingsRepository bookingsRepository) {
        this.bookingsRepository = bookingsRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ApiMethod(description = "Get all hotel bookings from database" )
    public List<HotelBooking> getAll() {
        return bookingsRepository.findAll();
    }

    @RequestMapping(value = "/affordable/{price}")
    @ApiMethod(description = "Get all bookings where the price per night is less than the provided value ")
    public List<HotelBooking> getAffordable(@ApiPathParam( name = "price")@PathVariable int price) {
        return bookingsRepository.findByPricePerNightLessThan(price);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ApiMethod(description = "Create a hotel booking and save it to the database ")
    public List<HotelBooking> create(@RequestBody HotelBooking hotelBooking) {
        bookingsRepository.save(hotelBooking);
        return bookingsRepository.findAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ApiMethod(description = "Delete the hotel booking with provided id from the database ")
    public List<HotelBooking> remove(@ApiPathParam(name = "id")@PathVariable long id) {
        bookingsRepository.delete(id);
        return bookingsRepository.findAll();
    }
}
