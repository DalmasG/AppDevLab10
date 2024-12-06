package com.example.SpringPetDatabase.controllers;

import com.example.SpringPetDatabase.entities.Household;
import com.example.SpringPetDatabase.services.HouseholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/households")
public class HouseholdController {

    @Autowired
    private HouseholdService householdService;

    
    @GetMapping
    public List<Household> getAllHouseholds() {
        return householdService.getAllHouseholds();
    }

    
    @GetMapping("/no-pets")
    public ResponseEntity<List<Household>> getHouseholdsWithNoPets() {
        List<Household> households = householdService.findHouseholdsWithNoPets();
        return ResponseEntity.ok(households);
    }

    
    @GetMapping("/{eircode}")
    public ResponseEntity<Household> getHouseholdByEircode(@PathVariable String eircode) {
        return ResponseEntity.ok(householdService.getHouseholdByEircode(eircode));
    }

    
    @PostMapping
    public ResponseEntity<Household> createHousehold(@RequestBody Household household) {
        return ResponseEntity.ok(householdService.createHousehold(household));
    }

    
    @DeleteMapping("/{eircode}")
    public ResponseEntity<Void> deleteHousehold(@PathVariable String eircode) {
        householdService.deleteHouseholdByEircode(eircode);
        return ResponseEntity.noContent().build();
    }
}
