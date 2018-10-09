package com.example.demo.Controller;

import com.example.demo.Model.LoginModel;
import com.example.demo.Repository.ActivityRepository;
import com.example.demo.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {


    @Autowired
    LoginRepository loginRepository;

    @Autowired
    ActivityRepository activityRepository;

    @GetMapping("/login")
    public String getInfoUser(Model model) {

        model.addAttribute("LoginModel", new LoginModel());

        return "/login";
    }


    @RequestMapping(value = "/adminHome", method = RequestMethod.GET)
    public String getActivityList(Model model)
    {
        model.addAttribute("activities", activityRepository.getList());
        return "adminHome";
    }

    @PostMapping("/login")
    public String verifyLogin(@ModelAttribute LoginModel loginModel) {


        if(loginRepository.controlLogin(loginModel.getUsername(),loginModel.getPassword()) == true){
            return "redirect:/adminHome";
        }else
        {
            return "/error";
        }

    }




}
