package com.myportfolio.ejvc.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * @author VastyPC
 */
@Getter
@Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con el largo requerido")
    private String nombre;
    
    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con el largo requerido")
    private String apellido;
    @Size(min = 1, max = 50, message = "No cumple con el largo requerido")
    private String img;

    
}
