package com.suvan.controller;

import com.suvan.common.base.BaseController;
import com.suvan.common.entity.AjaxResult;
import com.suvan.entity.Demo;
import com.suvan.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.portlet.ModelAndView;

import java.util.List;

/**
 * @author suvan
 * @create 2016-12-28-15:17
 */
@RestController
@RequestMapping("demo")
public class DemoController extends BaseController {

    @Autowired
    DemoService demoServiceImpl;


    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        return mav;
    }

    @RequestMapping("/getdata")
    public AjaxResult getData() {
        AjaxResult ajaxResult = new AjaxResult();
        List<Demo> data = demoServiceImpl.getDemoList();
        ajaxResult.setEntity(data);
        return ajaxResult;
    }

}
