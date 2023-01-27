package com.intesasoft.userInformation.Entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "MAXUSER")
@Data
public class MaxUser {
    @Id
    @Column(name = "userid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "password")
    private String password;
    @Column(name = "email", unique = true)
    @Email(message = "{Invalid email. Try again}")
    private String email;
    @Column(name = "role")
    private String role;
    public MaxUser() {
    }

    public MaxUser(int id, String name, String type, String password, String email, String userRole) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.password = password;
        this.email = email;
        this.role = userRole;
    }
}
