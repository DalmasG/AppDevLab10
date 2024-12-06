package com.example.SpringPetDatabase.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class HouseholdInput {
    
    @NotBlank
    private String eircode;

    @NotNull
    private Integer numberOfOccupants;

    @NotNull
    private Integer maxNumberOfOccupants;

    @NotNull
    private Boolean ownerOccupied;

    
    public String getEircode() {
        return eircode;
    }

    public void setEircode(String eircode) {
        this.eircode = eircode;
    }

    public Integer getNumberOfOccupants() {
        return numberOfOccupants;
    }

    public void setNumberOfOccupants(Integer numberOfOccupants) {
        this.numberOfOccupants = numberOfOccupants;
    }

    public Integer getMaxNumberOfOccupants() {
        return maxNumberOfOccupants;
    }

    public void setMaxNumberOfOccupants(Integer maxNumberOfOccupants) {
        this.maxNumberOfOccupants = maxNumberOfOccupants;
    }

    public Boolean getOwnerOccupied() {
        return ownerOccupied;
    }

    public void setOwnerOccupied(Boolean ownerOccupied) {
        this.ownerOccupied = ownerOccupied;
    }
}
