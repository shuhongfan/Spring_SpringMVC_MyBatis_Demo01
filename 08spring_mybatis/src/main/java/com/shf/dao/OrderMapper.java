package com.shf.dao;

import com.shf.domain.Order;

import java.util.List;

public interface OrderMapper {
    public List<Order> findAll();
}
