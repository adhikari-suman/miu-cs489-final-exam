package edu.miu.cs489.exam.galactix.api.error.satellite;

public class DuplicateSatelliteException extends RuntimeException{
    public DuplicateSatelliteException(String message) {
        super(message);
    }
}
