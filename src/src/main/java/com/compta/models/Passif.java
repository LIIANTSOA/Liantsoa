package com.compta.models;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "passif")
public class Passif {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "date_acquisition")
    Date dateAcquisition;

    @Column(name = "passif_valeur")
    BigDecimal passifValeur;

    @Column(name = "passif_nom")
    String passifNom;

}
