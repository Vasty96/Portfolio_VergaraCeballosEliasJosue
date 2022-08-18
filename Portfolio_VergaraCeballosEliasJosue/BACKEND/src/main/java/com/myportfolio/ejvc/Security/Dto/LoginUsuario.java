package com.myportfolio.ejvc.Security.Dto;

import javax.validation.constraints.NotBlank;

/**
 * @author VastyPC
 */

public class LoginUsuario {
    @NotBlank
    private String nombreUsuario;
    @NotBlank
    private String Password;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    
}
