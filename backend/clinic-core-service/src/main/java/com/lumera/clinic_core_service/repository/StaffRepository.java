package com.lumera.clinic_core_service.repository;

import com.lumera.clinic_core_service.entity.Staff;
import com.lumera.clinic_core_service.entity.StaffRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
    Optional<Staff> findByLicenseNumber(String licenseNumber);
    Optional<Staff> findByEmail(String email);
    List<Staff> findByRole(StaffRole role);
    List<Staff> findBySpecialty(String specialty);
}