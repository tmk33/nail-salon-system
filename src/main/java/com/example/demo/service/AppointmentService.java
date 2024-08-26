package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.*;
import com.example.demo.entity.*;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }


    public boolean isEmployeeAvailable(long id, LocalDateTime appointmentDate) {
        return appointmentRepository.isEmployeeAvailable(id, appointmentDate);
    }
}