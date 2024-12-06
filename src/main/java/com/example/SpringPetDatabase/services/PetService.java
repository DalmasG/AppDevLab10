package com.example.SpringPetDatabase.services;

import com.example.SpringPetDatabase.entities.Pet;
import java.util.List;

import org.springframework.security.access.annotation.Secured;

public interface PetService {
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    Pet createPet(Pet pet);

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    List<Pet> getAllPets();

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    Pet getPetById(Long id);

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    Pet updatePet(Long id, Pet updatedPet);


    Pet updatePetName(Long id, String name);

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    void deletePetById(Long id);

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    void deletePetsByName(String name);

    List<Pet> findPetsByAnimalType(String animalType);

    List<Pet> findPetsByBreed(String breed);

    List<Object[]> getNameAndBreed();

    Double getAverageAge();

    Integer getOldestAge();

    int getTotalPets();
}
