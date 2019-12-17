package com.yShen.study.service;

import com.yShen.study.model.Role;

import java.util.List;
import java.util.Map;

public interface IRoleService {
    List<Role> selectAll(Map map);
    int count(Map map);
    void insert(Role role);
    void delete(int r_id);
    void update(Role role);

    Integer selectId(Role role);

    void insertrolesup(Integer integer, int id);

    List<Integer> find(Integer r_id);

    void deleterolesup(Integer r_id);
}
