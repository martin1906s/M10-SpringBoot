package com.krake2.veterinaria2.service;

import java.util.List;
import java.util.Optional;

import com.krake2.veterinaria2.entity.EstadoMascota;
import com.krake2.veterinaria2.entity.Mascota;

public interface MascotaService {

    Mascota registrarMascota(Mascota mascota);

    List<Mascota> listarMascotas();

    Optional<Mascota> buscarPorNombre(String nombre);

    Optional<Mascota> buscarPorId(Long id);

    Mascota actualizarMascota(Long id, Mascota mascota);

    void eliminarMascota(Long id);

    Mascota cambiarEstadoMascota(Long id, EstadoMascota estado);

    List<Mascota> obtenerEstadoMascota(EstadoMascota estado);

}
