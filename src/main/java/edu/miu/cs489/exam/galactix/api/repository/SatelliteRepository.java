package edu.miu.cs489.exam.galactix.api.repository;

import edu.miu.cs489.exam.galactix.api.model.Satellite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SatelliteRepository extends JpaRepository<Satellite, Long> {
    boolean existsByName(String name);
}
