package com.myportfolio.ejvc.Repository;

import com.myportfolio.ejvc.Entity.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author VastyPC
 */
public interface RProyecto extends JpaRepository<Proyecto, Integer>{
    public Optional<Proyecto> findByNombrePro(String nombrePro);
    
    public boolean existsByNombrePro(String nombrePro);
}
