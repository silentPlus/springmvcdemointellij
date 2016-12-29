package com.suvan.common.constants;

/**
 * @author suvan
 * @create 2016-12-28-10:27
 */
public class ConfigConstants {
    /*普通错误页名称*/
    public static final String COMMON_ERROR_PAGE = "error";
    /*错误页提示信息名称*/
    public static final String ERROR_MSG = "ERROR_MSG";
    /*ajax返回状态名称*/
    public static final String AJAX_RESULT_STATUS = "status";
    /*ajax返回状态：出错*/
    public static final int AJAX_RESULT_STATUS_0 = 0;
    /*ajax返回状态：成功*/
    public static final int AJAX_RESULT_STATUS_1 = 1;
    /*ajax返回状态：其他*/
    public static final int AJAX_RESULT_STATUS_2 = 2;
    /*ajax返回提示信息名称*/
    public static final String AJAX_RESULT_MESSAGE = "  message";
    /*ajax返回实体对象*/
    public static final String AJAX_RESULT_ENTITY = "entity";

    public static String STATIC_VALUE;

    public void setSTATIC_VALUE(String STATIC_VALUE) {
        STATIC_VALUE = STATIC_VALUE;
    }

}
