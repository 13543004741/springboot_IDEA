package org.test01.service.impl;

import org.test01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by langye on 2017/12/14.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void createJdbcUser() {
        jdbcTemplate.update("INSERT INTO USER_INFO VALUES (NULL,?,?);","user3","12345");
    }
}

