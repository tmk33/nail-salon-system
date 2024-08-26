package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.*;
import com.example.demo.entity.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServicesController {

    @Autowired
    private ServicesService servicesService;

    @GetMapping
    public List<Services> getAllServices() {
        return servicesService.getAllServices();
    }

    @PostMapping
    public Services createService(@RequestBody Services service) {
        return servicesService.createService(service);
    }
}