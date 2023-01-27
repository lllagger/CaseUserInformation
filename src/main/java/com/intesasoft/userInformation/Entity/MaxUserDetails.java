package com.intesasoft.userInformation.Entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MaxUserDetails implements UserDetails {
    private String userEmail;
    private String userPassword;
    private List<GrantedAuthority> authorities;

    public MaxUserDetails(MaxUser maxUser) {
        this.userEmail = maxUser.getEmail();
        this.userPassword = maxUser.getPassword();
        this.authorities = Arrays.stream(maxUser.getRole().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
    @JsonCreator
    public MaxUserDetails(
            @JsonProperty("userEmail") String userEmail,
            @JsonProperty("userPassword") String userPassword,
            @JsonProperty("authorities") List<GrantedAuthority> authorities) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return userPassword;
    }

    @Override
    public String getUsername() {
        return userEmail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
