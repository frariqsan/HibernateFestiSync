package org.example.dao;

import org.example.entity.EventoArtista;

public class EventoArtistaDAOImpl extends GenericDAOImpl<EventoArtista> implements EventoArtistaDAO {
    public EventoArtistaDAOImpl() {
        super(EventoArtista.class);
    }
}
