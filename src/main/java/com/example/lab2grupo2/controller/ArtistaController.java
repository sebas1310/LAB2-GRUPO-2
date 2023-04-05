package com.example.lab2grupo2.controller;

import com.example.lab2grupo2.entity.Artista;
import com.example.lab2grupo2.repository.ArtistaRepository;
import com.example.lab2grupo2.repository.ProveedorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/artistas")
public class ArtistaController {
    final ArtistaRepository artistaRepository;

    public ArtistaController(ArtistaRepository artistaRepository) {
        this.artistaRepository = artistaRepository;
    }

    @GetMapping("/listar")
    public String listar(Artista artista) {


        return "shipper/lista";
    }


    @PostMapping("/guardar")
    public String guardar(Artista artista) {

        artistaRepository.save(artista);
        return "artista/lista";
    }

}
