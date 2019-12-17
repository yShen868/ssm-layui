package com.yShen.study.service.impl;


import com.yShen.study.dao.IRolesupDao;
import com.yShen.study.dao.ISidebarSupDao;
import com.yShen.study.model.SidebarSup;
import com.yShen.study.model.User;
import com.yShen.study.service.ISidebarSupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SidebarSupService implements ISidebarSupService {

    private ISidebarSupDao sidebarSupDao;

    public ISidebarSupDao getSidebarSupDao() {
        return sidebarSupDao;
    }
    @Autowired
    public void setSidebarSupDao(ISidebarSupDao sidebarSupDao) {
        this.sidebarSupDao = sidebarSupDao;
    }

    private IRolesupDao rolesupDao;

    public IRolesupDao getRolesupDao() {
        return rolesupDao;
    }
    @Autowired
    public void setRolesupDao(IRolesupDao rolesupDao) {
        this.rolesupDao = rolesupDao;
    }

    @Override
    public List<SidebarSup> listAll() {
        return sidebarSupDao.listAll();
    }

    @Override
    public List<SidebarSup> listAllbyid(User user) {
        List<Integer> selectoneuser = rolesupDao.selectoneuser(user);
        List<SidebarSup> list = sidebarSupDao.listAllbyid(selectoneuser);

        return list;
    }

    @Override
    public List<SidebarSup> select() {
        return sidebarSupDao.select();
    }
}
