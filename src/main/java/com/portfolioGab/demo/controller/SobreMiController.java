package com.portfolioGab.demo.controller;

import com.portfolioGab.demo.model.SobreMi;
import com.portfolioGab.demo.service.ISobreMiService;
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
public class SobreMiController {

    @Autowired
    private ISobreMiService interSobreMi;

    @GetMapping("/sobremis/traer")
    public List<SobreMi> getSobreMis() {
        return interSobreMi.getSobreMis();
    }

    @PostMapping("/sobremis/crear")
    public String createStudent(@RequestBody SobreMi sobre) {
        interSobreMi.saveSobreMi(sobre);
        // devuleve un string avisando si creo correctamente
        return "La persona fue creada correctamente";
    }

    @DeleteMapping("/sobremis/borrar/{id}")
    public String deleteSobreMi(@PathVariable Long id) {
        interSobreMi.deleteSobreMi(id);
        // devuelve un stringf aviasando si se elimino correctamente
        return "La perosna se elimino correctamnete";
    }

    @PutMapping("sobremis/editar/{id}")
    public SobreMi editSobreMi(@PathVariable Long id,
            @RequestParam("titulo") String nuevoTitulo,
            @RequestParam("descripcion") String nuevoDescripcion,
            @RequestParam("foto") String nuevoFoto) {

        // Busco la persona en cuestion
        SobreMi sobre = interSobreMi.findSobreMi(id);

        // Esto tambien puede ir en service
        // Para desacoplar mejor aun el codigo en un nuevo metodo
        sobre.setTitulo(nuevoTitulo);
        sobre.setDescripcion(nuevoDescripcion);
        sobre.setFoto(nuevoFoto);
       

        interSobreMi.saveSobreMi(sobre);
        // Retorna la nueva persona
        return sobre;
    }

    @GetMapping("/sobremis/traer/perfil")
    public SobreMi findSobreMi() {
        return interSobreMi.findSobreMi((long) 1);
    }
}



