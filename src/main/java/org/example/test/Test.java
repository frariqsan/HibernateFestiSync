package org.example.test;

import jakarta.persistence.PersistenceException;
import jakarta.persistence.criteria.*;
import org.example.dao.EventoDAO;
import org.example.dao.EventoDAOImpl;
import org.example.entity.Evento;
import org.example.entity.Lugar;
import org.example.service.EventoService;
import org.example.service.EventoServiceImpl;
import org.example.util.HibernateUtil;
import org.hibernate.Session;

public class Test {
    public static void main(String[] args) {
        EventoDAO eventoDAO = new EventoDAOImpl();
        EventoService eventoService = new EventoServiceImpl(eventoDAO);
        System.out.println("JPQL");
/*
        eventoService.buscarEventosPorLugarYCategoria("Arena Central", "Concierto")
                .forEach(System.out::println);
        eventoService.buscarEventosConArtista("Los Caminos")
                .forEach(System.out::println);


        //Ordenados ascendentemente
        eventoService.buscarEventosConLugarOrdenados().forEach(System.out::println);

 */
        //CRITERIA
        System.out.println("CRITERIA");
        try(Session s = HibernateUtil.getSessionFactory().openSession()) {
            try{
                //Eventos por fecha ascendente

                CriteriaBuilder cb = s.getCriteriaBuilder();
                CriteriaQuery<Evento> criteriaQuery = cb.createQuery(Evento.class);
                Root<Evento> root = criteriaQuery.from(Evento.class);
                criteriaQuery.select(root).orderBy(cb.asc(root.get("fecha")));
                System.out.println(s.createQuery(criteriaQuery).getResultList());

                //Lugares con aforos ordenados
                CriteriaQuery<Lugar> criteriaQuery1 = cb.createQuery(Lugar.class);
                Root<Lugar> root1 = criteriaQuery1.from(Lugar.class);
                criteriaQuery1.select(root1)
                        .where(cb.greaterThanOrEqualTo(root1.get("aforo"), 2000))
                        .orderBy(cb.asc(root1.get("aforo")));
                System.out.println(s.createQuery(criteriaQuery1).getResultList());


            }catch(PersistenceException e){
                e.printStackTrace();
            }
        }

    }
}
