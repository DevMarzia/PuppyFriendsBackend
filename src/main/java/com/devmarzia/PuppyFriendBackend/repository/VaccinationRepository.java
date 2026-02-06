package com.devmarzia.PuppyFriendBackend.repository;
import com.devmarzia.PuppyFriendBackend.entity.Vaccination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccinationRepository extends JpaRepository<Vaccination, Long> {}