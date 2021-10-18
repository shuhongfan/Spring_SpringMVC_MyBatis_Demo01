package com.shf.service.impl;

import com.shf.dao.RoleDao;
import com.shf.dao.UserDao;
import com.shf.domain.Role;
import com.shf.domain.User;
import com.shf.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<User> list() {
        List<User> userList = userDao.findAll();
        for (User user : userList){
//            获得user的id
            Long id = user.getId();
//            将id作为参数 查询当前UserId对应的Role集合数据
            List<Role> roles = roleDao.findRoleByUserId(id);
            user.setRoles(roles);
        }
        return userList;
    }

    @Override
    public void save(User user, Long[] roleIds) {
//        向sys_user表中存储数据
        Long userId = userDao.save(user);
//        向sys_user_role关系表中存储多条数据
        userDao.saveUserRole(userId,roleIds);
    }

    @Override
    public void del(Long userId) {
//        删除sys_user_role关系表
        userDao.delUserRoleRel(userId);
//        删除sys_user表
        userDao.del(userId);
    }

    @Override
    public User login(String username, String password) {
        User user = null;
        try {
            user = userDao.findByUsernameAndPassword(username,password);
        } catch (Exception e) {
            return null;
        }
        return user;
    }
}
