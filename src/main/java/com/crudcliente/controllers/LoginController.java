/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crudcliente.controllers;

import com.crudcliente.dao.LogginDao;
import com.crudcliente.models.Cliente;

/**
 *
 * @author jzuniga
 */
public class LoginController {
    public Cliente login(String email, String password) {
        LogginDao logginDao = new LogginDao();
        Cliente cliente = logginDao.findByEmail(email, password);
        return cliente;
    }
}
