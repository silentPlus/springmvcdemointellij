package com.suvan.common.entity;

import com.alibaba.fastjson.JSONObject;
import com.suvan.common.constants.ConfigConstants;

/**
 * Ajax处理结果返回JSON对象
 * @author suvan
 * @create 2016-12-28-16:54
 */
public class AjaxResult extends JSONObject {
    private static final long serialVersionUID = -38615894266925900L;

    public AjaxResult(){
        this.put(ConfigConstants.AJAX_RESULT_STATUS, ConfigConstants.AJAX_RESULT_STATUS_1);
    }

    public AjaxResult(int status, String message) {
        this.put(ConfigConstants.AJAX_RESULT_STATUS, status);
        this.put(ConfigConstants.AJAX_RESULT_MESSAGE, message);
    }

    public AjaxResult(int status, String message,Object entity) {
        this.put(ConfigConstants.AJAX_RESULT_STATUS, status);
        this.put(ConfigConstants.AJAX_RESULT_MESSAGE, message);
        this.put(ConfigConstants.AJAX_RESULT_ENTITY, entity);
    }

    public int getStatus() {
        return this.getInteger(ConfigConstants.AJAX_RESULT_STATUS).intValue();
    }

    public void setStatus(int status) {
        this.put(ConfigConstants.AJAX_RESULT_STATUS, status);
    }

    public String getMessage() {
        return this.getString(ConfigConstants.AJAX_RESULT_MESSAGE);
    }

    public void setMessage(String message) {
        this.put(ConfigConstants.AJAX_RESULT_MESSAGE, message);
    }

    public Object getEntity() {
        return this.get(ConfigConstants.AJAX_RESULT_ENTITY);
    }

    public void setEntity(Object entity) {
        this.put(ConfigConstants.AJAX_RESULT_ENTITY, entity);
    }

}
