package com.suvan.service;

import com.suvan.common.base.BaseService;
import com.suvan.entity.Demo;

import java.util.List;

/**
 * @author suvan
 * @create 2016-12-29-11:13
 */
public interface DemoService extends BaseService {
    List<Demo> getDemoList();
}
