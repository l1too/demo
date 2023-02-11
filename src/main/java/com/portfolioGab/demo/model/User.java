
package com.portfolioGab.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name="loginUser")
@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class User {
    
    @Id
    private String userId;
    private String password;
    public String getUserId(){
        return userId;
    }
    public Object getPassword(){
        return password;
    }
  
}
