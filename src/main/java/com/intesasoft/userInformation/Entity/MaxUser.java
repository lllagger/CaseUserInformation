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
@ApiModel(value = "MaxUser nesnesi", description = "Kullanıcı bilgilerinin tutulduğu entity")
public class MaxUser {
    @Id
    @Column(name = "userid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "MaxUser Id alanı")
    private int id;
    @Column(name = "name")
    @ApiModelProperty(value = "MaxUser name alanı")
    private String name;
    @Column(name = "type")
    @ApiModelProperty(value = "MaxUser type alanı")
    private String type;
    @Column(name = "password")
    @ApiModelProperty(value = "MaxUser password alanı")
    private String password;
    @Column(name = "email", unique = true)
    @Email(message = "{Invalid email. Try again}")
    @ApiModelProperty(value = "MaxUser e-mail alanı")
    private String email;
    @Column(name = "role")
    @ApiModelProperty(value = "MaxUser role alanı")
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
