package com.yShen.study.dao.impl;

import com.yShen.study.dao.ISidebarSupDao;
import com.yShen.study.model.SidebarSup;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SidebarSupDao extends SqlSessionDaoSupport implements ISidebarSupDao {

    @Resource
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public List<SidebarSup> listAll() {
        List<SidebarSup> list = getSqlSession().selectList("SidebarSup.listAll");
        System.out.println(list);
        return list;
    }

    @Override
    public List<SidebarSup> listAllbyid(List<Integer> list) {
        List<SidebarSup> lists = getSqlSession().selectList("SidebarSup.listAllbyid" ,list);
        return lists;
    }

    @Override
    public List<SidebarSup> select() {
        return getSqlSession().selectList("SidebarSup.select");
    }
}
