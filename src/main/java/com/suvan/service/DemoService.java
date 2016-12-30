package com.suvan.service;

import com.suvan.common.base.BaseService;
import com.suvan.entity.Demo;
import com.suvan.mapper.model.MDemo;

import java.util.List;

/**
 * @author suvan
 * @create 2016-12-29-11:13
 */
public interface DemoService extends BaseService {
    /**
     * 使用springjdbc方式获取数据
     * @return
     */
    List<Demo> getDemoList();

    /**
     * 使用mybatis方式获取数据
     * @return
     */
    List<MDemo> getDemoListByExample();
}
