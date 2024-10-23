package com.petcom.petshop.service;

import com.petcom.petshop.dto.UserDto;

import com.petcom.petshop.entity.User;

public interface UserService {
    String saveUser(UserDto userDto);

    String updateUser(long userId, UserDto userDto);
	User getUserById(long userId);

	User deleteUserById(long userId);

}
