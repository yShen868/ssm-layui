package com.yShen.study.service.impl;


import com.yShen.study.dao.IManualsignDao;
import com.yShen.study.model.Manualsign;
import com.yShen.study.service.IManualsignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ManualsignService implements IManualsignService {

    IManualsignDao manualsignDao;

    public IManualsignDao getManualsignDao() {
        return manualsignDao;
    }
    @Autowired
    public void setManualsignDao(IManualsignDao manualsignDao) {
        this.manualsignDao = manualsignDao;
    }
    @Override
    public void insert(Manualsign manualsign) {
        manualsignDao.insert(manualsign);
    }
    @Override
    public List<Manualsign> selectAll(Manualsign manualsign) {
        return manualsignDao.selectAll(manualsign);
    }

    @Override
    public int selecttoday(Map<String, Object> map) {
        return manualsignDao.selecttoday(map);
    }

    @Override
    public List<Manualsign> selectAllpage(Map map) {
        return manualsignDao.selectAllpage(map);
    }

    @Override
    public Long count(Map<String, Object> map) {
        return manualsignDao.count(map);
    }
}
