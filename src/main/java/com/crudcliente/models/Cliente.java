/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crudcliente.models;

/**
 *
 * @author jzuniga
 */
public class Cliente {
    private int Id;
    private String nombre;
    private String ApPaterno;
    private String ApMaterno;
    private String email;
    private String password;
    private boolean isDeleted;

    public Cliente() {
    }

    public Cliente(int Id, String nombre, String ApPaterno, String ApMaterno, String email, String password, boolean isDeleted) {
        this.Id = Id;
        this.nombre = nombre;
        this.ApPaterno = ApPaterno;
        this.ApMaterno = ApMaterno;
        this.email = email;
        this.password = password;
        this.isDeleted = isDeleted;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return ApPaterno;
    }

    public void setApPaterno(String ApPaterno) {
        this.ApPaterno = ApPaterno;
    }

    public String getApMaterno() {
        return ApMaterno;
    }

    public void setApMaterno(String ApMaterno) {
        this.ApMaterno = ApMaterno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
    
    
}
