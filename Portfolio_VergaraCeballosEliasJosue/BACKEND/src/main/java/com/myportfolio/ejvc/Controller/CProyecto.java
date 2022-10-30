package com.myportfolio.ejvc.Controller;

import com.myportfolio.ejvc.Dto.dtoProyecto;
import com.myportfolio.ejvc.Entity.Proyecto;
import com.myportfolio.ejvc.Security.Controller.Mensaje;
import com.myportfolio.ejvc.Service.SProyecto;
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
@RequestMapping("/proyecto")
/*@CrossOrigin(origins = "https://ejvcfrontend.web.app")*/
@CrossOrigin(origins = {"https://ejvcfrontend.web.app", "http://localhost:4200"})
public class CProyecto {
    @Autowired
    SProyecto sProyecto;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list(){
        List<Proyecto> list = sProyecto.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyecto dtoPro){
        if(StringUtils.isBlank(dtoPro.getNombrePro()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
            
        if(StringUtils.isBlank(dtoPro.getDescripcionPro()))
            return new ResponseEntity(new Mensaje("La descripcion es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoPro.getImagenPro()))
            return new ResponseEntity(new Mensaje("La imagen es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Proyecto proyecto = new Proyecto(dtoPro.getNombrePro(), dtoPro.getDescripcionPro(), dtoPro.getImagenPro());
        sProyecto.save(proyecto);
        
        return new ResponseEntity(new Mensaje("Proyecto agregado"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id){
        if(!sProyecto.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.BAD_REQUEST);
        Proyecto proyecto = sProyecto.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyecto dtoPro){
        if(!sProyecto.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        
        if(sProyecto.existsByNombrePro(dtoPro.getNombrePro()) &&
                sProyecto.getByNombrePro(dtoPro.getNombrePro()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoPro.getNombrePro()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
            
        if(StringUtils.isBlank(dtoPro.getDescripcionPro()))
            return new ResponseEntity(new Mensaje("La descripcion es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Proyecto proyecto = sProyecto.getOne(id).get();
        proyecto.setNombrePro(dtoPro.getNombrePro());
        proyecto.setDescripcionPro(dtoPro.getDescripcionPro());
        proyecto.setImagenPro(dtoPro.getImagenPro());
        
        sProyecto.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sProyecto.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        sProyecto.delete(id);
        
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }
}
