package com.devmarzia.PuppyFriendBackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "sizes")
@Data
@EqualsAndHashCode(callSuper = true)
public class Size extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String label;
}