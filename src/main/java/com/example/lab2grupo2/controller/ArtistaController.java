package com.example.lab2grupo2.controller;

import com.example.lab2grupo2.entity.Artista;

import com.example.lab2grupo2.entity.Integrante;
import com.example.lab2grupo2.entity.Proveedor;
import com.example.lab2grupo2.repository.ArtistaRepository;
import com.example.lab2grupo2.repository.IntegranteRepository;
import com.example.lab2grupo2.repository.ProveedorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ArtistaController {

    final ArtistaRepository artistaRepository;

    public ArtistaController(ArtistaRepository artistaRepository){
        this.artistaRepository= artistaRepository;
    }

    @GetMapping("/Integrante/lista")
    public String listaIntegrantes (Model model){
        List<Artista> artistaList = artistaRepository.findAll();
        model.addAttribute("listartistas",artistaList);
        return "artista/lista";
    }

    @GetMapping("/Integrante/editar")
    public String editarIntegrante(Model model, @RequestParam("id") int id){
        Optional<Artista> optIntegrante = artistaRepository.findById(id);

        if (optIntegrante.isPresent()) {
            Artista artista = optIntegrante.get();
            model.addAttribute("integrante", artista);
            return "integrante/editar";
        } else {
            return "artista/lista";
        }

    }

    @GetMapping("/Integrante/nuevo")
    public String nuevoIntegrante(){
        return "integrante/nuevo";
    }

    @PostMapping("/Integrante/guardar")
    public String guardarIntegrante(Artista artista){
        artistaRepository.save(artista);
        return "redirect:/artista/lista";
    }

/*
    public String borrarIntegrante(Model model, @RequestParam("id") int id){
        Optional<Artista> artistaOptional = artistaRepository.findById(id);

        if (optArtista.isPresent()) {
            artistaRepository.deleteById(id);
        }

        return "redirect:/artista/lista";
    }
*/
}


