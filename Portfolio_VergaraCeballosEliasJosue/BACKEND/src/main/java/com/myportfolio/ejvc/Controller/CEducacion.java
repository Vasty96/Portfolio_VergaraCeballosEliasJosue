package com.myportfolio.ejvc.Controller;

import com.myportfolio.ejvc.Dto.dtoEducacion;
import com.myportfolio.ejvc.Entity.Educacion;
import com.myportfolio.ejvc.Security.Controller.Mensaje;
import com.myportfolio.ejvc.Service.SEducacion;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author VastyPC
 */

@RestController
@RequestMapping("/educacion")
/*@CrossOrigin(origins = "https://ejvcfrontend.web.app")*/
@CrossOrigin(origins = {"https://ejvcfrontend.web.app", "http://localhost:4200"})
public class CEducacion {
    @Autowired
    SEducacion sEducacion;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = sEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoEdu){
        if(StringUtils.isBlank(dtoEdu.getNombreEdu()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
            
        if(sEducacion.existsByNombreEdu(dtoEdu.getNombreEdu()))
            return new ResponseEntity(new Mensaje("Esa educacion esa existe"), HttpStatus.BAD_REQUEST);
        
        Educacion educacion = new Educacion(dtoEdu.getNombreEdu(), dtoEdu.getDescripcionEdu());
        sEducacion.save(educacion);
        
        return new ResponseEntity(new Mensaje("Educacion agregada"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!sEducacion.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.BAD_REQUEST);
        Educacion educacion = sEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoEdu){
        if(!sEducacion.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        
        if(sEducacion.existsByNombreEdu(dtoEdu.getNombreEdu()) &&
                sEducacion.getByNombreEdu(dtoEdu.getNombreEdu()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa esperiencia ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoEdu.getNombreEdu()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Educacion educacion = sEducacion.getOne(id).get();
        educacion.setNombreEdu(dtoEdu.getNombreEdu());
        educacion.setDescripcionEdu(dtoEdu.getDescripcionEdu());
        
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sEducacion.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        sEducacion.delete(id);
        
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
}
