package com.compta.controllers;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.compta.dto.LoginDto;
import com.compta.dto.UtilisateurDto;
import com.compta.models.Utilisateur;
import com.compta.services.UtilisateurService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UtilisateurService utilisateurService;
    
    @GetMapping("/login")
    public String loginRedirect(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if (cookies!=null) {
            Optional<Cookie> userCookie = Arrays.stream(cookies)
                .filter(cookie -> "utilisateur_email".equals(cookie.getName()))
                .findFirst();
            if (userCookie.isPresent()) {
                return "index";
            }
        }
        return "auth/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginDto loginDto,Model model,HttpServletRequest request) {
        Object loginResponse = utilisateurService.login(loginDto);
        if (loginResponse.getClass() == String.class) {
            model.addAttribute("errorMessage", loginResponse.toString());
            return "auth/login";
        }
        Utilisateur utilisateur = (Utilisateur)loginResponse;
        Cookie cookie = new Cookie("utilisateur_email",loginDto.getEmail());
        cookie.setMaxAge(7 * 24 * 60 * 60); // Expire dans 7 jours
        cookie.setHttpOnly(true); // Empêche JavaScript d'accéder au cookie
        cookie.setPath("/"); // Le cookie sera disponible pour toute l'application
        if (utilisateur.getRole().getCodeRole().equalsIgnoreCase("ADMIN")) {
            return "admin/acceuil";   
        }
        return "user/acceuil";
    }


    @GetMapping("/register")
    public String registerRedirect(){
        return "auth/inscription";
    }

    @PostMapping("/register")
    public String postMethodName(@ModelAttribute UtilisateurDto utilisateurDto) {
        utilisateurService.register(utilisateurDto);
        return "auth/login";
    }
    
    

}
