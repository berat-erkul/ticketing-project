package com.cydeo.service.impl;

import com.cydeo.dto.RoleDTO;
import com.cydeo.service.IRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl extends AbstractMapService<RoleDTO,Long> implements IRoleService {


    @Override
    public RoleDTO save(RoleDTO role) {
        return super.save(role.getId(),role);
    }

    @Override
    public RoleDTO findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<RoleDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void update(Long id, RoleDTO object) {
        super.update(id, object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }


}
