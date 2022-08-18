package com.myportfolio.ejvc.Service;

import com.myportfolio.ejvc.Entity.Persona;
import com.myportfolio.ejvc.Interface.IPersonaService;
import com.myportfolio.ejvc.Repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author VastyPC
 */

@Service
public class ImpPersonaService implements IPersonaService{
    
    @Autowired IPersonaRepository iPersonaRespository;
    
    @Override
    public List<Persona> getPersona() {
        List<Persona> personas = iPersonaRespository.findAll();
        return personas;
    }

    @Override
    public void savePersona(Persona persona) {
        iPersonaRespository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        iPersonaRespository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = iPersonaRespository.findById(id).orElse(null);
        return persona;
    }
    
}
