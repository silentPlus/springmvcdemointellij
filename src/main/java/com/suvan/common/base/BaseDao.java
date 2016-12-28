package com.suvan.common.base;

import com.suvan.common.entity.PageInfo;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author suvan
 * @create 2016-12-28-15:23
 */
public interface BaseDao<T> {

    /**
     * 获取当前使用的jdbc
     * @return JdbcTemplate
     */
    public JdbcTemplate getJdbc();

    /**
     * 方式javaBean传参 ,修改操作
     * @param nameSql
     * @param javaBean
     * @return int
     */
    public int updateByBean(String nameSql, Object javaBean);

    /**
     * 方式javaBean传参 ,修改操作 ,并且回传主键值
     * @param nameSql
     * @param javaBean
     * @param keyName
     * @return String
     */
    public String updateByBeanForkey(String nameSql, Object javaBean,String keyName);

    /**
     * 方式javaBean传参 ,修改操作 ,并且回传多主键值
     * @param nameSql
     * @param javaBean
     * @param keyNames
     * @return Map<String, Object>
     */
    public Map<String, Object> updateByBeanForkeys(String nameSql, Object javaBean, String[] keyNames);

    /**
     * 方式Map传参 ,修改操作
     * @param sql
     * @param mapParams
     * @return int
     */
    public int updateByMap(String sql, Map<String, Object> mapParams);

    /**
     * 方式Map传参 ,修改操作 ,并且回传主键值
     * @param sql
     * @param mapParams
     * @param keyName
     * @return String
     */
    public String updateByMapForkey(String sql, Map<String, Object> mapParams,String keyName);

    /**
     * 方式Map传参 ,修改操作 ,并且回传多主键值
     * @param sql
     * @param mapParams
     * @param keyNames
     * @return Map<String, Object>
     */
    public Map<String, Object> updateByMapForkeys(String sql, Map<String, Object> mapParams,String[] keyNames);

    /**
     * ?方式传参 ,修改操作
     * @param sql
     * @param paramValue
     * @return int
     */
    public int commonUpdate(String sql, Object... paramValue);

    /**
     * ?方式传参 ,根据泛型获取数据
     * @param sql
     * @param returnType
     * @param paramValue
     * @return T
     */
    public T getJavaBean(String sql, Class<T> returnType, Object... paramValue);

    /**
     * 方式javaBean传参 ,根据泛型获取数据
     * @param sql
     * @param returnType
     * @param javaBean
     * @return T
     */
    public T getBeanByBean(String sql, Class<T> returnType, Object javaBean);

    /**
     * 方式Map传参 ,根据泛型获取数据
     * @param sql
     * @param returnType
     * @param mapParams
     * @return T
     */
    public T getBeanByMap(String sql, Class<T> returnType, Map<String, Object> mapParams);

    /**
     * ?方式Object传参 ,根据泛型获取数据列表
     * @param sql
     * @param returnType
     * @param paramValue
     * @return List<T>
     */
    public List<T> getList(String sql, Class<T> returnType, Object... paramValue);

    /**
     * 无传参 ,根据泛型获取数据列表
     * @param sql
     * @param returnType
     * @return List</T>
     */
    public List<T> getList(String sql, Class<T> returnType);

    /**
     * ?方式Object传参 ,获取数据列表
     * @param sql
     * @param paramValue
     * @return List<Map<String, Object>>
     */
    public List<Map<String, Object>> getListMap(String sql,Object...paramValue);

    /**
     * ?方式Object传参 ,计算总记录数
     * @param countSQL
     * @param paramValue
     * @return long
     */
    public long getCount(String countSQL, Object... paramValue);

    /**
     * ?方式Object传参 ,javaBean分页
     * @param model
     * @param querySQL
     * @param countSQL
     * @param returnType
     * @param paramValue
     * @return PageInfo<T>
     */
    public PageInfo<T> getPageModel(PageInfo<T> model, StringBuffer querySQL, StringBuffer countSQL, Class<T> returnType , Object... paramValue);

    /**
     * ?方式Object传参 ,Map专用分页
     * @param model
     * @param querySQL
     * @param countSQL
     * @param paramValue
     * @return PageInfo<Map<String, Object>>
     */
    public PageInfo<Map<String, Object>> getPageModel(PageInfo<Map<String, Object>> model, StringBuffer querySQL,StringBuffer countSQL, Object... paramValue);
}