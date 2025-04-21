package edu.miu.cs489.exam.galactix.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Table(name = "satellites")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Satellite {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, unique = true, length = 255)
    private String name;

    @Column(nullable = false)
    private LocalDate launchDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OrbitType orbitType;

    @Column(nullable = false)
    private boolean decommissioned;
}
