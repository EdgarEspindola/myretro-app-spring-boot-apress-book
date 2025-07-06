package com.example.myretro.persistence;

import java.util.Optional;

public interface SimpleRepository<D, ID> {
    Optional<D> findById(ID id);
    Iterable<D> findAll();
    D save(D domain);
    void deleteById(ID id);
}
