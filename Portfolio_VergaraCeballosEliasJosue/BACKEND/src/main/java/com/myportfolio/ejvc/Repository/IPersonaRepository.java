package com.myportfolio.ejvc.Repository;

import com.myportfolio.ejvc.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author VastyPC
 */

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Long>{
    
}
