package com.yShen.study.dao.impl;

import com.yShen.study.dao.IManualsignDao;
import com.yShen.study.model.Manualsign;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository
public class ManualsignDao extends SqlSessionDaoSupport implements IManualsignDao {
    @Resource
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }
    @Override
    public void insert(Manualsign manualsign) {
        getSqlSession().insert("Manualsign.insert",manualsign);
    }
    @Override
    public List<Manualsign> selectAll(Manualsign manualsign) {
        return getSqlSession().selectList("Manualsign.selectAll",manualsign);
    }

    @Override
    public List<Manualsign> selectAllpage(Map map) {

        List<Manualsign> list = getSqlSession().selectList("Manualsign.selectAllpage",map);
        System.out.println(list);
        return list;
    }
    @Override
    public Long count(Map<String, Object> map) {

         int count = getSqlSession().selectOne("Manualsign.count",map);
         return (long) count;
    }



    @Override
    public int selecttoday(Map<String, Object> map) {
        return getSqlSession().selectOne("Manualsign.selecttoday",map);
    }


}
