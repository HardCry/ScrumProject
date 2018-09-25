package com.example.demo.Controller;

import com.example.demo.Model.ActivityModel;
import com.example.demo.Repository.ActivityRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ActivityController
{
    ActivityRepository activityRepository;


    @RequestMapping(value = "/CreateActivity", method = RequestMethod.GET)
    public String create (Model model)
    {
        model.addAttribute("activitymodel", new ActivityModel());
        return "ActivityCreate";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String postActivity(@ModelAttribute ActivityModel activityModel)
    {
        activityRepository.createActivity(activityModel);

        return "redirect:/created/";
    }

    //Value og return skal udfyldes
    //Value skal beholde /{id}, altså er det
    //... der skal erstattes med et link
    @RequestMapping(value = "/.../{id}", method = RequestMethod.GET)
    public String updateActivity(@PathVariable int id, Model model)
    {
        ActivityModel activityModel = activityRepository.getOnId(id);
        model.addAttribute("activitymodel", activityModel);

        return "/...";
    }

    //Value og return skal udfyldes, når adressen er kendt
    @RequestMapping(value = "/...", method = RequestMethod.POST)
    public String updateActivity(@ModelAttribute ActivityModel activityModel, RedirectAttributes rdt)
    {
        rdt.addFlashAttribute("message", "Aktivetet opdateret");
        activityRepository.updateActivity(activityModel);

        return "/...";
    }


}
