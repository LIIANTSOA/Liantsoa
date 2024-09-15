package com.compta.dto;

import com.compta.models.Role;
import com.compta.models.Utilisateur;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UtilisateurDto {
    
    private String username;
    private String email;
    private String password;

    public Utilisateur createUtilisateurByUtilisateurDto(Role role){
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setRole(role);
        utilisateur.setEmail(email);
        utilisateur.setUsername(username);
        utilisateur.setPassword(password);
        return utilisateur;
    }

}
