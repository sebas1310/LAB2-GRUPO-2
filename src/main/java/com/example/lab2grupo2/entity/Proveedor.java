package com.example.lab2grupo2.entity;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "proveedores")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProveedores")
    private Integer id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Telefono")
    private Integer telefono;

    @Column(name = "Elemento")
    private String elemento;

}
