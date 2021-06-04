package com.psychopathic_dragon.vanilla_rubies.registry;

import com.psychopathic_dragon.vanilla_rubies.mixin.VillagerDataAccessor;


public class VillagerData2 {
    public static final int[] experience = new int[]{0, 10, 70, 150, 250, 500};
    public static void setExperience () {
        

        VillagerDataAccessor.setBaseExperience(experience);
    }

}
