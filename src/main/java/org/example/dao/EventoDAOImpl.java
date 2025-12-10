package org.example.dao;

import jakarta.persistence.PersistenceException;
import org.example.entity.*;
import org.example.util.HibernateUtil;
import org.hibernate.Session;

import jakarta.persistence.criteria.*;

import java.time.LocalDate;
import java.util.List;

public class EventoDAOImpl extends GenericDAOImpl<Evento> implements EventoDAO {

    public EventoDAOImpl() {
        super(Evento.class);
    }

    //JPQL
    @Override
    public List<Evento> findByLugarAndCategoria(String lugar, String categoria) {
        try(Session s = HibernateUtil.getSessionFactory().openSession()) {
            String jpql = "SELECT e FROM Evento e JOIN e.lugar l " +
                        "JOIN Categoria c ON c.evento = e WHERE l.nombre = :lugarNombre AND c.nombre = :categoriaNombre";

            return s.createQuery(jpql, Evento.class)
                    .setParameter("lugarNombre", lugar)
                    .setParameter("categoriaNombre", categoria)
                    .getResultList();
        }
    }
    //JPQL
    @Override
    public List<Evento> findByArtistaNombre(String nomArt) {
        try(Session s = HibernateUtil.getSessionFactory().openSession()) {
            String jpql = "SELECT e FROM Evento e JOIN EventoArtista ea ON ea.evento = e " +
                    "JOIN ea.artista a WHERE a.nombre = :artistaNombre";


            return s.createQuery(jpql, Evento.class)
                    .setParameter("artistaNombre", nomArt)
                    .getResultList();
        }
    }
    //JPQL
    @Override
    public List<Evento> findEventosConLugarOrdenados() {
        try(Session s = HibernateUtil.getSessionFactory().openSession()) {
            String jpql = "SELECT e FROM Evento e JOIN e.lugar l ORDER BY e.fecha ASC";

            return s.createQuery(jpql, Evento.class)
                    .getResultList();
        }
    }

    @Override
    public List<Evento> findByFechaDesc() {
        return List.of();
    }

    @Override
    public List<Evento> findByAforoLugarAsc(int aforoMinimo) {
        return List.of();
    }

}
/*
    //CRITERIA ordenacion descendente
    @Override
    public List<Evento> findByFechaDesc() {
        try(Session s = HibernateUtil.getSessionFactory().openSession()) {

                CriteriaBuilder builder = s.getCriteriaBuilder();
                CriteriaQuery<Evento> criteriaQuery = builder.createQuery(Evento.class);
                Root<Evento> rootEvento = criteriaQuery.from(Evento.class);
                criteriaQuery.select(rootEvento).orderBy(builder.desc(rootEvento.get("fecha")));
                return s.createQuery(criteriaQuery).getResultList();

        }
    }

    //CRITERIA JOIN Ascendente
    @Override
    public List<Evento> findByAforoLugarAsc(int aforoMinimo) {
        try(Session s = HibernateUtil.getSessionFactory().openSession()) {

            CriteriaBuilder builder = s.getCriteriaBuilder();
            CriteriaQuery<Evento> criteriaQuery = builder.createQuery(Evento.class);
            Root<Evento> rootEvento = criteriaQuery.from(Evento.class);
            Join<Evento, Lugar> joinLugar = rootEvento.join("lugar");
            criteriaQuery.where(builder.ge(joinLugar.get("aforo"), aforoMinimo));
            criteriaQuery.select(rootEvento).orderBy(builder.asc(rootEvento.get("nombre")));
            return s.createQuery(criteriaQuery).getResultList();

        }
    }

     */
