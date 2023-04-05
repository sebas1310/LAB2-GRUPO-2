package com.example.lab2grupo2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="integrantes")

public class Integrante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idIntegrantes",nullable = false)
    private Integer idIntegrante;

    @Column(name = "Nombre",length = 45)
    private String nombre;

    @Column(name = "Edad")
    private Integer edad;

    @Column(name = "Anhios_exp")
    private Integer anios_exp;

    @Column(name = "rol",length = 40)
    private String rol;

    @Column(name = "artistas_idArtistas")
    private Integer idArtistas;


}
