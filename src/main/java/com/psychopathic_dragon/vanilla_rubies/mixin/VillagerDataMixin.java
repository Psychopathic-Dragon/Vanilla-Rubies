package com.psychopathic_dragon.vanilla_rubies.mixin;

import net.minecraft.village.VillagerData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(VillagerData.class)
public class VillagerDataMixin {

    @Overwrite
    public static boolean canLevelUp(int level){
        return level >= 1 && level < 6;

    }
}
