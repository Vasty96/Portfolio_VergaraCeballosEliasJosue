package com.myportfolio.ejvc.Repository;

import com.myportfolio.ejvc.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author VastyPC
 */

@Repository
public interface REducacion extends JpaRepository<Educacion, Integer>{
    public Optional<Educacion> findByNombreEdu(String nombreEdu);
    
    public boolean existsByNombreEdu(String nombreEdu);
}
