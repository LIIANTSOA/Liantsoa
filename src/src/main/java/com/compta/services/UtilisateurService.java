package com.compta.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compta.dto.LoginDto;
import com.compta.dto.UtilisateurDto;
import com.compta.models.Role;
import com.compta.models.Utilisateur;
import com.compta.repositories.RoleRepository;
import com.compta.repositories.UtilisateurRepository;

@Service
public class UtilisateurService {
    
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired 
    private RoleRepository roleRepository;

    public Object login(LoginDto loginDto){
        Utilisateur utilisateur = utilisateurRepository.findByEmail(loginDto.getEmail());
        if (utilisateur==null) {
            return "Utilisateur inconnue";
        }
        if (utilisateur.getPassword().equals(loginDto.getPassword())) {
            return utilisateur;
        }
        else{
            return "Mot de passe incorrect";
        }
    }

    public void register(UtilisateurDto utilisateurDto){
        Role role = roleRepository.findByCodeRole("USER");
        Utilisateur utilisateur = utilisateurDto.createUtilisateurByUtilisateurDto(role);
        utilisateurRepository.save(utilisateur);
    }

}
