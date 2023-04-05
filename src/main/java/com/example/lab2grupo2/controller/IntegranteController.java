package com.example.lab2grupo2.controller;

import com.example.lab2grupo2.entity.Integrante;
import com.example.lab2grupo2.repository.IntegranteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class IntegranteController {

    final IntegranteRepository integranteRepository;

    public IntegranteController(IntegranteRepository integranteRepository){
        this.integranteRepository= integranteRepository;
    }

    @GetMapping("/Integrante/lista")
    public String listaIntegrantes (Model model){
        List<Integrante> lista = integranteRepository.findAll();
        model.addAttribute("listaIntegrantes",lista);
        return "integrante/lista";
    }

    @GetMapping("/Integrante/editar")
    public String editarIntegrante(Model model, @RequestParam("id") int id){
        Optional<Integrante> optIntegrante = integranteRepository.findById(id);

        if (optIntegrante.isPresent()) {
            Integrante integrant = optIntegrante.get();
            model.addAttribute("integrante", integrant);
            return "integrante/editar";
        } else {
            return "integrante/lista";
        }

    }

    @GetMapping("/Integrante/nuevo")
    public String nuevoIntegrante(){
        return "integrante/nuevo";
    }

    @PostMapping("/Integrante/guardar")
    public String guardarIntegrante(Integrante integrante){
        integranteRepository.save(integrante);
        return "redirect:/Integrante/lista";
    };


        public String borrarIntegrante(Model model, @RequestParam("id") int id){
            Optional<Integrante> optIntegrante = integranteRepository.findById(id);

            if (optIntegrante.isPresent()) {
                integranteRepository.deleteById(id);
            }

            return "redirect:/Integrante/lista";
            }

        }

