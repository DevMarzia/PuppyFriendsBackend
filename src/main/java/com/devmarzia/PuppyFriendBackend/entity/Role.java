package com.devmarzia.PuppyFriendBackend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "roles")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    public enum RoleType {
        ROLE_ADMIN,
        ROLE_VOLUNTEER, // Veterinario o Volontario
        ROLE_ADOPTER
    }
}