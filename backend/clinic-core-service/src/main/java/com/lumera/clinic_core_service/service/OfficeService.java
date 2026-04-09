package com.lumera.clinic_core_service.service;

import com.lumera.clinic_core_service.dto.OfficeRequest;
import com.lumera.clinic_core_service.dto.OfficeResponse;
import com.lumera.clinic_core_service.entity.Office;
import com.lumera.clinic_core_service.repository.OfficeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OfficeService {
    private final OfficeRepository officeRepository;

    public OfficeResponse create(OfficeRequest req) {
        Office office = Office.builder()
                .number(req.number()).floor(req.floor()).description(req.description())
                .build();
        return mapToResponse(officeRepository.save(office));
    }

    public List<OfficeResponse> getAll() {
        return officeRepository.findAll().stream().map(this::mapToResponse).toList();
    }

    public OfficeResponse getById(Long id) {
        Office office = officeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Lugar no encontrado"));
        return mapToResponse(office);
    }

    public OfficeResponse update(Long id, OfficeRequest req) {
        Office office = officeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Lugar no encontrado"));

        office.setNumber(req.number());
        office.setFloor(req.floor());
        office.setDescription(req.description());

        return mapToResponse(officeRepository.save(office));
    }

    public void delete(Long id) {
        if (!officeRepository.existsById(id)) {
            throw new IllegalArgumentException("Lugar no encontrado");
        }
        officeRepository.deleteById(id);
    }

    private OfficeResponse mapToResponse(Office o) {
        return new OfficeResponse(o.getId(), o.getNumber(), o.getFloor(), o.getDescription());
    }
}
