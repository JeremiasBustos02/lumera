package com.lumera.clinic_core_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "staff")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StaffRole role;

    @Column(unique = true)
    private String licenseNumber; // Opcional (solo para Doctores/Enfermeras)

    private String specialty; // Opcional (ej: "Pediatría" o "Recepción")

    @Column(unique = true, nullable = false)
    private String email;

    private String phone;
}
