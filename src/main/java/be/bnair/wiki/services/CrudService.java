package be.bnair.wiki.services;

import java.util.List;
import java.util.Optional;

public interface CrudService<T, TKey> {
    T create(T creater);
    default void remove(TKey id) throws Exception { throw new Exception(); }
    default T update(TKey id, T updater) throws Exception { throw new Exception(); }
    List<T> getAll();
    Optional<T> getOneById(TKey id);
}