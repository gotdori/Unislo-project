package com.miniproject.unislo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String join(@RequestBody UserDto userDto){
        UserEntity userEntity = UserEntity.toUserEntity(userDto, passwordEncoder);
        userService.saveUser(userEntity);

        return "redirect:/";
    }

    // @PostMapping(value = "/id-check")
    // public String idCheck(@RequestBody UserDto userDto){
    //     UserEntity userEntity = UserEntity.toUserEntity(userDto, passwordEncoder);
    //     String result = userService.validuteDuplicateUser(userEntity);
    //     return result;
    // }
    @PostMapping(value = "/id-check")
    HashMap<String, Object> idCheck(@RequestBody UserDto userDto){
        UserEntity userEntity = UserEntity.toUserEntity(userDto, passwordEncoder);
        HashMap map = new HashMap<>();
        map.put("result", userService.validuteDuplicateUser(userEntity));
        return map;
    }
}
