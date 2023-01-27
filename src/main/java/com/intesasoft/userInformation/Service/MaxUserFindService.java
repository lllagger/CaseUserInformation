package com.intesasoft.userInformation.Service;

import com.intesasoft.userInformation.Entity.MaxUser;
import com.intesasoft.userInformation.Entity.MaxUserDetails;
import com.intesasoft.userInformation.Repository.IMaxUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MaxUserFindService implements UserDetailsService {
    @Autowired
    IMaxUserRepository iMaxUserRepository;

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {

        Optional<MaxUser> maxUser = iMaxUserRepository.findByEmail(userEmail);
        maxUser.orElseThrow(() -> new UsernameNotFoundException("user didn't found" + userEmail));
        return maxUser.map(MaxUserDetails::new).get();
    }


}