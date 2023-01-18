
package com.portfolioGab.demo.security.service;

import com.portfolioGab.demo.security.enums.RolNombre;
import com.portfolioGab.demo.security.model.Rol;
import com.portfolioGab.demo.security.repository.IRolRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    @Autowired
    IRolRepository iRolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return iRolRepository.findByRolNombre(rolNombre);
    }
    public void save(Rol rol){
        iRolRepository.save(rol);
    }
}
