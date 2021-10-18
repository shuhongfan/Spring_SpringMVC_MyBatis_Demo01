package com.shf.dao.impl;

import com.shf.dao.UserDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Value("${jdbc.driver}")
    private String drivers;

    @Override
    public void save() {
        System.out.println("save running...");
        System.out.println(drivers);
    }
}
