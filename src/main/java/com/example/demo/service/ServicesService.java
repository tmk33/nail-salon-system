package com.example.demo.service;

import com.example.demo.entity.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.*;

import java.util.List;

@Service
public class ServicesService {

    @Autowired
    private ServicesRepository servicesRepository;

    public List<Services> getAllServices() {
        return servicesRepository.findAll();
    }

    public Services createService(Services service) {
        return servicesRepository.save(service);
    }
}
