package com.yShen.study.dao;

import com.yShen.study.model.User;

import java.util.List;

public interface IUserDao {
    void insert(User user);
    void delete(User user);
    void count(User user);
    List<User> selectAll(User user);
    User selectOne(User user);

    int selectbyuid(int r_id);
}
