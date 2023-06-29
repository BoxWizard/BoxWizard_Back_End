package com.box.wizard.controller;

import com.box.wizard.domain.user.User;
import com.box.wizard.dto.user.JwtReq;
import com.box.wizard.dto.user.UserJoinDTO;
import com.box.wizard.dto.user.UserLoginDTO;
import com.box.wizard.repository.user.UserRepository;
import com.box.wizard.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boxwizard/user")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    @Autowired
    private UserRepository userRepository;

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

    @GetMapping("/idcheck")
    public ResponseEntity<String> getIdCheck(@RequestBody String userID) {

        boolean result = userService.IdCheck(userID);

        if(result) {
            return ResponseEntity.badRequest().body("사용중인 아이디입니다.");
        }

        return ResponseEntity.ok("사용 가능한 아이디입니다.");
    }

    @PostMapping("/login")
    public ResponseEntity<JwtReq> Login (@RequestBody UserLoginDTO userLoginDTO) {



        JwtReq jwtReq = userService.Login(userLoginDTO);

        if(jwtReq == null) {
            return ResponseEntity.badRequest().body(null);
        }

        return ResponseEntity.ok().body(jwtReq);
    }

    @GetMapping("/info")
    public ResponseEntity<List<User>> findUser() {
        return ResponseEntity.ok().body(userRepository.findAll());
    }
}
