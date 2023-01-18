
package com.portfolioGab.demo.security.repository;

import com.portfolioGab.demo.security.enums.RolNombre;
import com.portfolioGab.demo.security.model.Rol;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Long>{
    Optional<Rol> findByRolNombre (RolNombre rolNombre);
}
