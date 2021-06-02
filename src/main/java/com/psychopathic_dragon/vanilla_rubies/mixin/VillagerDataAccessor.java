package com.psychopathic_dragon.vanilla_rubies.mixin;

import net.minecraft.village.VillagerData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(VillagerData.class)
public interface VillagerDataAccessor {
    @Accessor("LEVEL_BASE_EXPERIENCE")
    static void setBaseExperience(int[] experience) {
        throw new AssertionError("This should not happen!");

    }

}