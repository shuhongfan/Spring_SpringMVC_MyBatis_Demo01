package com.shf.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

public class JdbcTemplateTest {
    @Test
    public void test1() throws PropertyVetoException {
//        创建数据源对象
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test1");
        dataSource.setUser("root");
        dataSource.setPassword("root");

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
//        设置数据源
        jdbcTemplate.setDataSource(dataSource);
//        执行操作
        int row = jdbcTemplate.update("insert into account values (?,?)", "lisi", 10000);
        System.out.println(row);
    }

    @Test
    public void test2(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        int row = jdbcTemplate.update("insert into account values (?,?)", "ddfdss", 10000);
        System.out.println(row);
    }

    @Test
    public void test3(){

    }
}
