/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.DB;

import java.sql.*;

public class ConnectionFactory {
    public static Connection getConnection(){
        String[] all = ManejadorArchivosGenerico.leerArchivo("./src/configuration.txt", true);
        String DBURL = all[0] + all[1] + ":" + all[2] + "/" + all[3];
        try {
            return DriverManager.getConnection(DBURL, all[4], all[5]);
        } catch(SQLException sqle) {
            throw new RuntimeException("Error conectando a la base de datos", sqle);
        }
    }
    
    public static void closeConnection(Connection con) {
        try {
            con.close();
        } catch (SQLException sqle) {}
    }
}
