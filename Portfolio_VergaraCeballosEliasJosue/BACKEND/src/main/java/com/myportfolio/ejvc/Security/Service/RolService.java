package com.myportfolio.ejvc.Security.Service;

import com.myportfolio.ejvc.Security.Entity.Rol;
import com.myportfolio.ejvc.Security.Enums.RolNombre;
import com.myportfolio.ejvc.Security.Repository.IRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author VastyPC
 */
@Service
@Transactional
public class RolService {
    @Autowired
    IRolRepository irolRespository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return irolRespository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        irolRespository.save(rol);
    }
}
