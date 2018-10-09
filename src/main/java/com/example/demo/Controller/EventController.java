package com.example.demo.Controller;

import com.example.demo.Model.ActivityModel;
import com.example.demo.Model.EventModel;
import com.example.demo.Repository.ActivityRepository;
import com.example.demo.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EventController
{
//get bookings here

    @Autowired
    EventRepository eventRepository;

    //hov hov fyfy Dette er forkert, men er den eneste
    // måde vi kan få de infrmationer vi skal have
    //TODO lave en over controller sådan at vi kan passe informationer mellem de forskellige controller
    @Autowired
    ActivityRepository activityRepository;

    @GetMapping("/CreateEvent")
    public String create (Model model)
    {
        model.addAttribute("eventModel", new EventModel());
        model.addAttribute("activityList", activityRepository.getList());

        return "CreateEvent";
    }

    @PostMapping("/CreateEvent")
    public String postActivity(@ModelAttribute EventModel eventModel)
    {
        /*
        TODO: This object is null when getting from the view ie CreateEvent.html
        the object that is null, is event
        TODO: have hidden ID in view html file
         */
        System.out.println(eventModel.getDate());
        System.out.println(eventModel.getTime());
        System.out.println(eventModel.getActivityModel());


        System.out.println();

        eventRepository.createEvent(eventModel);



        return "redirect:/home";
    }

    @GetMapping("/home/events")
    public String getEventList(Model model)
    {
        model.addAttribute("events", eventRepository.getList());
        return "eventlist";
    }



    /*@RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getActivityList(Model model)
    {
        model.addAttribute("activities", activityRepository.getList());
        return "home";
    }*/
}
