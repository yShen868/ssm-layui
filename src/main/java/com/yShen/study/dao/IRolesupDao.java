package com.yShen.study.dao;

import com.yShen.study.model.User;

import java.util.List;

public interface IRolesupDao {

    List<Integer> selectoneuser(User user);
}
