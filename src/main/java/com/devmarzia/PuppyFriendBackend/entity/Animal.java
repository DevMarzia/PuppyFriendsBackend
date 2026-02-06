package com.devmarzia.PuppyFriendBackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode; // Importante per Lombok con ereditarietà
import java.time.LocalDate;

@Entity
@Table(name = "animals")
@Data
@EqualsAndHashCode(callSuper = true) // dice a Lombok di considerare anche l'ID del padre
public class Animal extends BaseEntity {

    @Column(nullable = false)
    private String name;

    private String breed;
    private int age;
    private LocalDate entryDate;
    private String imageUrl;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "size_id")
    private Size size;

    @OneToOne(mappedBy = "animal")
    @com.fasterxml.jackson.annotation.JsonIgnoreProperties("animal") // Evita loop infiniti
    private MedicalRecord medicalRecord;
}