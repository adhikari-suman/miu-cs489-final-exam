package edu.miu.cs489.exam.galactix.api.service.impl;

import edu.miu.cs489.exam.galactix.api.dto.request.AstronautRequestDTO;
import edu.miu.cs489.exam.galactix.api.dto.response.AstronautResponseDTO;
import edu.miu.cs489.exam.galactix.api.error.satellite.SatelliteNotFoundException;
import edu.miu.cs489.exam.galactix.api.mapper.AstronautMapper;
import edu.miu.cs489.exam.galactix.api.model.Astronaut;
import edu.miu.cs489.exam.galactix.api.model.Satellite;
import edu.miu.cs489.exam.galactix.api.repository.AstronautRepository;
import edu.miu.cs489.exam.galactix.api.repository.SatelliteRepository;
import edu.miu.cs489.exam.galactix.api.service.AstronautService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AstronautServiceImpl implements AstronautService {

    private final AstronautRepository astronautRepository;
    private final SatelliteRepository satelliteRepository;
    private final AstronautMapper     astronautMapper;

    @Override
    public AstronautResponseDTO addAstronaut(AstronautRequestDTO astronautRequestDTO) {
        List<Satellite> satellites = new ArrayList<>();

        for (Long id : astronautRequestDTO.satelliteIds()) {
            satellites.add(satelliteRepository.findById(id).orElseThrow(
                    () -> new SatelliteNotFoundException(
                            String.format("Satellite with id %d not found", id))));
        }

        Astronaut astronaut = astronautMapper.astronautRequestDTOToAstronaut(astronautRequestDTO);
        astronaut.setSatellites(satellites);

        Astronaut savedAstronaut = astronautRepository.save(astronaut);
        return astronautMapper.astronautToAstronautResponseDTO(savedAstronaut);

    }

    @Override
    public Page<AstronautResponseDTO> getAllAstronauts(String sortBy, String sortOrder, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortOrder), sortBy));

        return astronautRepository.findAll(pageRequest).map(astronautMapper::astronautToAstronautResponseDTO);
    }
}
