package com.shf.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shf.dao.OrderMapper;
import com.shf.dao.UserMapper;
import com.shf.domain.Order;
import com.shf.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class MyBatisTest {
    @Test
    public void test1() throws IOException {
//        获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
//        获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//        获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        执行操作
        List<User> list = sqlSession.selectList("userMapper.findAll");
//        打印数据
        System.out.println(list);
//        释放资源
        sqlSession.close();
    }

    @Test
    public void test2() throws IOException {
//        模拟User对象
        User user = new User();
        user.setUsername("haha");
        user.setPassword("abc");

//        获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
//        获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//        获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
//        执行操作
        int row = sqlSession.insert("userMapper.save", user);
//        打印数据
        System.out.println(row);
//        maBatis执行更新操作 提交事务
//        sqlSession.commit();
//        释放资源
        sqlSession.close();
    }

    @Test
    public void test3() throws IOException {
//        模拟User对象
        User user = new User();
        user.setId(1);
        user.setUsername("tom");
        user.setPassword("abc");

//        获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
//        获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//        获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        int update = sqlSession.update("userMapper.update", user);
        System.out.println(update);

//        maBatis执行更新操作 提交事务
        sqlSession.commit();
//        释放资源
        sqlSession.close();
    }

    @Test
    public void test4() throws IOException {

//        获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
//        获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//        获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        int delete = sqlSession.delete("userMapper.delete", 1);
        System.out.println(delete);

//        maBatis执行更新操作 提交事务
        sqlSession.commit();
//        释放资源
        sqlSession.close();
    }

    @Test
    public void test5() throws IOException {
//        获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
//        获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//        获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        执行操作
        User user = sqlSession.selectOne("userMapper.findById", 2);
        System.out.println(user);
//        释放资源
        sqlSession.close();
    }

    @Test
    public void test6() throws IOException {
        //        获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
//        获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//        获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User condition = new User();
        condition.setId(2);
//        condition.setUsername("lisi");
//        condition.setPassword("123");

        List<User> userList = mapper.findByCondition(condition);
        System.out.println(userList);
    }

    @Test
    public void test7() throws IOException {
        //        获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
//        获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//        获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(2);
        ids.add(5);

        List<User> userList = mapper.findByIds(ids);
        System.out.println(userList);
    }

    @Test
    public void test8() throws IOException {
        //        获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
//        获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//        获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setUsername("cheshi");
        user.setPassword("123");
        user.setBirthday(new Date());

        mapper.saveUser(user);

        sqlSession.close();
    }

    @Test
    public void test9() throws IOException {
        //        获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
//        获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//        获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.findById(6);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void test10() throws IOException {
        //        获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
//        获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//        获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

//        设置分页相关参数 当前页+每页显示的条数
        PageHelper.startPage(2,3);

        List<User> userList = mapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }

//        获得与分页相关参数
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        System.out.println("当前页："+pageInfo.getPageNum());
        System.out.println("每页显示条数："+pageInfo.getPageSize());
        System.out.println("总条数："+pageInfo.getTotal());
        System.out.println("总页数："+pageInfo.getPages());
        System.out.println("上一页："+pageInfo.getPrePage());
        System.out.println("下一页："+pageInfo.getNextPage());
        System.out.println("是否是第一个："+pageInfo.isIsFirstPage());
        System.out.println("是否是最后一个："+pageInfo.isIsLastPage());

        sqlSession.close();
    }

    @Test
    public void test11() throws IOException {
        //        获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
//        获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//        获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);

        List<Order> orderList = mapper.findAll();
        for (Order order : orderList) {
            System.out.println(order);
        }

        sqlSession.close();
    }

    @Test
    public void test12() throws IOException {
        //        获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
//        获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//        获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> allByOrder = mapper.findAllByOrder();
        System.out.println(allByOrder);

        sqlSession.close();
    }

    @Test
    public void test13() throws IOException {
        //        获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
//        获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//        获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> userAndRole = mapper.findUserAndRole();
        System.out.println(userAndRole);

        sqlSession.close();
    }
}
