package org.example.service;

import org.example.dao.EventoDAO;
import org.example.entity.Evento;

import java.util.List;
import java.util.Optional;

public class EventoServiceImpl implements EventoService{

    private final EventoDAO eventoDAO;

    public EventoServiceImpl(EventoDAO eventoDAO) {
        this.eventoDAO = eventoDAO;
    }

    @Override
    public Optional<Evento> buscarPorId(Long id) {
        return eventoDAO.findById(id);
    }

    @Override
    public void guardarEvento(Evento evento) {
        eventoDAO.save(evento);
    }

    @Override
    public void actualizarEvento(Evento evento) {
        eventoDAO.update(evento);
    }

    @Override
    public void eliminarEvento(Evento evento) {
        eventoDAO.delete(evento);
    }

    @Override
    public List<Evento> buscarEventosPorLugarYCategoria(String nombreLug, String nombreCat) {
        return eventoDAO.findByLugarAndCategoria(nombreLug, nombreCat);
    }

    @Override
    public List<Evento> buscarEventosConArtista(String nombreArt) {
        return eventoDAO.findByArtistaNombre(nombreArt);
    }

    @Override
    public List<Evento> buscarEventosConLugarOrdenados() {
        return eventoDAO.findEventosConLugarOrdenados();
    }
}
