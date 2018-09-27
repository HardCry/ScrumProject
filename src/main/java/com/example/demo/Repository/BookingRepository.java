package com.example.demo.Repository;

import com.example.demo.Model.BookingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookingRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void SaveReservationToDB(BookingModel model)
    {
        //hurtig test
        //skal laves om og hvert model attribute skal gemmes i DB
        String tempDate = model.toString();
        String insertDateIntoDBTest = "INSERT INTO booking(time, date, activity_id) " +
                "values(" +
                "'hehe'," + "'" + tempDate
                + "',12)";
        jdbcTemplate.update(insertDateIntoDBTest);

    }
}
