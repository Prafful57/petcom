package com.petcom.petshop.controller;
import com.petcom.petshop.dto.UserDto;
import com.petcom.petshop.entity.User;
import com.petcom.petshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto){
        userService.saveUser(userDto);
        return new ResponseEntity<>(userDto,HttpStatus.CREATED);
    }

    @PutMapping("update-user/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable long userId , @RequestBody UserDto userDto){
        userService.updateUser(userId,userDto);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

    @GetMapping("get-user/{userId}")
    public User getUser(@PathVariable long userId){
    	return userService.getUserById(userId);
    }
    
    @DeleteMapping("delete-user/{userId}")
    public User deleteUser(@PathVariable long userId){
    	return userService.deleteUserById(userId);
    }
}
