package com.compta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compta.models.Utilisateur;


public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {

    Utilisateur findByEmail(String email);
    

}
