package com.halit.utiliy;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class ServiceManager<T, ID> implements IServices<T, ID> {
    private final JpaRepository<T, ID> service;

    public ServiceManager(JpaRepository<T, ID> service) {
        this.service = service;
    }

    @Override
    public T save(T entity) {
        return service.save(entity);
    }

    @Override
    public Iterable<T> saveAll(Iterable<T> entities) {
        return service.saveAll(entities);
    }

    @Override
    public T update(T entity) {
        return service.save(entity);
    }

    @Override
    public void delete(T entity) {
        service.delete(entity);
    }

    @Override
    public void deleteById(ID id) {
        service.deleteById(id);
    }


    public Optional<T> findById(ID id) {
        return service.findById(id);
    }

    @Override
    public List<T> findAll() {
        return service.findAll();
    }
}