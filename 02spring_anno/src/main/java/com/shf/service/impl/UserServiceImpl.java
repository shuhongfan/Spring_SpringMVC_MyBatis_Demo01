package com.shf.service.impl;

import com.shf.dao.UserDao;
import com.shf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

//<bean id="userService" class="com.shf.service.impl.UserServiceImpl">
@Service("userService")
//@Scope("singleton")
public class UserServiceImpl implements UserService {
//    <property name="userDao" ref="userDao"/>

    @Autowired  //按照数据类型从Spring容器中进行匹配
//    @Qualifier("userDao")  // 按照id值从容器总进行匹配的，要和@Autowired结合使用
//    @Resource(name = "userDao")
    private UserDao userDao;
//    注解方式 可以不写
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    @Override
    public void save() {
        userDao.save();
    }

    @PostConstruct
    public void init(){
        System.out.println("init");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("destory");
    }
}
