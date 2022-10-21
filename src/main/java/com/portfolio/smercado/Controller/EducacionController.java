package com.portfolio.smercado.Controller;

import com.portfolio.smercado.Dto.DtoEducacion;
import com.portfolio.smercado.Entity.Educacion;
import com.portfolio.smercado.Security.Controller.Mensaje;
import com.portfolio.smercado.Service.EducacionService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
 *
 * @author santi
 */
@RestController
@RequestMapping("/educacion")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://portfolio-santiagom.web.app")
public class EducacionController {

    @Autowired
    EducacionService eduService;

    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list() {
        List<Educacion> list = eduService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!eduService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        eduService.delete(id);
        return new ResponseEntity(new Mensaje("Educacion Eliminada"), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id) {
        if (!eduService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }

        Educacion educacion = eduService.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoEducacion dtoEducacion) {
        if (StringUtils.isBlank(dtoEducacion.getNombreE())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoEducacion.getDescripcionE())) {
            return new ResponseEntity(new Mensaje("La descripcion es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if (eduService.existsByNombreE(dtoEducacion.getNombreE())) {
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = new Educacion(
                dtoEducacion.getNombreE(), dtoEducacion.getDescripcionE()
        );
        eduService.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion creada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEducacion dtoEducacion) {
        if (!eduService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if (eduService.existsByNombreE(dtoEducacion.getNombreE())
                && eduService.getByNombreE(dtoEducacion.getNombreE()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoEducacion.getNombreE())) {
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = eduService.getOne(id).get();

        educacion.setNombreE(dtoEducacion.getNombreE());
        educacion.setDescripcionE(dtoEducacion.getDescripcionE());

        eduService.save(educacion);

        return new ResponseEntity(new Mensaje("Educacion actualiuzada"), HttpStatus.OK);
    }

}
