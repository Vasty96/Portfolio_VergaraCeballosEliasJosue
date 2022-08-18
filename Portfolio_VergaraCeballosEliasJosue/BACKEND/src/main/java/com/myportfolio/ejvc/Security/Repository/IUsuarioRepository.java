package com.myportfolio.ejvc.Security.Repository;

import com.myportfolio.ejvc.Security.Entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author VastyPC
 */
@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    
    boolean existByNombreUsuario(String nombreUsuario);
    boolean existByEmail(String email);
}
