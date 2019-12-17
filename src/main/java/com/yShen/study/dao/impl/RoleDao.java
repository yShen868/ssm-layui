package com.yShen.study.dao.impl;

import com.yShen.study.dao.IRoleDao;
import com.yShen.study.model.Role;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository
public class RoleDao extends SqlSessionDaoSupport implements IRoleDao {
    @Resource
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }


    @Override
    public List<Role> selectAll(Map map) {
        List<Role> list =  getSqlSession().selectList("Role.selectAll",map);
        return list;
    }

    @Override
    public int count(Map map) {
        Integer integer =  getSqlSession().selectOne("Role.count",map);
        return integer;

    }

    @Override
    public void insert(Role role) {
        getSqlSession().insert("Role.insert",role);
    }

    @Override
    public void delete(int r_id) {
        getSqlSession().delete("Role.delete",r_id);
    }

    @Override
    public void update(Role role) {
        getSqlSession().update("Role.update",role);

    }

    @Override
    public Integer selectId(Role role) {
        return getSqlSession().selectOne("Role.selectId",role);
    }

    @Override
    public void insertrolesup(Map<String, Integer> map) {
        getSqlSession().insert("Role.insertrolesup",map);
    }

    @Override
    public List<Integer> find(Integer r_id) {
        return getSqlSession().selectList("Role.find",r_id);
    }

    @Override
    public void deleterolesup(Integer r_id) {
        getSqlSession().delete("Role.deleterolesup",r_id);
    }
}
