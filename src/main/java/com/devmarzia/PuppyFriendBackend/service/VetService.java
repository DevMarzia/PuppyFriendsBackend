package com.devmarzia.PuppyFriendBackend.service;

import com.devmarzia.PuppyFriendBackend.entity.*;
import com.devmarzia.PuppyFriendBackend.exception.ResourceNotFoundException;
import com.devmarzia.PuppyFriendBackend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VetService {

    @Autowired private MedicalRecordRepository medicalRecordRepository;
    @Autowired private AnimalRepository animalRepository;
    @Autowired private VaccinationRepository vaccinationRepository;

    // 1. Creo la cartella clinica per un animale
    public MedicalRecord createMedicalRecord(Long animalId, MedicalRecord recordData) {
        Animal animal = animalRepository.findById(animalId)
                .orElseThrow(() -> new ResourceNotFoundException("Animale non trovato"));

        if (animal.getMedicalRecord() != null) {
            throw new RuntimeException("Questo animale ha già una cartella clinica! Usa l'endpoint di aggiornamento (PUT) o cambia animale.");
        }

        recordData.setAnimal(animal);
        return medicalRecordRepository.save(recordData);
    }

    // 2. Aggiungo un vaccino
    public Vaccination addVaccine(Long medicalRecordId, Vaccination vaccine) {
        MedicalRecord record = medicalRecordRepository.findById(medicalRecordId)
                .orElseThrow(() -> new ResourceNotFoundException("Cartella clinica non trovata"));

        vaccine.setMedicalRecord(record);
        return vaccinationRepository.save(vaccine);
    }

    // 3. Leggo tutto (Cartella + Vaccini + Visite)
    public MedicalRecord getMedicalRecordByAnimal(Long animalId) {
        // Cercho la cartella associata a quell'animale
        return medicalRecordRepository.findAll().stream()
                .filter(m -> m.getAnimal().getId().equals(animalId))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Nessuna cartella clinica per questo animale"));
    }

    // 4.Visita Veterinaria
    @Autowired private VetVisitRepository vetVisitRepository;
    public VetVisit addVisit(Long medicalRecordId, VetVisit visit) {
        MedicalRecord record = medicalRecordRepository.findById(medicalRecordId)
                .orElseThrow(() -> new ResourceNotFoundException("Cartella clinica non trovata"));

        visit.setMedicalRecord(record);
        return vetVisitRepository.save(visit);
    }
}