package com.shf.factory;

import com.shf.dao.UserDao;
import com.shf.dao.impl.UserDaoImpl;

public class StaticFactory {
    public static UserDao getUserDao() {
        return new UserDaoImpl();
    }
}
