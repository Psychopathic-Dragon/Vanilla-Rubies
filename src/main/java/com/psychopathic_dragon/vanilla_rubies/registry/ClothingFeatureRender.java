package com.psychopathic_dragon.vanilla_rubies.registry;



import com.psychopathic_dragon.vanilla_rubies.mixin.VillagerClothingFeatureRendererAccessor;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
@Environment(EnvType.CLIENT)
public class ClothingFeatureRender {
    public static final Int2ObjectMap<Identifier> clothing = (Int2ObjectMap) Util.make(new Int2ObjectOpenHashMap(), (int2ObjectOpenHashMap) -> {
        int2ObjectOpenHashMap.put(1, new Identifier("stone"));
        int2ObjectOpenHashMap.put(2, new Identifier("iron"));
        int2ObjectOpenHashMap.put(3, new Identifier("gold"));
        int2ObjectOpenHashMap.put(4, new Identifier("emerald"));
        int2ObjectOpenHashMap.put(5, new Identifier("diamond"));
        int2ObjectOpenHashMap.put(6, new Identifier("ruby"));
    });
    public static void addRuby() {

        VillagerClothingFeatureRendererAccessor.setClothingFeature(clothing);
    }
}
