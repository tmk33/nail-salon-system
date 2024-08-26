package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.*;
import com.example.demo.entity.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @PostMapping
    public ResponseEntity<Object> createAppointment(@RequestBody Map<String, Object> request) {
        // Lấy thông tin từ request body
        Long customerId = Long.parseLong(request.get("customer_id").toString());
        Long serviceId = Long.parseLong(request.get("service_id").toString());
        LocalDateTime appointmentDate = LocalDateTime.parse(request.get("appointment_date").toString());

        // Tìm một nhân viên khả dụng vào thời điểm đó (Bạn cần thêm logic này)
        List<Employee> employees = employeeService.findAllOrderByAppointmentCountAsc();

        for (Employee employee : employees) {
            // Kiểm tra xem nhân viên có rảnh vào thời điểm đó không
            boolean isAvailable = appointmentService.isEmployeeAvailable(employee.getId(), appointmentDate);

            if (isAvailable) {
                // Tạo đối tượng Appointment mới
                Appointment appointment = new Appointment();
                appointment.setCustomerId(customerId);
                appointment.setServiceId(serviceId);
                appointment.setAppointmentDate(appointmentDate);
                appointment.setStatus("unconfirmed");
                appointment.setEmployeeId(employee.getId());
                Employee employee1 = employeeService.getEmployeeById(employee.getId()).orElseThrow(() -> new RuntimeException("Employee not found"));
                employee1.setNumberofappointment(employee1.getNumberofappointment() + 1);
                employeeService.updateEmployee(employee);

                return ResponseEntity.ok(appointmentService.createAppointment(appointment));
            }
        }

        // Không tìm thấy nhân viên khả dụng
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Error: Full Appointment!!");

    }
}
