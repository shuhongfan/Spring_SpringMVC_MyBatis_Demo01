package com.shf.test;

import com.shf.domain.Order;
import com.shf.domain.User;
import com.shf.mapper.OrderMapper;
import com.shf.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest2 {
    private OrderMapper mapper;
    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        mapper = sqlSession.getMapper(OrderMapper.class);
    }

    @Test
    public void testSelect(){
        List<Order> orderList = mapper.findAll();
        System.out.println(orderList);
    }

    @Test
    public void testSelect2(){
        List<Order> orderList = mapper.findAll2();
        System.out.println(orderList);
    }

}
