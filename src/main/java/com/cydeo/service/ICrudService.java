package com.cydeo.service;

import com.cydeo.dto.RoleDTO;

import java.util.List;

public interface ICrudService<T,ID> {
    T save(T object);
    T findById(ID id);
    List<T> findAll();
    void deleteById(ID id);

    //RoleDTO save(RoleDTO role);
    //RoleDTO findById(Long id);
    //List<RoleDTO> findAll();
    //void deleteById(Long id);
}
