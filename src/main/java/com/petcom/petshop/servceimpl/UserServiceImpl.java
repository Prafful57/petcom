package com.petcom.petshop.servceimpl;

import com.petcom.petshop.dto.UserDto;
import com.petcom.petshop.entity.User;
import com.petcom.petshop.repository.UserRepo;
import com.petcom.petshop.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;
    @Override
    public String saveUser(UserDto userDto) {
        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setPhoneNo(userDto.getPhoneNo());
        user.setRole(3,"User");
        user.setIsActive(true);
        userRepo.save(user);
        log.info("User saved successfully");
        return "User saved successfully";
    }
}
