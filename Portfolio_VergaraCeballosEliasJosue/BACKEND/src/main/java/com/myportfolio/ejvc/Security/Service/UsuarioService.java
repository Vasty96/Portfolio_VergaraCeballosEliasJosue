package com.myportfolio.ejvc.Security.Service;

import com.myportfolio.ejvc.Security.Entity.Usuario;
import com.myportfolio.ejvc.Security.Repository.IUsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author VastyPC
 */
@Service
@Transactional
public class UsuarioService {
    @Autowired
    IUsuarioRepository iusuarioRepository;
    
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return iusuarioRepository.findByNombreUsuario(nombreUsuario);
    }
    
    public boolean existByNombreUsuario(String nombreUsuario){
        return iusuarioRepository.existByNombreUsuario(nombreUsuario);
    }
    
    public boolean existByEmail(String email){
        return iusuarioRepository.existByEmail(email);
    }
    
    public void save(Usuario usuario){
        iusuarioRepository.save(usuario);
    }
}
