package ra.exercise.service;

import java.util.List;
import java.util.Optional;

public interface IGeneric <T, E>{
    List<T> findAll();
    Optional<T> findById(E id);
    T save(T t);
    void delete(E id);
    void update(T t);
}
