package org.example.repository;

import java.util.List;

public interface Repository<T> {
    boolean save(T entity);
    void saveAll(List<T> entities);
    List<T> load();
}
