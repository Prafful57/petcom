package com.petcom.petshop.service;

import com.petcom.petshop.dto.UserDto;
import com.petcom.petshop.entity.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    String saveUser(UserDto userDto);

    String updateUser(long userId, UserDto userDto);

}
