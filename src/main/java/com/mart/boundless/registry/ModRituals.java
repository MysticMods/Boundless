package com.mart.boundless.registry;

import com.mart.boundless.ritual.GrowthCharmRitual;
import com.mart.boundless.ritual.RitualBase;

import java.util.HashMap;
import java.util.Map;

public class ModRituals {

    private static Map<String, RitualBase> ritualRegistry = new HashMap<>();

    public static RitualBase growth_charm_ritual;

    public static void setup() {
        ritualRegistry.put("growth_charm_ritual", growth_charm_ritual = new GrowthCharmRitual());
    }


}
