package com.intesasoft.userInformation.Controller;

import com.intesasoft.userInformation.Entity.MaxUser;
import com.intesasoft.userInformation.Service.MaxUserService;
import io.swagger.annotations.*;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
@CrossOrigin
public class MaxUserController{

    @Autowired
    private MaxUserService maxUserService;

    @GetMapping("/list/users")
    @ApiOperation(value = "Bu metot ADMIN rolüne sahip kullanıcıların, kulanıcı listesini JSON tabanlı olarak getirir.")
    public List<MaxUser> findAll() {
        log.info("Users listed.");
        return maxUserService.listUsers();
    }

    @PostMapping(value = "/register/user")
    @ApiOperation(value = "Bu metot veri tabanına kullanıcı kaydeder.")
    public String registerUser(@RequestBody MaxUser maxUser){
        log.info("User added to DB.");
        return maxUserService.addUser(maxUser);
    }

    @GetMapping("/token/owner")
    @ApiOperation(value = "Bu metod'a verilen 'Bearer <token>' sahibinin bilgilerini getirir.")
    public String tokenUser(Principal principal){
        return "Token owner e-mail is: " + principal.getName();
    }
}

