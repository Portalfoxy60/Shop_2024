package org.example.services;

import java.util.List;

public interface Service<T> {
    T create();
    List<T> getAll();
    T getById(Long id);
    void delete(Long id);
    void update(T entity);
}
