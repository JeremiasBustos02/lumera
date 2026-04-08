package com.lumera.clinic_core_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "patients")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @Column(unique = true, nullable = false)
    private String dni;

    private String phone;
    private String healthInsurance;
}