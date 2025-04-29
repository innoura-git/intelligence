package com.innoura.Intelligence.Service;

import com.innoura.Intelligence.Entity.ServiceDetails;
///import com.innoura.Intelligence.Repository.ServiceDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntelligenceService
{

///    @Autowired
///    private ServiceDetailsRepository serviceDetailsRepository;

    public void saveServiceDetails(String url, String userName, String serviceName){
        ServiceDetails serviceDetails = new ServiceDetails();
        serviceDetails.setUrl(url);
        serviceDetails.setUserName(userName);
        serviceDetails.setServiceName(serviceName);
        ///serviceDetailsRepository.save(serviceDetails);
    }

    public List<ServiceDetails> checkUserService(String userName){
        ///List<ServiceDetails> userServices = serviceDetailsRepository.findByUserName(userName);
        ///return userService;
        return null;
    }
}
