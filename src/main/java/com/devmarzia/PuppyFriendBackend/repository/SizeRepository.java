package com.devmarzia.PuppyFriendBackend.repository;

import com.devmarzia.PuppyFriendBackend.entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// <Size, Long> equivale a dire che: "Gestisco entità di tipo Size che hanno un ID di tipo Long"

public interface SizeRepository extends JpaRepository<Size, Long> {
    Optional<Size> findByLabel(String label);
}