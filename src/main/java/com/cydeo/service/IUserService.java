package com.cydeo.service;

import com.cydeo.dto.UserDTO;

import java.util.List;

public interface IUserService {
    UserDTO save(UserDTO user);
    UserDTO findById(String id); //This search is based on "Username" (String)
    List<UserDTO> findAll();
    void deleteById(Long id);


}
