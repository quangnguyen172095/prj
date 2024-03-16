/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 * DBConect: Quản lý kết nối đến CSDL và các method dùng chung cho các DAO
 */

public class DBConnect {
    public Connection conn=null;
    
    public DBConnect(String url,String username,String password){
        try {
            //goi driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn=DriverManager.getConnection(url,username,password);
            System.out.println("Connected");
         } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public DBConnect(){
       this("jdbc:sqlserver://DESKTOP-PHUSBFB\\SQLEXPRESS:1433;databaseName=se1605",
               "quangnguyen","minhquang2908");
    }
    
    public ResultSet getData(String sql){
        ResultSet rs=null;
        Statement state;
        try {
            state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs=state.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }   
}
