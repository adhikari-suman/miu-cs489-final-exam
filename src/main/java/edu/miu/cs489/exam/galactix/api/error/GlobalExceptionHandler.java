package edu.miu.cs489.exam.galactix.api.error;

import edu.miu.cs489.exam.galactix.api.dto.response.ApiErrorResponseDTO;
import edu.miu.cs489.exam.galactix.api.error.astronaut.AstronautNotFoundException;
import edu.miu.cs489.exam.galactix.api.error.satellite.DuplicateSatelliteException;
import edu.miu.cs489.exam.galactix.api.error.satellite.SatelliteDecommissionedException;
import edu.miu.cs489.exam.galactix.api.error.satellite.SatelliteNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
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
                                                                                HttpServletRequest request
                                                                                ) {
        ApiErrorResponseDTO errorResponse = new ApiErrorResponseDTO(
                Instant.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.name(),
                e.getMessage(),
                request.getRequestURI()
        );


        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(SatelliteNotFoundException.class)
    public ResponseEntity<ApiErrorResponseDTO> handleSatelliteNotFoundException(SatelliteNotFoundException e,
                                                                                HttpServletRequest request
                                                                               ) {
        ApiErrorResponseDTO errorResponse = new ApiErrorResponseDTO(
                Instant.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.name(),
                e.getMessage(),
                request.getRequestURI()
        );


        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(DuplicateSatelliteException.class)
    public ResponseEntity<ApiErrorResponseDTO> handleDuplicateSatelliteException(DuplicateSatelliteException e,
                                                                                HttpServletRequest request
                                                                               ) {
        ApiErrorResponseDTO errorResponse = new ApiErrorResponseDTO(
                Instant.now(),
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.name(),
                e.getMessage(),
                request.getRequestURI()
        );


        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }

    @ExceptionHandler(SatelliteDecommissionedException.class)
    public ResponseEntity<ApiErrorResponseDTO> handleSatelliteDecommissionedException(SatelliteDecommissionedException e,
                                                                                      HttpServletRequest request
                                                                               ) {
        ApiErrorResponseDTO errorResponse = new ApiErrorResponseDTO(
                Instant.now(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.name(),
                e.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
