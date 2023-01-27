package com.intesasoft.userInformation.Service;

import com.intesasoft.userInformation.Entity.MaxUser;
import com.intesasoft.userInformation.Repository.IMaxUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MaxUserService {
    private IMaxUserRepository iMaxUserRepository;

    private PasswordEncoder passwordEncoder;

    public MaxUserService(IMaxUserRepository iMaxUserRepository, PasswordEncoder passwordEncoder) {
        this.iMaxUserRepository = iMaxUserRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<MaxUser> listUsers() {
        log.info("List Users service working.");
        return iMaxUserRepository.findAll();
    }

    public String addUser(MaxUser maxUser) {
        if (maxUser.getPassword().length() < 8 || maxUser.getPassword().length() > 16) {
            System.out.println("Şifre 8 haneden küçük ve 16 haneden büyük olamaz");
        } else {
            String encodedPassword = this.passwordEncoder.encode(maxUser.getPassword());
            maxUser.setPassword(encodedPassword);
            this.iMaxUserRepository.save(maxUser);
            log.info("Add user service working.");
        }
        return maxUser.getId() + " Id numaralı " + maxUser.getName() + " isimli kullanıcı, " + maxUser.getEmail() + " e-posta ile sisteme kaydedilmiştir.";
    }

    public MaxUser getUserById(Integer id) {
        return iMaxUserRepository.findById(id).get();
    }
}
