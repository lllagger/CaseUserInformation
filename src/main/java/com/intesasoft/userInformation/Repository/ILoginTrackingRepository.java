package com.intesasoft.userInformation.Repository;

import com.intesasoft.userInformation.Entity.LoginTracking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILoginTrackingRepository extends JpaRepository<LoginTracking, Integer> {
}
