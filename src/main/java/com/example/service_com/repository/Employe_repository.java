package com.example.service_com.repository;


import java.util.Optional;

import com.example.service_com.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Employe_repository extends JpaRepository<Employe,Integer>{

    Optional<Employe> findById(Integer employeId);
    
}
