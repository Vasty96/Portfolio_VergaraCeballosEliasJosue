package com.myportfolio.ejvc.Service;

import com.myportfolio.ejvc.Entity.Persona;
import com.myportfolio.ejvc.Repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author VastyPC
 */

@Service
@Transactional
public class ImpPersonaService{
    
    @Autowired 
    IPersonaRepository iPersonaRespository;    
    
    public List<Persona> list(){
        return iPersonaRespository.findAll();
    }
    
    public Optional<Persona> getOne(int id){
        return iPersonaRespository.findById(id);
    }
    
    public Optional<Persona> getByNombre(String nombre){
        return iPersonaRespository.findByNombre(nombre);
    }
    
    public void save(Persona persona){
        iPersonaRespository.save(persona);
    }
    
    public void delete(int id){
        iPersonaRespository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iPersonaRespository.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return iPersonaRespository.existsByNombre(nombre);
    }
}