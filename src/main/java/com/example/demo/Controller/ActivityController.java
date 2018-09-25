package com.example.demo.Controller;

import com.example.demo.Repository.ActivityRepository;
import org.springframework.context.annotation.Conditional;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

@Controller
public class ActivityController
{
    ActivityRepository activityRepository;


    public void createActivity()
    {
        activityRepository.createActivity();
    }
}
