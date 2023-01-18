
package com.portfolioGab.demo.service;

import com.portfolioGab.demo.model.SobreMi;
import java.util.List;


public interface ISobreMiService {
            // metodo para traer todas las personas
    public List<SobreMi> getSobreMis();
    
    // metodo para dar de alta una persona
    public void saveSobreMi (SobreMi sobre);
    
    // metodo para borrar una persona
    public void deleteSobreMi (Long id);
    
    // metodo para encontrar una persona
    public SobreMi findSobreMi(Long id);
}
