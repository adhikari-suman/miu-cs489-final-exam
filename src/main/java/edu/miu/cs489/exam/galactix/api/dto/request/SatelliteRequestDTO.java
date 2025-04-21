package edu.miu.cs489.exam.galactix.api.dto.request;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record SatelliteRequestDTO(
        @NotNull(message = "name cannot be null.")
        @NotBlank(message = "name cannot be blank.")
        String name,

        @Past(message = "launchDate must be in the past.")
        LocalDate launchDate,

        @NotNull(message = "orbitType cannot be null.")
        @Pattern(regexp = "^(LEO|MEO|GEO)$", flags = Pattern.Flag.CASE_INSENSITIVE,
                 message = "Orbit type must be one of: LEO, MEO, GEO")
        String orbitType,

        @NotNull(message = "decommissioned cannot be null.")
        Boolean decommissioned) {
}
