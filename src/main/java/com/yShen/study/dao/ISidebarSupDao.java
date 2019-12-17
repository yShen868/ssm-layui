package com.yShen.study.dao;

import com.yShen.study.model.SidebarSup;

import java.util.List;

public interface ISidebarSupDao {

    List<SidebarSup> listAll();
    List<SidebarSup> listAllbyid(List<Integer> list);
    List<SidebarSup> select();
}
