package com.psychopathic_dragon.vanilla_rubies;

import com.psychopathic_dragon.vanilla_rubies.registry.*;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class VanillaRubies implements  ModInitializer {
    public static final String Mod_ID = "vanillarubies";


    private static final Identifier RUBY_BLOCK_LOOT_TABLE_ID = new Identifier(Mod_ID, "blocks/ruby_block");
    private static final Identifier RUBY_ORE_LOOT_TABLE_ID = new Identifier(Mod_ID, "blocks/ruby_ore");

    public static final ConfiguredFeature<?, ?> ORE_RUBY_ORE_OVERWORLD = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, Modblocks.RUBY_ORE.getDefaultState(), 3)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, 0, 32))).spreadHorizontally().repeat(8);

    @Override
    public void onInitialize() {
        Moditems.registerItems();
        Modblocks.registerBlocks();
        WanderingTraderTrades.init();
        Sounds.init();
        VillagerTrades.init();
        ClothingFeatureRender.addRuby();
        VillagerData2.setExperience();
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier("vanillarubies", "ore_ruby_ore_overworld"), ORE_RUBY_ORE_OVERWORLD);
        LootTable.init();


    }
}
