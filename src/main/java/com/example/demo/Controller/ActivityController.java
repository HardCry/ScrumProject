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
        model.addAttribute("Activity", new ActivityModel());

        return "CreateActivity";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST  )
    public String postActivity(@ModelAttribute ActivityModel activityModel, BindingResult bindingResult)
    {

        activityRepository.createActivity(activityModel);

        return "redirect:/created/";
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
        return "redirect:/...";
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