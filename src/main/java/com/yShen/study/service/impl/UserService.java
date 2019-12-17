package com.yShen.study.service.impl;

import com.yShen.study.dao.IUserDao;
import com.yShen.study.model.User;
import com.yShen.study.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    private IUserDao userDao;

    public IUserDao getUserDao() {
        return userDao;
    }
    @Autowired
    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void insert(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void count(User user) {

    }

    @Override
    public List<User> selectAll(User user) {
        return userDao.selectAll(user);
    }

    @Override
    public User selectOne(User user) {
        return userDao.selectOne(user);
    }

    @Override
    public int selectbyuid(int r_id) {
        return userDao.selectbyuid(r_id);
    }
}
