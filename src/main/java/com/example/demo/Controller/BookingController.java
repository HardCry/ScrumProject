package com.example.demo.Controller;

import com.example.demo.Model.BookingModel;
import com.example.demo.Repository.BookingRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookingController {

    BookingRepository bookingRepository;

    @RequestMapping(value="/ViewBookings", method=RequestMethod.GET)
    public String viewAllBookings()
    {
        //hent et helt rowset fra databasen og smid op på hjemmesiden
        return "/ViewBookings";
    }

    @RequestMapping(value="/CreateBookings",method = RequestMethod.GET)
    public String createBooking(Model model)
    {
        System.out.println("works");
        model.addAttribute("bookingModel",new BookingModel());

        return "/CreateBookings";
    }

    @RequestMapping(value="/CreateBookings",method=RequestMethod.POST)
    public String createBooking(@ModelAttribute BookingModel model)
    {
        //nogle attributter fra HTML er null her
        //så den passer ikke model ordentlig ned i databasen og giver en null ref error
        //kig i BOOKINGREPOSITORY.java filen og ret SQL statement

        //samt kig i CreateBookings.html filen og opdater mode attributes i form til at oprette en booking
        System.out.println(model);
        bookingRepository.SaveReservationToDB(model);
        return "/CreateBookings";
    }


}
