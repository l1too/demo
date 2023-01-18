
package com.portfolioGab.demo.repository;

import com.portfolioGab.demo.model.SobreMi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SobreMiRepository extends JpaRepository <SobreMi, Long>{
    
}
