package com.petcom.petshop.servceimpl;

import com.petcom.petshop.dto.UserDto;
import com.petcom.petshop.entity.User;
import com.petcom.petshop.repository.UserRepo;
import com.petcom.petshop.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;
    @Override
    public String saveUser(UserDto userDto) {
        if(userDto == null){
            log.warn("Set some valid fields!");
        }
        User user = new User();
        if(userDto.getUserName()!= null && !userDto.getUserName().isEmpty()){
            user.setUserName(userDto.getUserName());
        }else{
            log.info("Please set the valid username!");
        }
        if(userDto.getPassword()!=null && !userDto.getPassword().isEmpty()){
            user.setPassword(userDto.getPassword());
        }else{
            log.info("Please set the valid password!");
        }
        if(userDto.getEmail()!=null && !userDto.getEmail().isEmpty()){
            user.setEmail(userDto.getEmail());
        }else{
            log.info("Please set the valid email!");
        }
        if(userDto.getPhoneNo().length() != 10) {
            log.warn("Incorrect Phone Number {}", userDto.getPhoneNo());
        }
        else{
            user.setPhoneNo(userDto.getPhoneNo());
        }
        user.setRole(3,"User");
        user.setIsActive(true);

        userRepo.save(user);
        log.info("User saved successfully!");
        return "User saved successfully!";
    }

    public String updateUser(long userId, UserDto userDto){
        User updateUser = userRepo.findById(userId).orElseThrow(()->new NoSuchElementException("User with Id :"+userId+ " is not present"));
        if(userDto == null){
            log.warn("Set some valid fields!");
        }
        if(userDto.getUserName()!= null && !userDto.getUserName().isEmpty()){
            updateUser.setUserName(userDto.getUserName());
        }else{
            log.info("Please set the valid username!");
        }
        if(userDto.getPassword()!=null && !userDto.getPassword().isEmpty()){
            updateUser.setPassword(userDto.getUserName());
        }else{
            log.info("Please set the valid password!");
        }
        if(userDto.getEmail()!=null && !userDto.getEmail().isEmpty()){
            updateUser.setEmail(userDto.getEmail());
        }else{
            log.info("Please set the valid email!");
        }
        if(userDto.getPhoneNo().length() != 10) {
            log.warn("Incorrect Phone Number {}", userDto.getPhoneNo());
        }
        else{
            updateUser.setPhoneNo(userDto.getPhoneNo());
        }

        userRepo.save(updateUser);
        log.info("UserDetails Updated successfully!");
        return "User Updated successfully!";
    }

	@Override
	public User getUserById(long userId) {
		User getUser =  userRepo.findById(userId).orElseThrow(()-> new NoSuchElementException("User with Id :"+userId+ " is not present"));
		return getUser;
	}

	@Override
	public User deleteUserById(long userId) {
		User user = userRepo.findById(userId)
		        .orElseThrow(() -> new NoSuchElementException("User with Id: " + userId + " is not present"));
		    
		    userRepo.deleteById(userId);
		    return user;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
}
