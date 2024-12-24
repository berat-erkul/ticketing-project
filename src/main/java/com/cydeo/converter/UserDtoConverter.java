package com.cydeo.converter;

import com.cydeo.dto.UserDTO;
import com.cydeo.service.IUserService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter implements Converter<String, UserDTO> {

    private final IUserService userService;

    public UserDtoConverter(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDTO convert(String source) {
        return userService.findById(source);
    }
}
