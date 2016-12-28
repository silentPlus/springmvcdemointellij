package com.suvan.controller;

import com.suvan.common.base.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

/**
 * @author suvan
 * @create 2016-12-28-15:17
 */
@RequestMapping("demo")
public class DemoController extends BaseController {

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        return mav;
    }
}
