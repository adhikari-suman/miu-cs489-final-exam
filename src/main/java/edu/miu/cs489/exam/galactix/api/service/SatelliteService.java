package edu.miu.cs489.exam.galactix.api.service;

import edu.miu.cs489.exam.galactix.api.dto.request.SatelliteRequestDTO;
import edu.miu.cs489.exam.galactix.api.dto.response.SatelliteResponseDTO;

public interface SatelliteService {
    SatelliteResponseDTO updateSatellite(Long id, SatelliteRequestDTO satelliteRequestDTO);
}
