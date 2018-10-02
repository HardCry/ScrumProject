package com.example.demo.Controller;

import com.example.demo.Model.LoginModel;
import com.example.demo.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {


    @Autowired
    LoginRepository loginRepository;

    @GetMapping("/login")
    public String getInfoUser(Model model) {

        model.addAttribute("LoginModel", new LoginModel());

        return "/login";
    }


    @PostMapping("/login")
    public String verifyLogin(@ModelAttribute LoginModel loginModel) {


        if(loginRepository.controlLogin(loginModel.getUsername(),loginModel.getPassword()) == true){
            return "/adminHome";
        }else
        {
            return "/error";
        }

    }


}
