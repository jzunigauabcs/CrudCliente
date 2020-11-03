/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crudcliente.controllers;

import com.crudcliente.dao.ClienteDao;
import com.crudcliente.models.Cliente;
import java.util.ArrayList;

/**
 *
 * @author jzuniga
 */
public class ClienteController {
    
    public ArrayList<Cliente> getAll() {
        ClienteDao clienteDao = new ClienteDao();
        return clienteDao.getAll();
    }
    
    public int store(Cliente cliente) {
        ClienteDao clienteDao = new ClienteDao();
        return clienteDao.store(cliente);
    }
    
    public int updatePassword(Cliente cliente) {
        ClienteDao clienteDao = new ClienteDao();
        return clienteDao.updatePassword(cliente);
    }
    
    public int delete(String email) {
        ClienteDao clienteDao = new ClienteDao();
        return clienteDao.delete(email);
    }
}
