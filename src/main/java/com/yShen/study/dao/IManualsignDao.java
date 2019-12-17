package com.yShen.study.dao;

import com.yShen.study.model.Manualsign;

import java.util.List;
import java.util.Map;

public interface IManualsignDao {

    void insert(Manualsign manualsign);
    List<Manualsign> selectAll(Manualsign manualsign);
    List<Manualsign> selectAllpage(Map map);
    int selecttoday(Map<String,Object> map);
    Long count(Map<String, Object> map);
}
