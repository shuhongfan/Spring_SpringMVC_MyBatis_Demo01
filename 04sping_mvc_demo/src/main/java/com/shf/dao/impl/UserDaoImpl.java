package com.shf.dao.impl;

import com.shf.dao.UserDao;
import com.shf.domain.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findAll() {
        List<User> userList = jdbcTemplate.query("select * from sys_user", new BeanPropertyRowMapper<User>(User.class));
        return userList;
    }


    @Override
    public Long save(User user) {
//        创建PreparedStatementCreator
        PreparedStatementCreator creator = new PreparedStatementCreator(){
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
//                使用原始jdbc完成PreparedStatement
                PreparedStatement preparedStatement = connection.prepareStatement("insert into sys_user values (?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setObject(1,null);
                preparedStatement.setString(2, user.getUsername());
                preparedStatement.setString(3,user.getEmail());
                preparedStatement.setString(4,user.getPassword());
                preparedStatement.setString(5,user.getPhoneNum());
                return preparedStatement;
            }
        };
//        创建keyHolder
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(creator,keyHolder);
//        返回当前保存用户的id
        long userId = keyHolder.getKey().longValue();
        return userId;
    }

    @Override
    public void saveUserRole(Long id, Long[] roleIds) {
        for (Long roleId : roleIds) {
            jdbcTemplate.update("insert into sys_user_role values (?,?)",id,roleId);
        }
    }

    @Override
    public void delUserRoleRel(Long userId) {
        jdbcTemplate.update("delete from sys_user_role where userId=?",userId);
    }

    @Override
    public void del(Long userId) {
        jdbcTemplate.update("delete from sys_user where id=?",userId);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) throws EmptyResultDataAccessException {
        User user = jdbcTemplate.queryForObject("select * from sys_user where username=? and password=?", new BeanPropertyRowMapper<User>(User.class), username, password);
        return user;
    }
}
