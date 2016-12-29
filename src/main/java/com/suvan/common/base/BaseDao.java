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
    JdbcTemplate getJdbc();

    /**
     * @param nameSql 以:name方式命名参数的sql语句
     * @param javaBean 参数对象
     * @return 受影响行数
     */
    int updateByBean(String nameSql, Object javaBean);

    /**
     * @param nameSql 以:name方式命名参数的sql语句
     * @param javaBean 参数对象
     * @param keyName 主键名
     * @return 主键值
     */
    String updateByBeanForkey(String nameSql, Object javaBean, String keyName);

    /**
     * @param nameSql 以:name方式命名参数的sql语句
     * @param javaBean 参数对象
     * @param keyNames 需要返回的值的名称数组
     * @return 返回值集合
     */
    Map<String, Object> updateByBeanForkeys(String nameSql, Object javaBean, String[] keyNames);

    /**
     * @param sql 以:name方式命名参数的sql语句
     * @param mapParams 参数集合
     * @return 受影响的行数
     */
    int updateByMap(String sql, Map<String, Object> mapParams);

    /**
     * @param sql 以:name方式命名参数的sql语句
     * @param mapParams 参数集合
     * @param keyName 返回值的名称
     * @return 返回值
     */
    String updateByMapForkey(String sql, Map<String, Object> mapParams, String keyName);

    /**
     * @param sql 以:name方式命名参数的sql语句
     * @param mapParams 参数集合
     * @param keyNames 需要返回的值的名称数组
     * @return 返回值集合
     */
    Map<String, Object> updateByMapForkeys(String sql, Map<String, Object> mapParams, String[] keyNames);

    /**
     * @param sql 普通?方式传参的sql语句
     * @param paramValue 参数，按顺序传递
     * @return 受影响行数
     */
    int commonUpdate(String sql, Object... paramValue);

    /**
     * @param sql 普通?方式传参的sql语句
     * @param returnType 返回值类型
     * @param paramValue 参数，按顺序传递
     * @return 返回对象
     */
    T getJavaBean(String sql, Class<T> returnType, Object... paramValue);

    /**
     * @param sql 以:name方式命名参数的sql语句
     * @param returnType 返回值类型
     * @param javaBean 参数对象
     * @return 返回对象
     */
    T getBeanByBean(String sql, Class<T> returnType, Object javaBean);

    /**
     * @param sql 以:name方式命名参数的sql语句
     * @param returnType 返回值类型
     * @param mapParams 参数集合
     * @return 返回对象
     */
    T getBeanByMap(String sql, Class<T> returnType, Map<String, Object> mapParams);

    /**
     * @param sql 普通?方式传参的sql语句
     * @param returnType 返回值类型
     * @param paramValue 参数，按顺序传递
     * @return 返回对象的List集合
     */
    List<T> getList(String sql, Class<T> returnType, Object... paramValue);

    /**
     * @param sql 无参数的sql语句
     * @param returnType 返回值类型
     * @return 返回对象的List集合
     */
    List<T> getList(String sql, Class<T> returnType);

    /**
     * @param sql 普通?方式传参的sql语句
     * @param paramValue 参数，按顺序传递
     * @return 返回结果集Map的List集合
     */
    List<Map<String, Object>> getListMap(String sql, Object... paramValue);

    /**
     * @param countSQL ?方式传参的sql语句
     * @param paramValue 参数，按顺序传递
     * @return 总记录数
     */
    long getCount(String countSQL, Object... paramValue);

    /**
     * @param model 分页对象
     * @param querySQL 查询sql
     * @param countSQL 查询总记录数sql
     * @param returnType 返回值类型
     * @param paramValue 参数，按顺序传递
     * @return 分页对象
     */
    PageInfo<T> getPageModel(PageInfo<T> model, StringBuffer querySQL, StringBuffer countSQL, Class<T> returnType, Object... paramValue);

    /**
     * @param model Map集合的分页对象
     * @param querySQL 查询sql
     * @param countSQL 查询总记录数sql
     * @param paramValue 参数，按顺序传递
     * @return Map集合的分页对象
     */
    PageInfo<Map<String, Object>> getPageModel(PageInfo<Map<String, Object>> model, StringBuffer querySQL, StringBuffer countSQL, Object... paramValue);
}