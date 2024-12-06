package com.example.SpringPetDatabase.services;
import com.example.SpringPetDatabase.entities.Household;
import java.util.List;
import java.util.Optional;

import org.springframework.security.access.annotation.Secured;

public interface HouseholdService {
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    Household createHousehold(Household household);
    
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    Household getHouseholdByEircode(String eircode);

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    List<Household> getAllHouseholds();

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    Household updateHousehold(String eircode, Household updatedHousehold);
    
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    void deleteHouseholdByEircode(String eircode);

    Optional<Household> findHouseholdByEircodeWithPets(String eircode);

    List<Household> findHouseholdsWithNoPets();

    int getTotalHouseholds();

    
}
