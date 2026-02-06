package com.devmarzia.PuppyFriendBackend.repository;

//aggiungo qualche filtro

import com.devmarzia.PuppyFriendBackend.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
    // Trova animali per status (es. DISPONIBILE)
    List<Animal> findByStatus(String status);

    // Trova animali per taglia e status
    List<Animal> findBySize_LabelAndStatus(String sizeLabel, String status);
    List<Animal> findBySize_Label(String label);
}