package com.example.SpringPetDatabase.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.SpringPetDatabase.entities.Pet;
import com.example.SpringPetDatabase.repositories.PetRepository;
import com.example.SpringPetDatabase.exception.PetNotFoundException;

@Service
public class PetServiceImpl implements PetService {
    @Autowired
    private PetRepository petRepository;

    @Override
    public Pet createPet(Pet pet) {
        if (pet.getName() == null || pet.getAnimalType() == null || pet.getBreed() == null) {
            throw new IllegalArgumentException("details cannot be null");
        }
        return petRepository.save(pet);
    }

    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @Override
    public Pet getPetById(Long id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new PetNotFoundException("ID " + id + " not found"));
    }

    @Override
    public Pet updatePet(Long id, Pet updatedPet) {
        Pet existingPet = petRepository.findById(id)
                .orElseThrow(() -> new PetNotFoundException("ID " + id + " not found"));
        existingPet.setName(updatedPet.getName());
        existingPet.setAge(updatedPet.getAge());
        existingPet.setBreed(updatedPet.getBreed());
        return petRepository.save(existingPet);
    }

    @Override
    public void deletePetById(Long id) {
        if (!petRepository.existsById(id)) {
            throw new PetNotFoundException("ID " + id + " not found");
        }
        petRepository.deleteById(id);
    }

    @Override
    public void deletePetsByName(String name) {
        petRepository.deleteByNameIgnoreCase(name);
    }

    @Override
    public List<Pet> findPetsByAnimalType(String animalType) {
        return petRepository.findByAnimalTypeIgnoreCase(animalType);
    }

    @Override
    public List<Pet> findPetsByBreed(String breed) {
        return petRepository.findByBreedOrderByAge(breed);
    }

    @Override
    public List<Object[]> getNameAndBreed() {
        return petRepository.findNameAndBreed();
    }

    @Override
    public Double getAverageAge() {
        return petRepository.findAverageAge();
    }

    @Override
    public Integer getOldestAge() {
        return petRepository.findOldestAge();
    }

    @Override
    public Pet updatePetName(Long id, String name) {
        Pet pet = petRepository.findById(id)
                           .orElseThrow(() -> new IllegalArgumentException("not found"));
        pet.setName(name);
        return petRepository.save(pet);
    }

        @Override
    public int getTotalPets() {
        return (int) petRepository.count();
    }
}

