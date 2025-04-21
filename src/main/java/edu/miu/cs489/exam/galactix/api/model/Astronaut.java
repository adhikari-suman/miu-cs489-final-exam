package edu.miu.cs489.exam.galactix.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "astronauts")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Astronaut {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false, length = 20)
    private String firstName;
    @Column(nullable = false, length = 20)
    private String lastName;
    @Column(nullable = false)
    private int experienceYears;

    @ManyToMany
    @JoinTable(
            name="astronaut_satellites",
            joinColumns = @JoinColumn(
                    name="astronaut_id", referencedColumnName="id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name="satellite_id", referencedColumnName="id"
            )
    )
    private List<Satellite> satellites;
}
