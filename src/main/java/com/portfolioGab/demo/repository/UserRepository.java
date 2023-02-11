
package com.portfolioGab.demo.repository;

import com.portfolioGab.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, String>{
    User findByUserId(String userId);
}
