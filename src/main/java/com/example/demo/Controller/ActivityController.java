package com.example.demo.Controller;


import com.example.demo.Model.ActivityModel;
import com.example.demo.Repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ActivityController
{
    @Autowired
    ActivityRepository activityRepository;


    @GetMapping("/create")
    public String create (Model model)
    {
        model.addAttribute("ActivityModel", new ActivityModel());

        return "CreateActivity";
    }

    @PostMapping("/create")
    public String postActivity(@ModelAttribute ActivityModel activityModel)
    {

        activityRepository.createActivity(activityModel);

        return "redirect:/adminHome";
    }

    @GetMapping("/delete")
    public String deleteActivity (@RequestParam("id") int id, Model model)
    {
        model.addAttribute("ActivityModel", activityRepository.getIdOnly(id));
        return "DeleteActivity";
    }

    @PostMapping("/delete")
    public String deleteActivity (@ModelAttribute ActivityModel activityModel)
    {
        activityRepository.deleteActivity(activityModel);
        return "redirect:/adminHome";
    }

    //Value og return skal udfyldes
    //Value skal beholde /{id}, altså er det
    //... der skal erstattes med et link
    @GetMapping("/edit")
    public String updateActivity(@RequestParam("id") int id, Model model)
    {
        ActivityModel activityModel = activityRepository.getOnId(id);
        model.addAttribute("ActivityModel", activityRepository.getOnId(id));

        return "EditActivity";
    }

    //Value og return skal udfyldes, når adressen er kendt
    @PostMapping("/edit")
    public String updateActivity(@ModelAttribute ActivityModel activityModel, RedirectAttributes rdt)
    {
        
        activityRepository.updateActivity(activityModel);

        return "redirect:/adminHome";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getActivityList(Model model)
    {
        model.addAttribute("activities", activityRepository.getList());
        return "home";
    }
    @GetMapping ("/details")
    public String getDetails (@RequestParam ("id") int id, Model model)
    {
        model.addAttribute("ActivityModel", activityRepository.getOnId(id));
        return "ActivityDetails";
    }

}