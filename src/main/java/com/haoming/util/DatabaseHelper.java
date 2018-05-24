package com.haoming.util;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by xiaot on 2018/5/18.
 */
public final class DatabaseHelper {

    private static final Logger LOGGER= LoggerFactory.getLogger(DatabaseHelper.class);
    private static final String DRIVER;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;
    private static final QueryRunner QUERY_RUNNER = new QueryRunner();
    private static final ThreadLocal<Connection> CONNECTION_HOLDER = new ThreadLocal<Connection>();
    private static final BasicDataSource DATA_SOURCE;

   static {
       Properties props = PropsUtil.loadProps("config.properties");
       DRIVER=props.getProperty("jdbc.driver");
       URL=props.getProperty("jdbc.url");
       USERNAME=props.getProperty("jdbc.username");
       PASSWORD=props.getProperty("jdbc.password");

       try {
           Class.forName(DRIVER);
       } catch (ClassNotFoundException e) {
           LOGGER.error("can not load get jdbc driver",e);
       }

       DATA_SOURCE=new BasicDataSource();
       DATA_SOURCE.setDriverClassName(DRIVER);
       DATA_SOURCE.setUrl(URL);
       DATA_SOURCE.setUsername(USERNAME);
       DATA_SOURCE.setPassword(PASSWORD);
   }

   public static Connection getConnection(){
       Connection conn=CONNECTION_HOLDER.get();
       if(conn == null) {
           try {
               conn = DATA_SOURCE.getConnection();
           } catch (SQLException e) {
               LOGGER.error("can not get connection", e);
           }finally {
               CONNECTION_HOLDER.set(conn);
           }
       }
       return conn;
   }

    public static <T>List<T> queryEntityList(Class<T> entityClass,String sql,Object...params){
        List<T> entityList;
        try {
            Connection conn=getConnection();
            entityList=QUERY_RUNNER.query(conn,sql,new BeanListHandler<T>(entityClass),params);
        } catch (SQLException e) {
            LOGGER.error("get EntityList failure",e);
            throw new RuntimeException(e);
        }
        return entityList;
    }

    public static <T>T queryEntity(Class<T> entityClass,String sql,Object...params){
        T entity;
        try {
            Connection conn=getConnection();
            entity=QUERY_RUNNER.query(conn,sql,new BeanHandler<T>(entityClass),params);
        } catch (SQLException e) {
            LOGGER.error("get Entity failure",e);
            throw new RuntimeException(e);
        }
        return entity;
    }

    public static List<Map<String,Object>> queryMap(String sql, Object...params){
        List<Map<String,Object>> list;
        try {
            Connection conn=getConnection();
            list=QUERY_RUNNER.query(conn,sql,new MapListHandler(),params);
        } catch (SQLException e) {
            LOGGER.error("get Map failure",e);
            throw new RuntimeException(e);
        }
        return list;
    }
}
