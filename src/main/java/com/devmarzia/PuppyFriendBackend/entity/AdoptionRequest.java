package com.devmarzia.PuppyFriendBackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDateTime;

@Entity
@Table(name = "adoption_requests")
@Data
@EqualsAndHashCode(callSuper = true)
public class AdoptionRequest extends BaseEntity {

    @Column(nullable = false)
    private String status;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties({"password", "roles", "hibernateLazyInitializer"}) // Non stampare questi dati dell'utente
    private User user;

    @ManyToOne
    @JoinColumn(name = "animal_id", nullable = false)
    @JsonIgnoreProperties({"description", "hibernateLazyInitializer"}) // Non stampare troppa roba dell'animale
    private Animal animal;
}