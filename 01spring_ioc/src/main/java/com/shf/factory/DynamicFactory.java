package com.shf.factory;

import com.shf.dao.UserDao;
import com.shf.dao.impl.UserDaoImpl;

public class DynamicFactory {
    public UserDao getUserDao() {
        return new UserDaoImpl();
    }
}
