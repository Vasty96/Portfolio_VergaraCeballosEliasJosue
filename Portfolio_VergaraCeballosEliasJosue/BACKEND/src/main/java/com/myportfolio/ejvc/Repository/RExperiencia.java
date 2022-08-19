package com.myportfolio.ejvc.Repository;

import com.myportfolio.ejvc.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author VastyPC
 */

@Repository
public interface RExperiencia extends JpaRepository<Experiencia, Integer>{
    public Optional<Experiencia> findByNombreE(String nombreE);
    
    public boolean existsByNombreE(String nombreE);
}
