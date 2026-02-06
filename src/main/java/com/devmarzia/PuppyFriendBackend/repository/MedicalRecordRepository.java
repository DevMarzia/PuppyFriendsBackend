package com.devmarzia.PuppyFriendBackend.repository;
import com.devmarzia.PuppyFriendBackend.entity.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {}