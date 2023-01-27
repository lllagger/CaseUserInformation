package com.intesasoft.userInformation.Repository;

import com.intesasoft.userInformation.Entity.MaxUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IMaxUserRepository extends JpaRepository<MaxUser, Integer> {

Optional<MaxUser> findByEmail(String userEmail);
}
