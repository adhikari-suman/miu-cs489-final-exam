package edu.miu.cs489.exam.galactix.api.dto.request;

import jakarta.validation.constraints.*;


import java.util.List;

public record AstronautRequestDTO(
        @NotNull(message = "firstName cannot be null.")
        @NotBlank(message = "firstName cannot be blank.")
        @Size(min = 2, max = 20, message = "firstName must be between 2 and 20 characters.")
        String firstName,

        @NotNull(message = "lastName cannot be null.")
        @NotBlank(message = "lastName cannot be blank.")
        @Size(min = 2, max = 20, message = "lastName must be between 2 and 20 characters.")
        String lastName,

        @NotNull(message = "experienceYears cannot be null.")
        @Min(value = 0, message = "experienceYears must be greater than or equal to 0.")
        @Max(value = 50, message = "experienceYears must be less than or equal to 50.")
        int experienceYears,

        @NotNull(message = "satellites cannot be null.")
        List<Long> satelliteIds
) {
}
