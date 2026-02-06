package com.devmarzia.PuppyFriendBackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDate;

@Entity
@Table(name = "vet_visits")
@Data
@EqualsAndHashCode(callSuper = true)
public class VetVisit extends BaseEntity {

    private LocalDate visitDate;

    private String vetName;
    private String diagnosis; // Es. "Tutto ok", "Otite"
    private double cost; // Costo della visita

    @ManyToOne
    @JoinColumn(name = "medical_record_id")
    private MedicalRecord medicalRecord;
}