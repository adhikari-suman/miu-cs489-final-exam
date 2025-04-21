package edu.miu.cs489.exam.galactix.api.controller;

import edu.miu.cs489.exam.galactix.api.dto.response.AstronautResponseDTO;
import edu.miu.cs489.exam.galactix.api.service.AstronautService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/astronauts")
@RequiredArgsConstructor
public class AstronautController {

    private final AstronautService astronautService;


    @GetMapping()
    public ResponseEntity<Page<AstronautResponseDTO>> getAllAstronauts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "firstName", name = "sort") String sortBy,
            @RequestParam(defaultValue = "ASC", name = "order") String sortOrder

                                                                      ) {
        Page<AstronautResponseDTO> astronauts = astronautService.getAllAstronauts(sortBy, sortOrder, page, size);

        return ResponseEntity.ok(astronauts);
    }
}
