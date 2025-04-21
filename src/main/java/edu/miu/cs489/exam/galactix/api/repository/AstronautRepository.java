package edu.miu.cs489.exam.galactix.api.repository;

import edu.miu.cs489.exam.galactix.api.model.Astronaut;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AstronautRepository extends JpaRepository<Astronaut, Long> {
}
