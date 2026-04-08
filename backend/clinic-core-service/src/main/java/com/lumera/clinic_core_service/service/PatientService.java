package com.lumera.clinic_core_service.service;

import com.lumera.clinic_core_service.dto.PatientRequest;
import com.lumera.clinic_core_service.dto.PatientResponse;
import com.lumera.clinic_core_service.entity.Patient;
import com.lumera.clinic_core_service.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientResponse createPatient(PatientRequest request) {
        if (patientRepository.findByDni(request.dni()).isPresent()) {
            throw new IllegalArgumentException("El DNI ya existe");
        }

        Patient patient = Patient.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .dni(request.dni())
                .phone(request.phone())
                .healthInsurance(request.healthInsurance())
                .build();

        Patient savedPatient = patientRepository.save(patient);

        return mapToResponse(patientRepository.save(patient));
    }

    public List<PatientResponse> getAllPatients() {
        return patientRepository.findAll().stream()
                .map(patient -> new PatientResponse(
                        patient.getId(),
                        patient.getFirstName(),
                        patient.getLastName(),
                        patient.getDni(),
                        patient.getPhone(),
                        patient.getHealthInsurance()
                ))
                .toList();
    }

    public PatientResponse getPatientById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Paciente no encontrado"));

        return mapToResponse(patientRepository.save(patient));
    }

    public PatientResponse updatePatient(Long id, PatientRequest request) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Paciente no encontrado"));

        patient.setFirstName(request.firstName());
        patient.setLastName(request.lastName());
        patient.setPhone(request.phone());
        patient.setHealthInsurance(request.healthInsurance());

        Patient updatedPatient = patientRepository.save(patient);

        return mapToResponse(patientRepository.save(patient));
    }

    public void deletePatientById(Long id) {
        if (!patientRepository.existsById(id)) {
            throw new IllegalArgumentException("Paciente no encontrado");
        }
        patientRepository.deleteById(id);
    }

    private PatientResponse mapToResponse(Patient patient) {
        return new PatientResponse(
                patient.getId(),
                patient.getFirstName(),
                patient.getLastName(),
                patient.getDni(),
                patient.getPhone(),
                patient.getHealthInsurance()
        );
    }
}
