package com.example.demo.repository;

import com.example.demo.entity.Appointment;
import com.example.demo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN false ELSE true END FROM Appointment a WHERE a.employeeId = :employeeId AND a.appointmentDate = :appointmentDate")
    boolean isEmployeeAvailable(@Param("employeeId") Long employeeId, @Param("appointmentDate") LocalDateTime appointmentDate);
}
