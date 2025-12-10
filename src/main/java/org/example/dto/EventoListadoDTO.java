package org.example.dto;

import java.time.LocalDate;

public record EventoListadoDTO(Long id, String nombre, LocalDate fecha, String lugarNombre) {
}
