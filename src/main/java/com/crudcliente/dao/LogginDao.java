/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crudcliente.dao;

import com.crudcliente.db.DBConnection;
import com.crudcliente.models.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jzuniga
 */
public class LogginDao {

    private Connection conn;
    private DBConnection dbConn;
    
    public LogginDao() {
        this.dbConn = new DBConnection();
        
    }
    
    
    
    public Cliente findByEmail(String email, String password) {
        Cliente cliente = null;
        String query = "SELECT * FROM clientes WHERE email = ? AND password = SHA1(?)";
        
        try {
            this.conn = this.dbConn.getConnection();
            PreparedStatement pstm = this.conn.prepareStatement(query);
            pstm.setString(1, email);
            pstm.setString(2, password);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApPaterno(rs.getString("ap_paterno"));
                cliente.setApMaterno(rs.getString("ap_materno"));
                cliente.setEmail(rs.getString("email"));
                cliente.setPassword(rs.getString("password"));
                cliente.setIsDeleted(rs.getBoolean("is_deleted"));
            }
            this.conn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LogginDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LogginDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }

}
