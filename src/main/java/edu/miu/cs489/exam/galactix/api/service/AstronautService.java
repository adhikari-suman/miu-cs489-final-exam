package edu.miu.cs489.exam.galactix.api.service;

import edu.miu.cs489.exam.galactix.api.dto.request.AstronautRequestDTO;
import edu.miu.cs489.exam.galactix.api.dto.response.AstronautResponseDTO;
import org.springframework.data.domain.Page;

public interface AstronautService {
    AstronautResponseDTO addAstronaut(AstronautRequestDTO request);

    Page<AstronautResponseDTO> getAllAstronauts(String sortBy, String sortOrder, int page, int size);
}
