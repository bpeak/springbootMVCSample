package com.bpeak.Dao;

import java.sql.*;

public class DB {
    public static int a = 3;
    public static Connection connect(){
        Connection conn = null;
        try{
            //load driver
            System.out.println("load dirver");
            Class.forName("com.mysql.jdbc.Driver");

            //connect
            System.out.println("connect");
            String url = "jdbc:mysql://localhost:3306/jarvis?autoReconnect=true&useSSL=false";
            conn = DriverManager.getConnection(url, "root", "k0194757k!");
        } catch (Exception e){

        }
        return conn;
    }
}
