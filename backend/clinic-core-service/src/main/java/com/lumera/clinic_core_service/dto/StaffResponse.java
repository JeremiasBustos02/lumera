package com.lumera.clinic_core_service.dto;

import com.lumera.clinic_core_service.entity.StaffRole;

public record StaffResponse(
    Long id,
    String firstName,
    String lastName,
    StaffRole role,
    String licenseNumber,
    String specialty,
    String email,
    String phone
) {}