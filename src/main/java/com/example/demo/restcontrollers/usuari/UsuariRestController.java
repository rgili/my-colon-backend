package com.example.demo.restcontrollers.usuari;

import com.example.demo.domain.usuaris.Usuari;
import com.example.demo.repositories.UsuariRepositori;
import com.example.demo.utils.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/usuari")
public class UsuariRestController {

    private UsuariRepositori usuariRepositori;
    private PasswordEncoder passwordEncoder;


    public UsuariRestController(UsuariRepositori usuariRepositori, PasswordEncoder passwordEncoder){
        this.usuariRepositori = usuariRepositori;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/{correuElectronic}/{password}")
    public Usuari getUsuariById(@PathVariable String correuElectronic, @PathVariable String password){
        Usuari usuari = usuariRepositori.findByCorreuElectronic(correuElectronic);

        if(usuari == null){
            throw new IllegalArgumentException("El correu introduït no existeix...", null);
        }

        password = this.passwordEncoder.MD5Encriptation(password);

        if(!usuari.getPassword().equals(password)){
            throw new IllegalArgumentException("Password inocrrecte...", null);
        }

        return usuari;
    }

    @PostMapping
    public void registrarUsuari(@RequestBody Usuari usuari){
        usuari.setPassword(this.passwordEncoder.MD5Encriptation(usuari.getPassword()));
        usuariRepositori.save(usuari);
    }


}
