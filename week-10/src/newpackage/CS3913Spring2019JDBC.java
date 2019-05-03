/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs3913spring2019jdbc;

import java.sql.*;
import java.io.*;
/**
 *
 * @author dkatz
 */
public class CS3913Spring2019JDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection conn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://127.0.0.1/cs3913";
            String dbuser = "cs3913";
            String password = "abc123";
            conn = DriverManager.getConnection(url,dbuser,password);
            Statement s = conn.createStatement();
            s.executeQuery("select id thingie,name,bday from test;");
            ResultSet rs = s.getResultSet();
            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString("name");
                Date bday = rs.getDate("bday");
                System.out.println(id+" "+name+" "+bday.toString());
            }
            rs.close();
            s.close();
            conn.close();
        }
        catch(Exception e){
            System.out.println("Error: comething happened: "+e.toString());
        }
    }
    
}
