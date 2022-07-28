package avia.flight_service.service;

import java.util.List;

public interface ServiceContract<T> {

    void save(T o);
    T getById(Long id);
    List<T> getAll();
    void update(T o);
    void delete(T o);
}
