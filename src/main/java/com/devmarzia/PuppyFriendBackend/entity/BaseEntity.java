package com.devmarzia.PuppyFriendBackend.entity;

// superclasse ereditarietà

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass // dice che i campi vanno nelle tabelle dei figli
@Getter
@Setter
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}