package com.bjpn.util;

import java.sql.*;

public class DBUtil {
    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConn(){
        try {
            String url = "jdbc:mysql://localhost:3306/sh2203?serverTimezone=UTC";
            Connection conn = DriverManager.getConnection(url,"root","root");
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //把关闭拆分成3个方法
    public static void closeConn(Connection conn){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void closePsta(PreparedStatement psta){
        if(psta!=null){
            try {
                psta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void closeResultSet(ResultSet resultSet){
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
