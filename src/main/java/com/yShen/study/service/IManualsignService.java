package com.yShen.study.service;

import com.yShen.study.model.Manualsign;

import java.util.List;
import java.util.Map;

public interface IManualsignService {

    void insert(Manualsign manualsign);

    List<Manualsign> selectAll(Manualsign manualsign);

    public int selecttoday(Map<String, Object> map);

    public List<Manualsign> selectAllpage(Map map);

    Long count(Map<String, Object> map);
}