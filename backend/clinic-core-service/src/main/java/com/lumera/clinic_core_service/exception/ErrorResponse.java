package com.lumera.clinic_core_service.exception;

import java.time.LocalDateTime;

public record ErrorResponse(
        int status,
        String message,
        LocalDateTime timestamp,
        String path
) {}
