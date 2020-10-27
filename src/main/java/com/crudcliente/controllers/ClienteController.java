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
}
