package com.krake2.veterinaria2.controller;

import java.time.LocalDate;
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
        mascotas.add(new Mascota(1L, "Firulais", "Perro", 3, "Juan Perez", LocalDate.parse("2022-01-05")));
        mascotas.add(new Mascota(2L, "Michi", "Gato", 2, "Ana Gomez", LocalDate.parse("2022-02-10")));
        mascotas.add(new Mascota(3L, "Mony", "Perro", 4, "Martín", LocalDate.parse("2022-03-15")));
        mascotas.add(new Mascota(4L, "Luna", "Gato", 1, "Sofía López", LocalDate.parse("2022-04-20")));
        mascotas.add(new Mascota(5L, "Max", "Perro", 5, "Carlos Ruiz", LocalDate.parse("2022-05-25")));
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
