package com.lumera.clinic_core_service.controller;

import com.lumera.clinic_core_service.dto.StaffRequest;
import com.lumera.clinic_core_service.dto.StaffResponse;
import com.lumera.clinic_core_service.entity.StaffRole;
import com.lumera.clinic_core_service.service.StaffService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
@RequiredArgsConstructor
public class StaffController {

    private final StaffService staffService;

    @PostMapping
    public ResponseEntity<StaffResponse> create(@RequestBody StaffRequest request) {
        return new ResponseEntity<>(staffService.createStaff(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<StaffResponse>> getStaff(@RequestParam(required = false) StaffRole role) {
        if (role != null) {
            return ResponseEntity.ok(staffService.getStaffByRole(role));
        }
        return ResponseEntity.ok(staffService.getAllStaff());
    }

    @PutMapping("/{id}")
    public ResponseEntity<StaffResponse> update(@PathVariable Long id, @Valid @RequestBody StaffRequest request) {
        return ResponseEntity.ok(staffService.updateStaff(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StaffResponse> delete(@PathVariable Long id) {
        staffService.deleteStaffById(id);
        return ResponseEntity.noContent().build();
    }
}
