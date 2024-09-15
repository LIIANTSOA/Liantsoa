package com.compta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compta.models.Actif;

public interface ActifRepository extends JpaRepository<Actif,Long> {
    
}
