package com.suvan.common.base;

import com.suvan.common.constants.ConfigConstants;
import org.springframework.web.portlet.ModelAndView;

/**
 * @author suvan
 * @create 2016-12-28-15:03
 */
public class BaseController extends BaseClass {

    /**
     * 跳转到通用错误页面
     * @param errMsg 错误信息
     * @return 通用错误页面
     */
    public ModelAndView goToErrorPage(String errMsg) {
        ModelAndView mav = new ModelAndView(ConfigConstants.COMMON_ERROR_PAGE);
        mav.addObject(ConfigConstants.ERROR_MSG, errMsg);
        return mav;
    }
}
