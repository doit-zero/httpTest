package http.httptest.controller;

import http.httptest.dto.User;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping()
public class UserController {

    @PostMapping("/signup")
    public String signup(@RequestBody User user){
        System.out.println("user는 : " + user);
        return user.toString();
    }
    @PostMapping
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        log.info("user data = " + user);
        return ResponseEntity.status(HttpStatus.CREATED).body("회원가입 성공!");
    }

    @ToString
    @AllArgsConstructor
    static class User{
        private String email;
        private String pwd;

    }
}
