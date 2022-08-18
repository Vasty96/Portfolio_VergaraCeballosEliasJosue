package com.myportfolio.ejvc.Security.Repository;

import com.myportfolio.ejvc.Security.Entity.Rol;
import com.myportfolio.ejvc.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author VastyPC
 */

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
