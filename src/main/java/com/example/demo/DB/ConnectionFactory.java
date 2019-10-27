/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.DB;

import java.sql.*;

public class ConnectionFactory {
    private final static String DBDRIVER = "jdbc:postgresql://";
    private final static String DBHOST = "ec2-107-21-126-201.compute-1.amazonaws.com";
    private final static String DBPORT = "5432";
    private final static String DBNAME = "d2tes8ukbdj1u4";
    private final static String DBUSER = "byvblkdrkfblrj";
    private final static String DBPASS = "8dfa6f47a45a64c140a82d5aa2dcfb3705f08c1bc4a6b520d31cdb31cde992ee";
    
    public static Connection getConnection(){
        String DBURL = DBDRIVER + DBHOST + ":" + DBPORT + "/" + DBNAME;
        try {
            return DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        } catch(SQLException sqle) {
            throw new RuntimeException("Error conectando a la base de datos", sqle);
        }
    }
    
    public static void closeConnection(Connection con) {
        try {
            con.close();
        } catch (SQLException sqle) {}
    }
    
    public static String getDBHOST() {
        return DBHOST;
    }
}
