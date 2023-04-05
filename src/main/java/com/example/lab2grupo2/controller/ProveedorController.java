package com.example.lab2grupo2.controller;

import com.example.lab2grupo2.repository.ProveedorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProveedorController {

    final ProveedorRepository proveedorRepository;

    public ProveedorController(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    @GetMapping(value = "/proveedor/lista")
    public String listaProveedor(Model model){
        model.addAttribute("list",proveedorRepository.findAll());
        return "proveedor/lista";
    }
}
