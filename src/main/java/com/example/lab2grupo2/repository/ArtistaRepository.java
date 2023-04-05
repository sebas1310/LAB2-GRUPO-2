package com.example.lab2grupo2.repository;

import com.example.lab2grupo2.entity.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista,Integer> {
}
