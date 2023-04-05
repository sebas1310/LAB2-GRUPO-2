package com.example.lab2grupo2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "artistas")

public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idArtistas")
    private Integer id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Fecha")
    private Integer fecha;

    @Column(name = "TipoMusica")
    private String tipoMusica;

}
