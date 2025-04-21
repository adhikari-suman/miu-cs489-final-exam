package edu.miu.cs489.exam.galactix.api.dto.response;

import java.time.Instant;

public record ApiErrorResponseDTO(
        Instant timestamp,
        int status,
        String error,
        String message,
        String path
) {
}


