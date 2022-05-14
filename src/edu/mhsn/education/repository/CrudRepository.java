package edu.mhsn.education.repository;

import java.util.List;

public interface CrudRepository<E> {

    void create(E created);

    void update(E updated);

    E findByKey(int key);

    List<E> findAll();

    boolean delete(int key);
}
