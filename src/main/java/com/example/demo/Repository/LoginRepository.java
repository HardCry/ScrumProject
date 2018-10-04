package com.example.demo.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

@Repository
public class LoginRepository {
    @Autowired
    private JdbcTemplate jdbc;

    public boolean controlLogin(String username, String password) {

        String sql = "SELECT * FROM Login";


        SqlRowSet rs = jdbc.queryForRowSet(sql);
        rs.next();



        if(username.equals(rs.getString(1))){
            if(password.equals(rs.getString(2))){
                return true;
            }
        }



        return false;

    }

}
