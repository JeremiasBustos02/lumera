package com.lumera.clinic_core_service.controller;

import com.lumera.clinic_core_service.dto.OfficeRequest;
import com.lumera.clinic_core_service.dto.OfficeResponse;
import com.lumera.clinic_core_service.service.OfficeService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/offices")
@RequiredArgsConstructor
public class OfficeController {

    private final OfficeService officeService;

    @PostMapping
    public ResponseEntity<OfficeResponse> createOffice(@Valid @RequestBody OfficeRequest request) {
        return ResponseEntity.ok(officeService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<OfficeResponse>> getOffice() {
        return ResponseEntity.ok(officeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OfficeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(officeService.getById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<OfficeResponse> update(@PathVariable Long id, @Valid @RequestBody OfficeRequest request) {
        return ResponseEntity.ok(officeService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        officeService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
