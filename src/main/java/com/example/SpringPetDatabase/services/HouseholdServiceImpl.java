package com.example.SpringPetDatabase.services;

import com.example.SpringPetDatabase.entities.Household;
import com.example.SpringPetDatabase.repositories.HouseholdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HouseholdServiceImpl implements HouseholdService {
    @Autowired
    private HouseholdRepository householdRepository;

    @Override
    public Household createHousehold(Household household) {
        return householdRepository.save(household);
    }

    @Override
    public Household getHouseholdByEircode(String eircode) {
        return householdRepository.findById(eircode)
                .orElseThrow(() -> new IllegalArgumentException(" eircode " + eircode + " not found"));
    }

    @Override
    public List<Household> getAllHouseholds() {
        return householdRepository.findAll();
    }

    @Override
    public Household updateHousehold(String eircode, Household updatedHousehold) {
        Household existingHousehold = getHouseholdByEircode(eircode);
        existingHousehold.setNumberOfOccupants(updatedHousehold.getNumberOfOccupants());
        existingHousehold.setMaxNumberOfOccupants(updatedHousehold.getMaxNumberOfOccupants());
        existingHousehold.setOwnerOccupied(updatedHousehold.isOwnerOccupied());
        return householdRepository.save(existingHousehold);
    }

    @Override
    public void deleteHouseholdByEircode(String eircode) {
        householdRepository.deleteById(eircode);
    }

    @Override
    public Optional<Household> findHouseholdByEircodeWithPets(String eircode) {
        return householdRepository.findByEircodeWithPets(eircode);
    }

    @Override
    public List<Household> findHouseholdsWithNoPets() {
        return householdRepository.findHouseholdsWithNoPets();
    }

    @Override
    public int getTotalHouseholds() {
        return (int) householdRepository.count();
    }

}
