package com.intesasoft.userInformation.Service;

import com.intesasoft.userInformation.Entity.LoginTracking;
import com.intesasoft.userInformation.Repository.ILoginTrackingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginTrackingService {

    private ILoginTrackingRepository ILoginTrackingRepository;

    public LoginTrackingService(ILoginTrackingRepository ILoginTrackingRepository) {
        this.ILoginTrackingRepository = ILoginTrackingRepository;
    }

    public String addLoginTracking(LoginTracking loginTracking){
        ILoginTrackingRepository.save(loginTracking);
        log.info("Add login tracking service working.");
        return loginTracking.getId() + " id numaralı giriş zaman bilgisi veri tabanına eklendi";
    }
}
