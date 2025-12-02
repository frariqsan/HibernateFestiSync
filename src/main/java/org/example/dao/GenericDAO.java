package org.example.dao;

import java.util.Optional;

public interface GenericDAO<T> {
    Optional<T> findById(Long id);
    void save(T t);
    Optional<T> update(T t);
    void delete(T t);
}
