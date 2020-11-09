package com.mart.boundless.ritual;

import com.mart.boundless.ritual.requirements.BlockRequirement;
import com.mart.boundless.ritual.requirements.IRequirement;
import com.mart.boundless.tile.CosmicInfuserTile;

import java.util.ArrayList;
import java.util.List;

public class RitualBase {

    public List<IRequirement> requirements;
    public final String name;

    public RitualBase(String name) {
        this.name = name;
        this.requirements = new ArrayList<>();
    }

    public void activate(CosmicInfuserTile tile){
        for(IRequirement requirement : this.requirements){
            if(!requirement.met(tile)){
                System.out.println("Cannot activate");
                return;
            }
        }

        System.out.println("activate");
    }

    public void addRequirement(IRequirement requirement){
        this.requirements.add(requirement);
    }
}
