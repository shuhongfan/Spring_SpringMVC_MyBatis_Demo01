package com.shf.demo;

import com.shf.service.UserService;
import com.shf.service.impl.UserServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserController {
    public static void main(String[] args) {
//        UserServiceImpl userService = new UserServiceImpl();
//        userService.save();

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        根据bean id获取
//        UserService userService = (UserService) context.getBean("userService");
//        根据类型获取
        UserService userService = context.getBean(UserService.class);
        userService.save();

//        UserServiceImpl userService1 = new UserServiceImpl(); //java.lang.NullPointerException
//        userService1.save();
    }
}
