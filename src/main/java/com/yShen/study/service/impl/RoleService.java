package com.yShen.study.service.impl;

import com.yShen.study.dao.IRoleDao;
import com.yShen.study.model.Role;
import com.yShen.study.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleService implements IRoleService {

    IRoleDao roleDao;

    public IRoleDao getRoleDao() {
        return roleDao;
    }
    @Autowired
    public void setRoleDao(IRoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> selectAll(Map map) {
        return roleDao.selectAll(map);
    }

    @Override
    public int count(Map map) {
        return roleDao.count(map);
    }

    @Override
    public void insert(Role role) {
         roleDao.insert(role);
    }

    @Override
    public void delete(int r_id) {
        roleDao.delete(r_id);
    }

    @Override
    public void update(Role role) {
        roleDao.update(role);
    }

    @Override
    public Integer selectId(Role role) {
        return roleDao.selectId(role);
    }

    @Override
    public void insertrolesup(Integer integer, int id) {
        Map<String,Integer> map = new HashMap<>();
        map.put("role_id",integer);
        map.put("sup_id",id);
        roleDao.insertrolesup(map);
    }

    @Override
    public List<Integer> find(Integer r_id) {
        return roleDao.find(r_id);
    }

    @Override
    public void deleterolesup(Integer r_id) {
        roleDao.deleterolesup(r_id);
    }
}
