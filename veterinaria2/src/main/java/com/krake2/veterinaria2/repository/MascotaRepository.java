package com.krake2.veterinaria2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krake2.veterinaria2.entity.Mascota;


public interface MascotaRepository extends JpaRepository<Mascota, Long> {
    Optional<Mascota> findById(Long id);
    Optional<Mascota> findByNombre(String nombre);

}
