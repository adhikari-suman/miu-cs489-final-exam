package edu.miu.cs489.exam.galactix.api.mapper;

import edu.miu.cs489.exam.galactix.api.dto.request.SatelliteRequestDTO;
import edu.miu.cs489.exam.galactix.api.dto.response.SatelliteResponseDTO;
import edu.miu.cs489.exam.galactix.api.model.Satellite;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SatelliteMapper {
    Satellite satelliteRequestDTOToSatellite(SatelliteRequestDTO satelliteRequestDTO);

    SatelliteResponseDTO satelliteToSatelliteResponseDTO(Satellite satellite);
}
