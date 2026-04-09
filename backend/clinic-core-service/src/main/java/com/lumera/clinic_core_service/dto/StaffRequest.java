package com.lumera.clinic_core_service.dto;

import com.lumera.clinic_core_service.entity.StaffRole;
import jakarta.validation.constraints.NotBlank;

public record StaffRequest(
        String firstName,
        String lastName,
        @NotBlank(message = "El Rol es obligatorio") StaffRole role,
        String licenseNumber,
        String specialty,
        @NotBlank(message = "El Email es obligatorio") String email,
        String phone
) {}