package com.lumera.clinic_core_service.dto;

import jakarta.validation.constraints.NotBlank;

public record PatientRequest(
        @NotBlank(message = "El nombre es obligatorio") String firstName,
        @NotBlank(message = "El apellido es obligatorio") String lastName,
        @NotBlank(message = "El DNI es obligatorio") String dni,
        String phone,
        String healthInsurance
) {}