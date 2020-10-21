/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crudcliente.dao;

import com.crudcliente.db.DBConnection;
import com.crudcliente.models.Cliente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jzuniga
 */
public class LogginDao {
    
    public Cliente findByEmail(String email, String password) {
        Cliente cliente = null;
        String query = "SELECT * FROM clientes WHERE email = '" + email + "' AND password = '" + password + "'";
        DBConnection dbConn = new DBConnection();
        try {
            Connection conn = dbConn.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LogginDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LogginDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }
}
