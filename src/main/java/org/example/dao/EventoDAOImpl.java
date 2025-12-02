package org.example.dao;

import org.example.entity.Evento;

public class EventoDAOImpl extends GenericDAOImpl<Evento> implements EventoDAO {
    public EventoDAOImpl() {
        super(Evento.class);
    }
}
