package edu.miu.cs489.exam.galactix.api.controller;

import edu.miu.cs489.exam.galactix.api.dto.request.SatelliteRequestDTO;
import edu.miu.cs489.exam.galactix.api.dto.response.SatelliteResponseDTO;
import edu.miu.cs489.exam.galactix.api.service.SatelliteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/satellites")
@RequiredArgsConstructor
public class SatelliteController {

    private final SatelliteService satelliteService;

    @PutMapping("/{satelliteId}")
    public ResponseEntity<SatelliteResponseDTO> updateSatellite(
             @PathVariable("satelliteId") Long id,
            @Validated @RequestBody
            SatelliteRequestDTO satelliteRequestDTO) {
       SatelliteResponseDTO satelliteResponseDTO = satelliteService.updateSatellite(id, satelliteRequestDTO);

       return ResponseEntity.ok(satelliteResponseDTO);
    }
}
