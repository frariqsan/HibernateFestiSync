package org.example.service;

import org.example.entity.Evento;

import java.util.List;
import java.util.Optional;

public interface EventoService {
    Optional<Evento> buscarPorId(Long id);
    void guardarEvento(Evento evento);
    void actualizarEvento(Evento evento);
    void eliminarEvento(Evento evento);

    List<Evento> buscarEventosPorLugarYCategoria(String nombreLug, String nombreCat);
    List<Evento> buscarEventosConArtista(String nombreArt);
    List<Evento> buscarEventosConLugarOrdenados();
}
