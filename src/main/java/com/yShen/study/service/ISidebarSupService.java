package com.yShen.study.service;


import com.yShen.study.model.SidebarSup;
import com.yShen.study.model.User;

import java.util.List;

public interface ISidebarSupService {

    List<SidebarSup> listAll();

    List<SidebarSup> listAllbyid(User user);
    List<SidebarSup> select();
}
