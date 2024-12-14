package com.cydeo.converter;

import com.cydeo.dto.RoleDTO;
import com.cydeo.service.IRoleService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoleDtoConverter implements Converter<String,RoleDTO> {

    IRoleService roleService;

    public RoleDtoConverter(IRoleService roleService) {
        this.roleService = roleService;
    }


    @Override
    public RoleDTO convert(String source) {
        return roleService.findById(Long.parseLong(source));
    }

}
