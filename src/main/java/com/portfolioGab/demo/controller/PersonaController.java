
package com.portfolioGab.demo.controller;

import com.portfolioGab.demo.model.Persona;
import com.portfolioGab.demo.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class PersonaController {
    
    @Autowired
    private IPersonaService interPersona;
    
    @GetMapping ("/personas/traer")
    public List<Persona> getPersonas(){
        return interPersona.getPersonas();
    } 
    
    @PostMapping ("/personas/crear")
    public String createStudent(@RequestBody Persona perso){
        interPersona.savePersona(perso);
        // devuleve un string avisando si creo correctamente
        return "La persona fue creada correctamente";
    }
    
    @DeleteMapping ("/personas/borrar/{id}")
    public String deletePersona (@PathVariable Long id){
        interPersona.deletePersona(id);
        // devuelve un stringf aviasando si se elimino correctamente
        return "La perosna se elimino correctamnete";
    }
    
    @PutMapping ("personas/editar/{id}")
    public Persona editPersona (@PathVariable Long id,
                                @RequestParam ("nombre") String nuevoNombre,
                                @RequestParam ("apellido") String nuevoApellido,
                                @RequestParam ("oficio") String nuevoOficio,
                                @RequestParam ("imgFondo") String nuevoImgFondo) {
        
        // Busco la persona en cuestion
        Persona perso = interPersona.findPersona(id);
        
        // Esto tambien puede ir en service
        // Para desacoplar mejor aun el codigo en un nuevo metodo
         perso.setApellido(nuevoApellido);
         perso.setNombre(nuevoNombre);
         perso.setOficio(nuevoOficio);
         perso.setImgFondo (nuevoImgFondo);
         
         interPersona.savePersona(perso);
         // Retorna la nueva persona
         return perso;
    }
    
    @GetMapping("/personas/traer/perfil")
    public Persona findPersona(){
        return interPersona.findPersona((long)1);
    }
}
