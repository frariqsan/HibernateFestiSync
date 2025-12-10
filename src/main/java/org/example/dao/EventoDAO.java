package org.example.dao;

import org.example.entity.Evento;

import java.util.List;

public interface EventoDAO extends GenericDAO<Evento> {
    //JPQL
    List<Evento> findByLugarAndCategoria(String lugar, String categoria);
    List<Evento> findByArtistaNombre(String nomArt);
    List<Evento> findEventosConLugarOrdenados();

    //CRITERIA
    List<Evento> findByFechaDesc();
    List<Evento> findByAforoLugarAsc(int aforoMinimo);




}
