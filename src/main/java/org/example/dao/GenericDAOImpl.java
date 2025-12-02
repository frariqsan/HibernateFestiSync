package org.example.dao;

import jakarta.persistence.PersistenceException;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Optional;

public class GenericDAOImpl<T> implements GenericDAO<T>{

    private final Class<T> entityClass;

    public GenericDAOImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }


    @Override
    public Optional<T> findById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            return Optional.ofNullable(session.getReference(entityClass,id));
        }
    }

    @Override
    public void save(T t) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction tx = null;
            try{
                tx = session.beginTransaction();
                session.persist(t);
                tx.commit();
            }catch (PersistenceException e){
                if (tx != null){
                    tx.rollback();
                }
                e.printStackTrace();
            }
        }

    }

    @Override
    public Optional<T> update(T t) {
        T tMerged = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction tx = null;
            try{
                tx = session.beginTransaction();
                tMerged = session.merge(t);
                tx.commit();
            }catch (PersistenceException e){
                if(tx != null){
                    tx.rollback();
                }
                e.printStackTrace();
            }
        }
        return Optional.ofNullable(tMerged);
    }

    @Override
    public void delete(T t) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                session.remove(t);
                tx.commit();
            }catch (PersistenceException e){
                if(tx != null){
                    tx.rollback();
                }
                e.printStackTrace();
            }
        }
    }
}
