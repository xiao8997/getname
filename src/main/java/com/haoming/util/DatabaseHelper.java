package com.haoming.util;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
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
   }

   public static Connection getConnection(){
       Connection conn=null;
       try {
           conn= DriverManager.getConnection(URL,USERNAME,PASSWORD);
       } catch (SQLException e) {
           LOGGER.error("can not get connection",e);
       }
       return conn;
   }

   public static void closeConnection(Connection conn){
       if(conn != null){
           try {
               conn.close();
           } catch (SQLException e) {
               LOGGER.error("close connection failure",e);
           }
       }
   }

    public static <T>List<T> queryEntityList(Class<T> entityClass,Connection conn,String sql,Object...params){
        List<T> entityList;
        try {
            entityList=QUERY_RUNNER.query(conn,sql,new BeanListHandler<T>(entityClass),params);
        } catch (SQLException e) {
            LOGGER.error("get EntityList failure",e);
            throw new RuntimeException(e);
        }finally {
            closeConnection(conn);
        }
        return entityList;
    }
}