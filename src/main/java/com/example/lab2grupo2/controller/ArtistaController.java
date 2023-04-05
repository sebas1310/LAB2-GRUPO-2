package com.example.lab2grupo2.controller;

import ch.qos.logback.core.model.Model;
import com.example.lab2grupo2.entity.Artista;

import com.example.lab2grupo2.repository.ArtistaRepository;
import com.example.lab2grupo2.repository.ProveedorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ArtistaController {

    final ArtistaRepository artistaRepository;
    public ArtistaController(ArtistaRepository artistaRepository) {
        this.artistaRepository = artistaRepository;
    }

    @GetMapping(value = "/artista/lista")
    public ArtistaController(Model model) {
        model.addAttribute("list",artistaRepository.findAll());
        this.artistaRepository = artistaRepository;
        return "artista/lista";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        List<Artista> artistaList = artistaRepository.findAll();
        return "shipper/lista";
    }


    @PostMapping("/guardar")
    public String guardar(Artista artista) {

        artistaRepository.save(artista);
        return "artista/lista";
    }


    @GetMapping("/editar")
    public String editar(@RequestParam("id") int id, Artista artista) {

        Optional<Artista> shipperOptional = artistaRepository.findById(id);
        if (shipperOptional.isPresent()) {
            Artista artista1 = shipperOptional.get();
            artista1.addAttribute("shipper", artista1);
            return "shipper/editarForm";
        } else {
            return "redirect:/listar";
        }
    }

    @GetMapping("/borrar")
    public String borrar(@RequestParam("id") int id) {
        Optional<Artista> shipperOptional = artistaRepository.findById(id);
        if (shipperOptional.isPresent()) {
            artistaRepository.deleteById(id);
        }
        return "redirect:/listar";
    }



}
