package com.example.demo.Controller;

import com.example.demo.Model.ActivityModel;
import com.example.demo.Repository.ActivityRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ActivityController
{
    ActivityRepository activityRepository;


    @RequestMapping(value = "/CreateActivity", method = RequestMethod.GET)
    public String create (Model model)
    {
        model.addAttribute("ActivityModel", new ActivityModel());
        return "ActivityCreate";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST  )
    public String postActivity(@ModelAttribute ActivityModel activityModel)
    {
        activityRepository.createActivity(activityModel);

        return "redirect:/created/";
    }

    


}
