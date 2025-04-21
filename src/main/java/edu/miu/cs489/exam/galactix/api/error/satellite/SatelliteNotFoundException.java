package edu.miu.cs489.exam.galactix.api.error.satellite;

public class SatelliteNotFoundException extends RuntimeException {
    public SatelliteNotFoundException(String message) {
        super(message);
    }
}
