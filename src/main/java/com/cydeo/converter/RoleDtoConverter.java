package com.cydeo.converter;

import com.cydeo.dto.RoleDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.cydeo.service.IRoleService;

@Component
public class RoleDtoConverter implements Converter<String, RoleDTO> {

    // "1" ==> RoleDTO

    private final IRoleService roleService;

    public RoleDtoConverter(IRoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public RoleDTO convert(String source) {  // "1" ==> 1

        if (source.isEmpty()){
            return null;
        }

        return roleService.findById(Long.parseLong(source));
    }
}
