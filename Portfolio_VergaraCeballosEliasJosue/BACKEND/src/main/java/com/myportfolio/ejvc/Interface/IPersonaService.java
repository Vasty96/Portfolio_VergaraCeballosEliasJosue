package com.myportfolio.ejvc.Interface;

import com.myportfolio.ejvc.Entity.Persona;
import java.util.List;

/**
 * @author VastyPC
 */

public interface IPersonaService {
    public List<Persona> getPersona();
    
    public void savePersona(Persona persona);
    
    public void deletePersona(Long id);
    
    public Persona findPersona(Long id);
}
