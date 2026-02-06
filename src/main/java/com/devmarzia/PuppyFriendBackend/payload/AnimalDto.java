package com.devmarzia.PuppyFriendBackend.payload;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AnimalDto {
    @NotBlank(message = "Il nome è obbligatorio")
    private String name;

    @NotBlank(message = "La razza è obbligatoria")
    private String breed;

    @NotNull(message = "L'età è obbligatoria")
    @Min(value = 0, message = "L'età non può essere negativa")
    private Integer age;

    private LocalDate entryDate; // usa la data odierna

    private String imageUrl; // Uso Cloudinary

    @NotBlank(message = "Lo stato è obbligatorio (es. DISPONIBILE)")
    private String status;

    @NotBlank(message = "La taglia è obbligatoria (Piccola, Media, Grande)")
    private String sizeLabel;
}