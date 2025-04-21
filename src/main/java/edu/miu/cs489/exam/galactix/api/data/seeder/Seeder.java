package edu.miu.cs489.exam.galactix.api.data.seeder;


import edu.miu.cs489.exam.galactix.api.model.Astronaut;
import edu.miu.cs489.exam.galactix.api.model.OrbitType;
import edu.miu.cs489.exam.galactix.api.model.Satellite;
import edu.miu.cs489.exam.galactix.api.repository.AstronautRepository;
import edu.miu.cs489.exam.galactix.api.repository.SatelliteRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Seeder {

    private final AstronautRepository astronautRepository;
    private final SatelliteRepository satelliteRepository;

    @PostConstruct
    public void seedData() {
        if (astronautRepository.count() == 0 && satelliteRepository.count() == 0) {
            // Satellites
            Satellite hubble = new Satellite(null, "Hubble", LocalDate.of(1990, 4, 24), OrbitType.LEO, false);
            Satellite starlink = new Satellite(null, "Starlink-17", LocalDate.of(2023, 8, 14), OrbitType.MEO, false);
            Satellite sentinel = new Satellite(null, "Sentinel-6", LocalDate.of(2020, 11, 21), OrbitType.LEO, true);

            satelliteRepository.saveAll(List.of(hubble, starlink, sentinel));

            // Astronauts
            Astronaut neil = new Astronaut(null, "Neil", "Armstrong", 12, List.of(hubble));
            Astronaut sally = new Astronaut(null, "Sally", "Ride", 8, List.of(starlink));
            Astronaut chris = new Astronaut(null, "Chris", "Hadfield", 15, List.of(hubble, sentinel));

            astronautRepository.saveAll(List.of(neil, sally, chris));
        }
    }
}

