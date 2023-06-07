package com.miniproject.unislo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miniproject.unislo.dto.UserDto;
import com.miniproject.unislo.entity.UserEntity;
import com.miniproject.unislo.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user") //url 앞에 자동으로 user 붙여줌
@RestController
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping(value = "/join-proc")
    public String userJoinForm(@RequestBody UserDto userDto){
        System.out.println(userDto);
        UserEntity userEntity = UserEntity.toUserEntity(userDto, passwordEncoder);
        userService.saveUser(userEntity);

        return "redirect:/";
    }
}
