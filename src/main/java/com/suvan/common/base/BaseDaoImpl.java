package com.suvan.common.base;

import com.suvan.common.entity.PageInfo;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author suvan
 * @create 2016-12-28-15:47
 */
@Repository
public class BaseDaoImpl extends NamedParameterJdbcDaoSupport implements BaseDao<T> {

    private final static String PAGE_SQL_PREFIX = "select * from(select m.*,rownum num from (";
    private final static String PAGE_SQL_END = ") m where rownum<=%1$s) where num>%2$s";

    @Override
    public JdbcTemplate getJdbc() {
        return this.getJdbcTemplate();
    }

    @Override
    public int updateByBean(String namedSql, Object javaBean) {
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(javaBean);
        return this.getNamedParameterJdbcTemplate().update(namedSql,paramSource);
    }

    @Override
    public String updateByBeanForkey(String namedSql, Object javaBean,String keyName) {
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(javaBean);

        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.getNamedParameterJdbcTemplate().update(namedSql,paramSource,keyHolder,new String[]{keyName});
        return keyHolder.getKey().toString();
    }

    @Override
    public Map<String, Object> updateByBeanForkeys(String namedSql, Object javaBean,String[] keyNames) {
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(javaBean);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.getNamedParameterJdbcTemplate().update(namedSql,paramSource,keyHolder,keyNames);
        return keyHolder.getKeys();
    }

    @Override
    public int updateByMap(String namedSql, Map<String, Object> mapParams) {
        return this.getNamedParameterJdbcTemplate().update(namedSql,mapParams);
    }

    @Override
    public String updateByMapForkey(String namedSql, Map<String, Object> mapParams,String keyName){
        SqlParameterSource ps=new MapSqlParameterSource(mapParams);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.getNamedParameterJdbcTemplate().update(namedSql,ps,keyHolder,new String[]{keyName});
        return  keyHolder.getKey().toString();
    }

    @Override
    public Map<String, Object> updateByMapForkeys(String namedSql, Map<String, Object> mapParams,String[] keyNames){
        SqlParameterSource ps=new MapSqlParameterSource(mapParams);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.getNamedParameterJdbcTemplate().update(namedSql,ps,keyHolder,keyNames);
        return  keyHolder.getKeys();
    }

    @Override
    public int commonUpdate(String sql, Object... paramValue) {
        return this.getJdbcTemplate().update(sql, paramValue);
    }

    @Override
    public T getJavaBean(String sql, Class<T> returnType, Object... paramValue) {
        RowMapper<T> rowMapper = new BeanPropertyRowMapper<>(returnType);
        try{
            return this.getJdbcTemplate().queryForObject(sql, rowMapper, paramValue);
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public T getBeanByBean(String sql, Class<T> returnType, Object javaBean) {
        RowMapper<T> rowMapper = new BeanPropertyRowMapper<>(returnType);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(javaBean);
        try{
            return this.getNamedParameterJdbcTemplate().queryForObject(sql, paramSource, rowMapper);
        }catch(Exception ex){
            return null;
        }
    }

    @Override
    public T getBeanByMap(String sql, Class<T> returnType, Map<String, Object> mapParams) {
        RowMapper<T> rowMapper = new BeanPropertyRowMapper<>(returnType);
        try{
            return this.getNamedParameterJdbcTemplate().queryForObject(sql, mapParams, rowMapper);
        }catch(Exception ex){
            return null;
        }
    }

    @Override
    public List<T> getList(String sql, Class<T> returnType, Object... paramValue) {
        RowMapper<T> rowMapper = new BeanPropertyRowMapper<>(returnType);
        return this.getJdbcTemplate().query(sql, rowMapper, paramValue);
    }

    @Override
    public List<T> getList(String sql, Class<T> returnType) {
        RowMapper<T> rowMapper = new BeanPropertyRowMapper<>(returnType);
        return this.getJdbcTemplate().query(sql, rowMapper);
    }
    @Override
    public List<Map<String, Object>> getListMap(String sql,Object...paramValue) {
        return this.getJdbcTemplate().queryForList(sql, paramValue);
    }

    @Override
    public long getCount(String countSQL, Object... paramValue) {
        return this.getJdbcTemplate().queryForObject(countSQL, Long.class, paramValue);
    }


    @Override
    public PageInfo<T> getPageModel(PageInfo<T> model, StringBuffer querySQL, StringBuffer countSQL, Class<T> returnType, Object... paramValue) {

        // 1、计算总记录数
        long allCount = this.getCount(countSQL.toString(), paramValue);
        // 2、获取分页记录集
        // 2.1、构造完整的分页语句
        int rowNumEnd=model.getCurrentPage()* model.getPageSize();
        int rowNumBegin=(model.getCurrentPage()-1)* model.getPageSize();
        querySQL.insert(0, PAGE_SQL_PREFIX);
        querySQL.append(String.format(PAGE_SQL_END, rowNumEnd,rowNumBegin));

        // 2.2、连数据库查询
        List<T> result = this.getList(querySQL.toString(), returnType, paramValue);

        // 3、重置分页数据
        model.setTotalRecord(allCount);
        model.setTotalPage();
        model.setPageInfoResult(result);

        return model;
    }

    @Override
    public PageInfo<Map<String, Object>> getPageModel(PageInfo<Map<String, Object>> model, StringBuffer querySQL,StringBuffer countSQL, Object... paramValue) {
        // 1、计算总记录数
        long allCount = this.getCount(countSQL.toString(), paramValue);
        // 2、获取分页记录集
        // 2.1、构造完整的分页语句
        int rowNumEnd=model.getCurrentPage()* model.getPageSize();
        int rowNumBegin=(model.getCurrentPage()-1)* model.getPageSize();
        querySQL.insert(0, PAGE_SQL_PREFIX);
        querySQL.append(String.format(PAGE_SQL_END, rowNumEnd,rowNumBegin));

        // 2.2、连数据库查询
        List<Map<String, Object>> result = this.getListMap(querySQL.toString(), paramValue);

        // 3、重置分页数据
        model.setTotalRecord(allCount);
        model.setTotalPage();
        model.setPageInfoResult(result);
        return model;
    }
}