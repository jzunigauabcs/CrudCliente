/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crudcliente.view;

import com.crudcliente.controllers.LoginController;
import com.crudcliente.models.Cliente;
import java.util.Scanner;

/**
 *
 * @author jzuniga
 */
public class LoginView { 

    
    public static void showLogin(){
        String email;
        String password;
        Scanner io = new Scanner(System.in);
        
        System.out.println("Email: ");
        email = io.nextLine();
        System.out.println("Password: ");
        password = io.nextLine();
        
        LoginController loginCtrl = new LoginController();
        Cliente cliente = loginCtrl.login(email, password);
        
        if(cliente != null) {
            System.out.println("Bienvenido " + cliente.getNombre() + " " + cliente.getApPaterno());
            ClienteView.showMenu();
        } else {
            System.out.println("Usuario o contraseña incorrectos");
        }
    }
    
}
