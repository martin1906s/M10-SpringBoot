package com.krake2.veterinaria2.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.krake2.veterinaria2.entity.Mascota;
import com.krake2.veterinaria2.repository.MascotaRepository;
import com.krake2.veterinaria2.service.MascotaService;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@Service
@RequiredArgsConstructor
public class MascotaServiceImpl implements MascotaService {

    private final MascotaRepository mascotaRepository;

    @Override
    public Mascota registrarMascota(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    @Override
    public List<Mascota> listarMascotas() {
        return mascotaRepository.findAll();
    }

    @Override
    public Optional<Mascota> buscarPorNombre(String nombre) {
        return mascotaRepository.findByNombre(nombre);
    }

    @Override
    public Optional<Mascota> buscarPorId(Long id) {
        return mascotaRepository.findById(id);
    }

    @Override
    @SneakyThrows
    public Mascota actualizarMascota(Long id, Mascota mascota) {
        Mascota mascotaExistente = mascotaRepository.findById(id).orElseThrow(() -> new Exception("Producto con id " + id + " no encontrado"));
        mascotaExistente.setNombre(mascota.getNombre());
        mascotaExistente.setEspecie(mascota.getEspecie());
        mascotaExistente.setEdad(mascota.getEdad());
        mascotaExistente.setNombreDueno(mascota.getNombreDueno());
        mascotaExistente.setFechaRegistro(mascota.getFechaRegistro());

        Mascota mascotaActualizada = mascotaRepository.save(mascotaExistente);
        return mascotaActualizada;
    }

    @Override
    @SneakyThrows
    public void eliminarMascota(Long id) {
        mascotaRepository.findById(id).orElseThrow(() -> new Exception("Producto con id " + id + " no encontrado"));
        mascotaRepository.deleteById(id);

    }

}
