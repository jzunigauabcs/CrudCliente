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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jzuniga
 */
public class ClienteDao {

    private Connection conn;
    private DBConnection dbConn;
    
    public ClienteDao() {
        this.dbConn = new DBConnection();
        
    }
           
    public ArrayList<Cliente> getAll() {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        String query = "SELECT * FROM clientes";
        try {
            this.conn = this.dbConn.getConnection();
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApPaterno(rs.getString("ap_paterno"));
                cliente.setApMaterno(rs.getString("ap_materno"));
                cliente.setEmail(rs.getString("email"));
                cliente.setPassword(rs.getString("password"));
                cliente.setIsDeleted(rs.getBoolean("is_deleted"));
                clientes.add(cliente);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LogginDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LogginDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }
}
