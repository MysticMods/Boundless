package com.mart.boundless.ritual.requirements;

import com.mart.boundless.ritual.RitualBase;
import com.mart.boundless.tile.CosmicInfuserTile;

public interface IRequirement {

    boolean met(CosmicInfuserTile infuserTile);

}
