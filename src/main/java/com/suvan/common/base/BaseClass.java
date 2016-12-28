package com.suvan.common.base;

import com.suvan.common.constants.ConfigConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.portlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author suvan
 * @create 2016-12-28-10:16
 */
public class BaseClass {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 全局获取request
     * 主要用于非controller层获取request
     * @return HttpServletRequest
     */
    public HttpServletRequest getRequest() {
        return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * 全局获取session
     * @return HttpSession
     */
    public HttpSession getSession() {
        return getRequest().getSession();
    }

    /**
     * 获取当前请求路径
     * http:// 127.0.0.1/springmvcdemointellij/index.html
     * @return String
     */
    public String getPath() {
        return getRequest().getRequestURL().toString();
    }

    /**
     * 获取项目请求路径
     * http://127.0.0.1/springmvcdemointellij/
     * @return String
     */
    public String getProjectPath() {
        return getPath().replace(getRequest().getServletPath(), "") + "/";
    }

    /**
     * 获取session数据
     * @param key
     * @return Object
     */
    public Object getSessionAttribute(String key) {
        return getSession().getAttribute(key);
    }

    /**
     * 跳转到通用错误页面
     * @param errMsg
     * @return ModelAndView
     */
    public ModelAndView goToErrorPage(String errMsg) {
        ModelAndView mav = new ModelAndView(ConfigConstants.COMMON_ERROR_PAGE);
        mav.addObject(ConfigConstants.ERROR_MSG, errMsg);
        return mav;
    }
}