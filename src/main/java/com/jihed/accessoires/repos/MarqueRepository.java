package com.jihed.accessoires.repos;


import org.springframework.data.jpa.repository.JpaRepository; 
import com.jihed.accessoires.entities.Marque; 
 
public interface MarqueRepository extends JpaRepository<Marque, Long> 
{ 
 
} 