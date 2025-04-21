package edu.miu.cs489.exam.galactix.api.error;

import edu.miu.cs489.exam.galactix.api.dto.response.ApiErrorResponseDTO;
import edu.miu.cs489.exam.galactix.api.error.astronaut.AstronautNotFoundException;
import edu.miu.cs489.exam.galactix.api.error.satellite.SatelliteDecommissionedException;
import edu.miu.cs489.exam.galactix.api.error.satellite.SatelliteNotFoundException;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(AstronautNotFoundException.class)
    public ResponseEntity<ApiErrorResponseDTO> handleAstronautNotFoundException(AstronautNotFoundException e,
                                                                                HttpRequest request
                                                                                ) {
        ApiErrorResponseDTO errorResponse = new ApiErrorResponseDTO(
                Instant.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.name(),
                e.getMessage(),
                request.getURI().getPath()
        );


        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(SatelliteNotFoundException.class)
    public ResponseEntity<ApiErrorResponseDTO> handleSatelliteNotFoundException(SatelliteNotFoundException e,
                                                                                HttpRequest request
                                                                               ) {
        ApiErrorResponseDTO errorResponse = new ApiErrorResponseDTO(
                Instant.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.name(),
                e.getMessage(),
                request.getURI().getPath()
        );


        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(SatelliteDecommissionedException.class)
    public ResponseEntity<ApiErrorResponseDTO> handleSatelliteDecommissionedException(SatelliteDecommissionedException e,
                                                                                HttpRequest request
                                                                               ) {
        ApiErrorResponseDTO errorResponse = new ApiErrorResponseDTO(
                Instant.now(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.name(),
                e.getMessage(),
                request.getURI().getPath()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
