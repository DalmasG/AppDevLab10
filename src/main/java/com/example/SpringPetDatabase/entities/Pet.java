package com.example.SpringPetDatabase.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "pets")
@Data 
@ToString(exclude = "household")
@NoArgsConstructor 
@AllArgsConstructor 
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @Column(nullable = false)
    private String name;

    @Column(name = "animal_type", nullable = false)
    private String animalType;

    @Column(nullable = false)
    private String breed;

    @Column(nullable = false)
    private int age;

    @ManyToOne
    @JoinColumn(name = "household_eircode", referencedColumnName = "eircode")
    private Household household; 
}
