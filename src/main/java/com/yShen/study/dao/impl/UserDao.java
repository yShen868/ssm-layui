package com.yShen.study.dao.impl;

import com.yShen.study.dao.IUserDao;
import com.yShen.study.model.User;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class UserDao extends SqlSessionDaoSupport implements IUserDao {
    @Resource
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
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
        return getSqlSession().selectList("User.selectAll");
    }

    @Override
    public User selectOne(User user) {
        return getSqlSession().selectOne("User.selectOne",user);
    }

    @Override
    public int selectbyuid(int r_id) {
        return getSqlSession().selectOne("User.selectbyuid",r_id);
    }
}
