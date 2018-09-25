package com.example.demo.Controller;

import com.example.demo.Model.Activity;
import com.example.demo.Repository.ActivityRepository;
import org.springframework.context.annotation.Conditional;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ActivityController
{
    ActivityRepository activityRepository;


    @RequestMapping(value = "/create", method = RequestMethod.POST  )
    public void postActivity(@ModelAttribute Activity model)
    {
        activityRepository.createActivity(model);
    }
}
