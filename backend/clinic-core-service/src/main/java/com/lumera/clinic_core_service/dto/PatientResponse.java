package com.lumera.clinic_core_service.dto;

public record PatientResponse(
        Long id,
        String firstName,
        String lastName,
        String dni,
        String phone,
        String healthInsurance
) {}
