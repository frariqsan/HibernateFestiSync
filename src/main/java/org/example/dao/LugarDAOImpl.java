package org.example.dao;

import org.example.entity.Lugar;

public class LugarDAOImpl extends GenericDAOImpl<Lugar> implements LugarDAO {
    public LugarDAOImpl() {
        super(Lugar.class);
    }
}
