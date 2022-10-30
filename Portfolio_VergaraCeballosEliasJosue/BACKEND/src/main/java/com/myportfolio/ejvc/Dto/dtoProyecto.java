package com.myportfolio.ejvc.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author VastyPC
 */
public class dtoProyecto {
    
    @NotBlank
    private String nombrePro;    
    @NotBlank
    private String descripcionPro;
    @NotBlank
    private String imagenPro;

    public dtoProyecto() {
    }

    public dtoProyecto(String nombrePro, String descripcionPro, String imagenPro) {
        this.nombrePro = nombrePro;
        this.descripcionPro = descripcionPro;
        this.imagenPro = imagenPro;
    }

    public String getNombrePro() {
        return nombrePro;
    }

    public void setNombrePro(String nombrePro) {
        this.nombrePro = nombrePro;
    }

    public String getDescripcionPro() {
        return descripcionPro;
    }

    public void setDescripcionPro(String descripcionPro) {
        this.descripcionPro = descripcionPro;
    }

    public String getImagenPro() {
        return imagenPro;
    }

    public void setImagenPro(String imagenPro) {
        this.imagenPro = imagenPro;
    }
    
}
