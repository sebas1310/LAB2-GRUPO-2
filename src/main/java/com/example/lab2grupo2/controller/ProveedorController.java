package com.example.lab2grupo2.controller;

import com.example.lab2grupo2.entity.Proveedor;
import com.example.lab2grupo2.repository.ProveedorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

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
    @GetMapping(value = "/proveedor/editar")
    public String editaDistribuidoras(@RequestParam("id") Integer id, Model model){
        Optional<Proveedor> optionalDistributors= proveedorRepository.findById(id);
        if(optionalDistributors.isPresent()){
            Proveedor proveedor = optionalDistributors.get();
            model.addAttribute("prov", proveedor);
            return "proveedor/edit";
        }else {
            return "redirect:/proveedor/lista";
        }

    }


    @PostMapping(value = "proveedor/guardar")
    public String guardar(Proveedor proveedor){
        proveedorRepository.save(proveedor);
        return "redirect:/proveedor/lista";
    }
}
