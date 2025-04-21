package edu.miu.cs489.exam.galactix.api.dto.response;

import java.util.List;

public record AstronautResponseDTO(
        Long id,
        String firstName,
        String lastName,
        int experienceYears,
        List<SatelliteResponseDTO> satellites
) {
}
