package com.petcom.petshop.servceimpl;

import com.petcom.petshop.dto.UserDto;
import com.petcom.petshop.entity.User;
import com.petcom.petshop.repository.UserRepo;
import com.petcom.petshop.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    UserRepo userRepo;
    @Override
    public String saveUser(UserDto userDto) {
        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setPhoneNo(userDto.getPhoneNo());
        userRepo.save(user);
        return "User saved successfully";
    }
}
