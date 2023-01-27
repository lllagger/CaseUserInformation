package com.intesasoft.userInformation.Controller;

import com.intesasoft.userInformation.Entity.MaxUser;
import com.intesasoft.userInformation.Service.MaxUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api("MaxUser API dokümantasyonu")
public class MaxUserController {

    @Autowired
    private MaxUserService maxUserService;
    @PostConstruct
    public void init(){
    }

    @GetMapping("/list/users")
    @ApiOperation(value = "Tüm kullanıcıların listesini getiren metot.", notes = "ADMIN rolündeki kullanıcıların, tüm kullanıcı bilgisini çeken endpoint.")
    public List<MaxUser> findAl() {
        log.info("Users listed.");
        return maxUserService.listUsers();
    }

    @PostMapping(value = "/register/user")
    @ApiOperation(value = "Kullanıcı kaydetme metodu.", notes = "JSON formatında DB ye kullanıcı kaydeden endpoint.")
    public String registerUser(@RequestBody @Validated @ApiParam(value = "maxUser") MaxUser maxUser){
        log.info("User added to DB.");
        return maxUserService.addUser(maxUser);
    }

    @GetMapping("/token/owner")
    @ApiOperation(value = "Token sahibi bilgisini getiren metot.", notes = "Token içerisine gizlenmiş olan kullanıcı bilgisini döndüren endpoint.")
    public String tokenUser(Principal principal){
        return "Token owner e-mail is: " + principal.getName();
    }
}

