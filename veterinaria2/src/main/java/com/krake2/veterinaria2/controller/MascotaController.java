package com.krake2.veterinaria2.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krake2.veterinaria2.entity.EstadoMascota;
import com.krake2.veterinaria2.entity.Mascota;
import com.krake2.veterinaria2.service.MascotaService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/mascotas")
@RequiredArgsConstructor
public class MascotaController {

    private final MascotaService mascotaService;

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarMascota(@RequestBody Mascota mascota) {
        Mascota nuevaMascota = mascotaService.registrarMascota(mascota);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaMascota);
    }

    @GetMapping
    public ResponseEntity<List<Mascota>> listarMascotas() {
        List<Mascota> mascotas = mascotaService.listarMascotas();
        return ResponseEntity.ok(mascotas);

    }

    @GetMapping("/buscar/nombre/{nombre}")
    public ResponseEntity<?> buscarPorNombre(@PathVariable String nombre) {
        Optional<Mascota> mascota = mascotaService.buscarPorNombre(nombre);
        return mascota.isPresent() ? ResponseEntity.ok(mascota.get()) : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mascota NO encotrada");
    }

    @GetMapping("/buscar/id/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Optional<Mascota> mascota = mascotaService.buscarPorId(id);
        return mascota.isPresent() ? ResponseEntity.ok(mascota.get()) : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mascota NO encotrada");
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarMascota(@PathVariable Long id, @RequestBody Mascota mascota) {
        try {
            Mascota mascotaActualizada = new Mascota();
            mascotaActualizada.setNombre(mascota.getNombre());
            mascotaActualizada.setEdad(mascota.getEdad());
            mascotaActualizada.setEspecie(mascota.getEspecie());
            mascotaActualizada.setNombreDueno(mascota.getNombreDueno());
            mascotaActualizada.setFechaRegistro(mascota.getFechaRegistro());

            Mascota mascotaBDD = mascotaService.actualizarMascota(id, mascotaActualizada);

            return ResponseEntity.ok(mascotaBDD);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarMascota(@PathVariable Long id) {
        try {
            mascotaService.eliminarMascota(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/estado/{id}")
    public ResponseEntity<?> cambiarEstado(@PathVariable Long id, @RequestBody EstadoMascota estado) {
        try {
            Mascota mascota = mascotaService.cambiarEstadoMascota(id, estado);
            return ResponseEntity.ok(mascota);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Mascota>> listaMascotasPorEstado(@PathVariable EstadoMascota estado) {
        List<Mascota> mascotasEstado = mascotaService.obtenerEstadoMascota(estado);
        return ResponseEntity.ok(mascotasEstado);
    }

}
