package com.psychopathic_dragon.vanilla_rubies.mixin;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.client.render.entity.feature.VillagerClothingFeatureRenderer;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;
@Mixin(VillagerClothingFeatureRenderer.class)
public interface VillagerClothingFeatureRendererMixin {
    @Accessor("LEVEL_TO_ID")
    static void setClothingFeature(Int2ObjectMap<Identifier> clothing) {
        throw new AssertionError("This should not happen!");
    }}


