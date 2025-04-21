package edu.miu.cs489.exam.galactix.api.service.impl;

import edu.miu.cs489.exam.galactix.api.dto.request.SatelliteRequestDTO;
import edu.miu.cs489.exam.galactix.api.dto.response.SatelliteResponseDTO;
import edu.miu.cs489.exam.galactix.api.error.satellite.SatelliteDecommissionedException;
import edu.miu.cs489.exam.galactix.api.error.satellite.SatelliteNotFoundException;
import edu.miu.cs489.exam.galactix.api.mapper.SatelliteMapper;
import edu.miu.cs489.exam.galactix.api.model.Satellite;
import edu.miu.cs489.exam.galactix.api.repository.SatelliteRepository;
import edu.miu.cs489.exam.galactix.api.service.SatelliteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SatelliteServiceImpl implements SatelliteService {

    private final SatelliteRepository satelliteRepository;
    private final SatelliteMapper     satelliteMapper;

    @Override
    public SatelliteResponseDTO updateSatellite(Long id, SatelliteRequestDTO satelliteRequestDTO) {
        Satellite foundSatellite = satelliteRepository.findById(id).orElseThrow(
                () -> new SatelliteNotFoundException(String.format("Satellite with id %d not found", id))
                                                                         );

        if(foundSatellite.isDecommissioned()){
            throw new SatelliteDecommissionedException(String.format("Satellite with id %d is decommissioned", id));
        }

        Satellite modifiedSatellite = satelliteMapper.satelliteRequestDTOToSatellite(satelliteRequestDTO);
        modifiedSatellite.setId(id);

        Satellite updatedSatellite = satelliteRepository.save(modifiedSatellite);

        return satelliteMapper.satelliteToSatelliteResponseDTO(updatedSatellite);
    }
}
