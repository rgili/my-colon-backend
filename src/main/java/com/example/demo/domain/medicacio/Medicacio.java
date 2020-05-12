package com.example.demo.domain.medicacio;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "medicacio")
public class Medicacio {

    private int id;
    private String nom;
    private int forma;
    private String dosi;
    private int franja;
    private int usuari;
    private Date data;


    private static final int CAPSULA = 1;
    private static final int INHALADOR = 2;
    private static final int UNGUENT = 3;
    private static final int PEGAT = 4;
    private static final int GOTES = 5;
    private static final int INJECCIO = 6;
    private static final int PASTILLA = 7;

    private static final int FRANJA_MATI = 11;
    private static final int FRANJA_TARDA = 12;
    private static final int FRANJA_NIT = 13;


    public Medicacio (){}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "nom")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Column(name = "forma")
    public int getForma() {
        return forma;
    }

    public void setForma(int tipus) {
        this.forma = tipus;
    }

    @Column(name = "dosi")
    public String getDosi() {
        return dosi;
    }

    public void setDosi(String dosi) {
        this.dosi = dosi;
    }

    @Column(name = "usuari")
    public int getUsuari() {
        return usuari;
    }

    public void setUsuari(int userId) {
        this.usuari = userId;
    }

    @Column(name = "data")

    public Date getData(){return this.data;}

    public void setData(Date data){
        this.data = data;
    }

    @Column(name = "franja")
    public int getFranja(){return this.franja;}

    public void setFranja(int franja){this.franja = franja;}
}
