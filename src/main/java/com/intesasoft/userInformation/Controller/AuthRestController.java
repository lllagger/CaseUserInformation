package com.intesasoft.userInformation.Controller;


import com.intesasoft.userInformation.Entity.MaxUserDetails;
import com.intesasoft.userInformation.Service.JwtUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthRestController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/login")
    @ApiOperation(value = "Kullanıcı login metodu.", notes = "Kullanıcının token bilgisini geri döndüren metod.")
    public String creteToken(@RequestBody @ApiParam(value = "maxUserDetails") MaxUserDetails maxUserDetails) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(maxUserDetails.getUsername(), maxUserDetails.getPassword()));
        } catch (BadCredentialsException ex) {
            throw new Exception("Incorrect username or password", ex);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(maxUserDetails.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        return "Bearer " + jwt;
    }
}
