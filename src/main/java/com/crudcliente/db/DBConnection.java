/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crudcliente.db;

import java.sql.Connection;
import java.sql.DriverManager;
import static com.crudcliente.config.Database.*;
import java.sql.SQLException;

/**
 *
 * @author jzuniga
 */
public class DBConnection {
    private Connection conn;
    
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(DB_HOST + DB_NAME + QUERY_PARAMS, DB_USER, DB_PASSWORD);
        return this.conn;
    }
    
    public void close() throws SQLException {
        if(this.conn != null) {
            this.conn.close();
        }
    }
}
