package com.lumera.clinic_core_service.service;

import com.lumera.clinic_core_service.dto.StaffRequest;
import com.lumera.clinic_core_service.dto.StaffResponse;
import com.lumera.clinic_core_service.entity.Staff;
import com.lumera.clinic_core_service.entity.StaffRole;
import com.lumera.clinic_core_service.repository.StaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StaffService {

    private final StaffRepository staffRepository;

    public StaffResponse createStaff(StaffRequest request) {
        if (staffRepository.findByEmail(request.email()).isPresent()) {
            throw new IllegalArgumentException("El email ya está registrado");
        }

        if ((request.role() == StaffRole.DOCTOR || request.role() == StaffRole.NURSE)
                && (request.licenseNumber() == null || request.licenseNumber().isEmpty())) {
            throw new IllegalArgumentException("Médicos y enfermeras deben tener matrícula");
        }

        Staff staff = Staff.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .role(request.role())
                .licenseNumber(request.licenseNumber())
                .specialty(request.specialty())
                .email(request.email())
                .phone(request.phone())
                .build();

        return mapToResponse(staffRepository.save(staff));
    }

    public List<StaffResponse> getStaffByRole(StaffRole role) {
        return staffRepository.findByRole(role).stream()
                .map(this::mapToResponse)
                .toList();
    }

    public List<StaffResponse> getAllStaff() {
        return staffRepository.findAll().stream()
                .map(this::mapToResponse)
                .toList();
    }

    public StaffResponse updateStaff(Long id, StaffRequest request) {
        Staff staff = staffRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Personal no encontrado"));

        staff.setFirstName(request.firstName());
        staff.setLastName(request.lastName());
        staff.setRole(request.role());
        staff.setLicenseNumber(request.licenseNumber());
        staff.setSpecialty(request.specialty());
        staff.setEmail(request.email());
        staff.setPhone(request.phone());

        return mapToResponse(staffRepository.save(staff));
    }

    public void deleteStaffById(Long id) {
        if (!staffRepository.existsById(id)) {
                throw new IllegalArgumentException("Personal no encontrado");
        }
        staffRepository.deleteById(id);
    }

    private StaffResponse mapToResponse(Staff staff) {
        return new StaffResponse(
                staff.getId(),
                staff.getFirstName(),
                staff.getLastName(),
                staff.getRole(),
                staff.getLicenseNumber(),
                staff.getSpecialty(),
                staff.getEmail(),
                staff.getPhone()
        );
    }
}
