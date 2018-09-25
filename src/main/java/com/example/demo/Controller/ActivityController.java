package com.example.demo.Controller;


import com.example.demo.Model.Activity;
import com.example.demo.Repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ActivityController
{
    @Autowired
    ActivityRepository activityRepository;


    @GetMapping("/create")
    public String create (Model model)
    {
        model.addAttribute("Activity", new Activity());

        return "CreateActivity";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST  )
    public String postActivity(@ModelAttribute Activity activity, BindingResult bindingResult)
    {

        activityRepository.createActivity(activity);

        return "redirect:/created/";
    }
}