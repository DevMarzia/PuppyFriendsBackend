package com.devmarzia.PuppyFriendBackend.payload;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

@Data
public class AdoptionRequestDto {
    @NotNull(message = "Devi specificare quale animale vuoi adottare")
    private Long animalId;

    private String notes; // Es: "bravo con i gatti... "
}