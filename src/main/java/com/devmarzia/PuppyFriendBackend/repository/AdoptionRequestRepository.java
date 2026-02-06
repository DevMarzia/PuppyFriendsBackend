package com.devmarzia.PuppyFriendBackend.repository;
import com.devmarzia.PuppyFriendBackend.entity.AdoptionRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdoptionRequestRepository extends JpaRepository<AdoptionRequest, Long> {}