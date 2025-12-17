package com.krake2.veterinaria2.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krake2.veterinaria2.entity.Mascota;


@RestController
@RequestMapping("/api/mascotas")
public class MascotaController {

    private List<Mascota> mascotas = new ArrayList<>();

    public MascotaController() {
        mascotas.add(new Mascota(1, "Firulais", "Perro", 3, "Juan Perez"));
        mascotas.add(new Mascota(2, "Michi", "Gato", 2, "Ana Gomez"));
        mascotas.add(new Mascota(3, "Mony", "Perro", 4, "Martín"));
        mascotas.add(new Mascota(4, "Luna", "Gato", 1, "Sofía López"));
        mascotas.add(new Mascota(5, "Max", "Perro", 5, "Carlos Ruiz"));
    }

    @GetMapping
    public List<Mascota> getAllMascotas() {
        return mascotas;
    }

    @GetMapping("/{id}")
    public Mascota geMascotaById(@PathVariable int id) {
        Optional<Mascota> mascota = mascotas.stream().filter(m -> m.getId() == id).findFirst();
        return mascota.orElse(null);
    }

    @PostMapping
    public Mascota createMascota(@RequestBody Mascota mascota){
        mascotas.add(mascota);
        return mascota;
    }
    
    @DeleteMapping("/{id}")
    public String deleteMascota(@PathVariable int id){
        mascotas.removeIf(m->m.getId()==id);
        return "Mascota eliminada";
    }
}
