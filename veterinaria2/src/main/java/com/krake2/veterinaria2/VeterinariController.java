package com.krake2.veterinaria2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/veterinaria")
public class VeterinariController {
    @GetMapping("/bienvenida")
    public String bienvenida() {
        return "Bienvenido al Sistema de Gestión Veterinaria";
    }
}
