package com.suvan.service;

import com.suvan.common.base.BaseDaoImpl;
import com.suvan.common.base.BaseServiceImpl;
import com.suvan.entity.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author suvan
 * @create 2016-12-29-11:52
 */
@Service("demoServiceImpl")
public class DemoServiceImpl extends BaseServiceImpl implements DemoService {

    @Autowired
    BaseDaoImpl<Demo> demoBaseDao;

    @Override
    public List<Demo> getDemoList() {
        String sql = "select * from demo";
        return demoBaseDao.getList(sql, Demo.class);
    }
}
