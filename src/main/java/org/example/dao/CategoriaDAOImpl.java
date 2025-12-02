package org.example.dao;

import org.example.entity.Categoria;

public class CategoriaDAOImpl extends GenericDAOImpl<Categoria> implements CategoriaDAO {
    public CategoriaDAOImpl() {
        super(Categoria.class);
    }
}
