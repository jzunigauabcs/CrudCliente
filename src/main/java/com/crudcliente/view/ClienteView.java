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
            System.out.println("4.- Eliminar cliente");
            System.out.println("5.- Salir");
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
                    updatePassword();
                    break;
                case 4:
                    deleteCliente();
                    break;
            }
                
        }while(opcion != 5);
        
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
    
    private static void updatePassword() {
        Scanner io = new Scanner(System.in);
        String email;
        String password;
        System.out.println("Ingrese email del cliente: ");
        email = io.next();
        System.out.println("Ingrese nueva contraseña (debe ser mayor a 2 caracteres y no se permiten contraseñas que se utilizó con anterioridad): ");
        password = io.next();
        
        Cliente cliente = new Cliente();
        cliente.setEmail(email);
        cliente.setPassword(password);
        ClienteController clienteC = new ClienteController();
        int result = clienteC.updatePassword(cliente);
        if(result == 1) {
            System.out.println("Datos actualizados correctamente");
            
        } else {
            System.out.println("Ocurrió un error al intentar actualizar los datos");
        }
    }
    
    private static void deleteCliente() {
         Scanner io = new Scanner(System.in);
         String email;
        System.out.println("Ingrese email del cliente a eliminar: ");
        email = io.next();
        
        ClienteController clienteC = new ClienteController();
        int result = clienteC.delete(email);
        if(result == 1) {
            System.out.println("Datos eliminados correctamente");
            
        } else {
            System.out.println("Ocurrió un error al intentar eliminar los datos del cliente");
        } 
    }
            
}
