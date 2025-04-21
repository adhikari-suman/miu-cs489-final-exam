package edu.miu.cs489.exam.galactix.api.error.astronaut;

public class AstronautNotFoundException extends RuntimeException {
    public AstronautNotFoundException(String message) {
        super(message);
    }
}
