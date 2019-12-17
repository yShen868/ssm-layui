package com.yShen.study.dao.impl;

import com.yShen.study.dao.IRolesupDao;
import com.yShen.study.model.User;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class RolesupDao extends SqlSessionDaoSupport implements IRolesupDao {
    @Resource
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public List<Integer> selectoneuser(User user) {
        return getSqlSession().selectList("Rolesup.selectoneuser",user);
    }
}
