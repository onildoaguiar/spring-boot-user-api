package com.onildoaguiar.userapi.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("/user/signIn")
    @ResponseBody
    public String signIn(){
        return "Hello Spring Boot!";
    }
}
