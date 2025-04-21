package edu.miu.cs489.exam.galactix.api.mapper;

import edu.miu.cs489.exam.galactix.api.dto.request.AstronautRequestDTO;
import edu.miu.cs489.exam.galactix.api.dto.response.AstronautResponseDTO;
import edu.miu.cs489.exam.galactix.api.model.Astronaut;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AstronautMapper {

    // Not needed, added for future references only
    @Mapping(
            source = "satellites",
            target = "satellites"
    )
    AstronautResponseDTO astronautToAstronautResponseDTO(Astronaut astronaut);

    Astronaut astronautRequestDTOToAstronaut(AstronautRequestDTO astronautRequestDTO);
}
