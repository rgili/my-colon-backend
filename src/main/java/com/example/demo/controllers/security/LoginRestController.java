package com.example.demo.controllers.security;

import com.example.demo.domain.usuaris.Usuari;
import com.example.demo.repositories.usuaris.UsuariRepositori;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/login")
public class LoginRestController {

    private UsuariRepositori usuariRepositori;

    public LoginRestController(UsuariRepositori usuariRepositori){
        this.usuariRepositori = usuariRepositori;
    }

    @GetMapping
    public Map<String, String> login(Principal principal){
        Usuari usuari = this.usuariRepositori.findByCorreuElectronic(principal.getName());
        return this.mapUsuari(usuari);
    }

    @GetMapping("/all")
    public List<Map<String, String>> allUsuaris(Principal principal){
        List<Map<String, String>> allUsers = new ArrayList<>();

        usuariRepositori.findAll().forEach(usuari -> {
            allUsers.add(this.mapUsuari(usuari));
        });

        return allUsers;
    }

    private Map<String, String> mapUsuari(Usuari usuari){
        Map<String, String> infoUsuari = new HashMap<>();

        infoUsuari.put("nom", usuari.getNom());
        infoUsuari.put("primerCognom", usuari.getPrimerCognom());
        infoUsuari.put("segonCognom", usuari.getSegonCognom());
        infoUsuari.put("correuElectronic", usuari.getCorreuElectronic());
        infoUsuari.put("id", String.valueOf(usuari.getId()));

        return infoUsuari;
    }

}
