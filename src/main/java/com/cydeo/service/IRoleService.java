package com.cydeo.service;

import com.cydeo.dto.RoleDTO;

import java.util.List;

public interface IRoleService {
    RoleDTO save(RoleDTO role);
    RoleDTO findById(Long id);
    List<RoleDTO> findAll();
    void deleteById(Long id);
}
