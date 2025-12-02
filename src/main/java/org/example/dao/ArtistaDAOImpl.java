package org.example.dao;

import org.example.entity.Artista;

public class ArtistaDAOImpl extends GenericDAOImpl<Artista> implements ArtistaDAO{

    public ArtistaDAOImpl() {
        super(Artista.class);
    }
}
