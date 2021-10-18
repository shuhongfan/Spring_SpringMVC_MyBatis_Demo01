package com.shf.service;

import com.shf.domain.Role;

import java.util.List;

public interface RoleService {
    public List<Role> list();

    public void save(Role role);
}
