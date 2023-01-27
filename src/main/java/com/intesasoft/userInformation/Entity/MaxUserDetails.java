package com.intesasoft.userInformation.Entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.intesasoft.userInformation.Service.Utils.CustomAuthorityDeserializer;
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
    private List<GrantedAuthority> zauthorities;

    public MaxUserDetails(MaxUser maxUser) {
        this.userEmail = maxUser.getEmail();
        this.userPassword = maxUser.getPassword();
        this.zauthorities = Arrays.stream(maxUser.getRole().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @JsonCreator
    public MaxUserDetails(
            @JsonProperty("userEmail") String userEmail,
            @JsonProperty("userPassword") String userPassword) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    @Override
    @JsonDeserialize(using = CustomAuthorityDeserializer.class)
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return zauthorities;
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
