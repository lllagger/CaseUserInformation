package com.intesasoft.userInformation;

import com.intesasoft.userInformation.Entity.LoginTracking;
import com.intesasoft.userInformation.Entity.MaxUser;
import com.intesasoft.userInformation.Service.LoginTrackingService;
import com.intesasoft.userInformation.Service.MaxUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import springfox.documentation.spring.web.plugins.DocumentationPluginsManager;
import springfox.documentation.spring.web.scanners.ApiDescriptionReader;
import springfox.documentation.spring.web.scanners.ApiListingScanner;
import springfox.documentation.spring.web.scanners.ApiModelReader;
import springfox.documentation.spring.web.scanners.ApiModelSpecificationReader;

import java.time.LocalDateTime;

@SpringBootApplication
public class UserInformationApplication {

    public static void main(String[] args) {
		SpringApplication.run(UserInformationApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(MaxUserService maxUserService, LoginTrackingService loginTrackingService){
        return args -> {
            maxUserService.addUser(new MaxUser(1, "Eduardo Morrowe", "ENGINEER", "123456789", "test@test", "ROLE_ADMIN"));
            maxUserService.addUser(new MaxUser(2, "Franny Sarfat", "LABOR", "123456789", "test2@test", "ROLE_USER"));
            maxUserService.addUser(new MaxUser(3, "Ray Boots", "MANAGER", "123456789", "test3@test", "ROLE_USER"));
            maxUserService.addUser(new MaxUser(4, "Basilio Wrintmore", "LABOR", "123456789", "test4@test", "ROLE_USER"));
            maxUserService.addUser(new MaxUser(5, "Rene Size", "MANAGER", "123456789", "test5@test", "ROLE_ADMIN"));
            loginTrackingService.addLoginTracking(new LoginTracking(1, LocalDateTime.parse("2022-05-25 09:54:13".replace(" ", "T")), "LOGIN"));
            loginTrackingService.addLoginTracking(new LoginTracking(2, LocalDateTime.parse("2022-05-26 10:54:13".replace(" ", "T")), "LOGOUT"));
            loginTrackingService.addLoginTracking(new LoginTracking(3, LocalDateTime.parse("2022-05-01 09:54:13".replace(" ", "T")), "LOGIN"));
            loginTrackingService.addLoginTracking(new LoginTracking(4, LocalDateTime.parse("2022-05-01 13:54:13".replace(" ", "T")), "LOGOUT"));
            loginTrackingService.addLoginTracking(new LoginTracking(5, LocalDateTime.parse("2022-05-13 13:54:13".replace(" ", "T")), "LOGIN"));
            loginTrackingService.addLoginTracking(new LoginTracking(6, LocalDateTime.parse("2022-05-13 18:54:13".replace(" ", "T")), "LOGOUT"));
            loginTrackingService.addLoginTracking(new LoginTracking(7, LocalDateTime.parse("2022-05-20 23:54:13".replace(" ", "T")), "LOGIN"));
            loginTrackingService.addLoginTracking(new LoginTracking(8, LocalDateTime.parse("2022-05-24 05:54:13".replace(" ", "T")), "LOGOUT"));
            loginTrackingService.addLoginTracking(new LoginTracking(9, LocalDateTime.parse("2022-05-25 13:54:13".replace(" ", "T")), "LOGIN"));
            loginTrackingService.addLoginTracking(new LoginTracking(10, LocalDateTime.parse("2022-05-25 14:54:13".replace(" ", "T")), "LOGOUT"));
            loginTrackingService.addLoginTracking(new LoginTracking(11, LocalDateTime.parse("2022-05-16 15:54:13".replace(" ", "T")), "LOGIN"));
            loginTrackingService.addLoginTracking(new LoginTracking(12, LocalDateTime.parse("2022-05-16 22:54:13".replace(" ", "T")), "LOGOUT"));
        };
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
