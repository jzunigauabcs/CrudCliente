/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crudcliente.view;

import com.crudcliente.controllers.ClienteController;
import com.crudcliente.models.Cliente;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jzuniga
 */
public class ClienteView {
    
    public static void showMenu() {
        
        Scanner io = new Scanner(System.in);
        int opcion;
        
        do{
            System.out.println("1.- Mostrar listado de clientes");
            System.out.println("2.- Crear nuevo cliente");
            System.out.println("3.- Cambiar password");
            System.out.println("4.- Salir");
            System.out.println("Seleccione una opción: ");
            opcion = io.nextInt();
            if(opcion < 1 || opcion > 4) {
                System.out.println("Opción incorrecta, favor de volver a intentar");
                continue;
            }
            
            switch(opcion) {
                case 1:
                    showClientes();
                    break;
                case 2:
                    createCliente();
                    break;
                case 3:
                    break;
            }
                
        }while(opcion != 4);
        
    }
    
    private static void showClientes() {
        System.out.println("******Listado de clientes*****");
        ClienteController clienteC = new ClienteController();
        
       ArrayList<Cliente> clientes = clienteC.getAll();
        for (Cliente cliente : clientes) {
            System.out.println("Nombre completo: " + cliente.getNombre()+ " " + cliente.getApPaterno()+ " " + cliente.getApMaterno());
        }
    }
    
    private static void createCliente() {
        Scanner io = new Scanner(System.in);
        String nombre;
        String apPaterno;
        String apMaterno;
        String email;
        String password;
        
        System.out.println("Nombre del cliente: ");
        nombre = io.next();
        System.out.println("Primer apellido: ");
        apPaterno = io.next();
        System.out.println("Segundo apellido: ");
        apMaterno = io.next();
        System.out.println("Email: ");
        email = io.next();
        System.out.println("Contraseña: ");
        password = io.next();
        
        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setApPaterno(apPaterno);
        cliente.setApMaterno(apMaterno);
        cliente.setEmail(email);
        cliente.setPassword(password);
        
        ClienteController clienteC = new ClienteController();
        int result = clienteC.store(cliente);
        if(result == 1) {
            System.out.println("Datos almacenados correctamente");
            
        } else {
            System.out.println("Ocurrió un error al intentar almacenar los datos");
        }
        
    }
            
}
