package com.suvan.common.base;

import com.alibaba.fastjson.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

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
    protected HttpServletRequest getRequest() {
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
     * http:// 127.0.0.1/springmvcdemointellij/index.html
     * @return 当前请求路径
     */
    public String getPath() {
        return getRequest().getRequestURL().toString();
    }

    /**
     * http://127.0.0.1/springmvcdemointellij/
     * @return 项目请求路径
     */
    public String getProjectPath() {
        return getPath().replace(getRequest().getServletPath(), "") + "/";
    }

    /**
     * 获取session数据
     * @param key 要获取对象的key值
     * @return session中key对应的value值
     */
    public Object getSessionAttribute(String key) {
        return getSession().getAttribute(key);
    }

    public static void main(String[] args) {
        JSONArray jsonArray = new JSONArray();
        String s = "[从业人员工资总额;1-本季][杭州]";
        jsonArray.add(s);
        System.out.println(jsonArray);
    }
}