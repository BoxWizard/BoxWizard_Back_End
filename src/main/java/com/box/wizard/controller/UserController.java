package com.box.wizard.controller;

import com.box.wizard.dto.user.UserJoinDTO;
import com.box.wizard.dto.user.UserLoginDTO;
import com.box.wizard.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/boxwizard/user")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {this.userService = userService;}

    @PostMapping("/join")
    public ResponseEntity Join (@RequestBody UserJoinDTO userJoinDTO) {

        boolean result = userService.Join(userJoinDTO);

        if(!result) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(HttpStatus.CREATED);
    }

//    @GetMapping("/login")
//    public ResponseEntity<String> Login (@RequestBody UserLoginDTO userLoginDTO) {
//
//
//
//        return ResponseEntity.ok().body(token);
//    }

}
