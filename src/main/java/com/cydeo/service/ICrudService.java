package com.cydeo.service;

import com.cydeo.dto.RoleDTO;

import java.util.List;

public interface ICrudService<T,ID> {
    T save(T object);
    T findById(ID id);
    List<T> findAll();
    void deleteById(ID id);
    void update(ID id,T object);
}
