package com.shf.mapper;

import com.shf.domain.Order;
import com.shf.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrderMapper {
    @Select("select *,o.id oid from `order` o,user u where o.uid=u.id")
    @Results({
            @Result(column = "oid",property = "id"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "total",property = "total"),
            @Result(column = "uid",property = "user.id"),
            @Result(column = "username",property = "user.username"),
            @Result(column = "password",property = "user.password"),
            @Result(column = "birthday",property = "user.birthday"),
    })
    public List<Order> findAll();

    @Select("select * from `order`")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "total",property = "total"),
            @Result(
                    property = "user", // 要封装的属性名称
                    column = "uid", // 根据哪个字段去查询user表中的数据
                    javaType = User.class,  // 要封装的实体类型
                    // select属性  代表查询那个接口的方法获得数据
                    one = @One(select = "com.shf.mapper.UserMapper.findById")
            )
    })
    public List<Order> findAll2();

    @Select("select * from `order` where uid=#{uid}")
    public List<Order> findByUid(int uid);
}
