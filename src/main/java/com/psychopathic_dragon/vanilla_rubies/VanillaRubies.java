package com.psychopathic_dragon.vanilla_rubies;

import com.psychopathic_dragon.vanilla_rubies.registry.*;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.item.Items;
import net.minecraft.loot.ConstantLootTableRange;
import net.minecraft.loot.UniformLootTableRange;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
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
    private static final Identifier SHIPWRECK_TREASURE_LOOT_TABLE_ID = new Identifier("minecraft", "chests/shipwreck_treasure");
    private static final Identifier BURIED_TREASURE_LOOT_TABLE_ID = new Identifier("minecraft", "chests/buried_treasure");
    private static final Identifier END_CITY_TREASURE_LOOT_TABLE_ID = new Identifier("minecraft", "chests/end_city_treasure");
    private static final Identifier WOODLAND_MANSION_LOOT_TABLE_ID = new Identifier("minecraft", "chests/woodland_mansion");
    private static final Identifier DESERT_TEMPLE_LOOT_TABLE_ID = new Identifier("minecraft", "chests/desert_pyramid");
    private static final Identifier VILLAGE_TEMPLE_LOOT_TABLE_ID = new Identifier("minecraft", "chests/village/village_temple");
    private static final Identifier JUNGLE_TEMPLE_LOOT_TABLE_ID = new Identifier("minecraft", "chests/jungle_temple");

    public static final ConfiguredFeature<?, ?> ORE_RUBY_ORE_OVERWORLD = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, Modblocks.RUBY_ORE.getDefaultState(), 3)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, 0, 32))).spreadHorizontally().repeat(8);

    private void modifyLootTables(){
        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
            if (SHIPWRECK_TREASURE_LOOT_TABLE_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder().rolls(ConstantLootTableRange.create(1)).with(ItemEntry.builder(Moditems.RUBY)).withFunction(SetCountLootFunction.builder(UniformLootTableRange.between(0.0f,2.0f)).build());
                supplier.withPool(poolBuilder.build());
            } });
        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
            if (BURIED_TREASURE_LOOT_TABLE_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder().rolls(ConstantLootTableRange.create(1)).with(ItemEntry.builder(Moditems.RUBY)).withFunction(SetCountLootFunction.builder(UniformLootTableRange.between(0.0f,6.0f)).build());
                supplier.withPool(poolBuilder.build());
            } });
        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
            if (END_CITY_TREASURE_LOOT_TABLE_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder().rolls(ConstantLootTableRange.create(1)).with(ItemEntry.builder(Moditems.RUBY)).withFunction(SetCountLootFunction.builder(UniformLootTableRange.between(0.0f,4.0f)).build());
                supplier.withPool(poolBuilder.build());
            } });
        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
            if (WOODLAND_MANSION_LOOT_TABLE_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder().rolls(ConstantLootTableRange.create(1)).with(ItemEntry.builder(Moditems.RUBY)).withFunction(SetCountLootFunction.builder(UniformLootTableRange.between(0.0f,2.0f)).build());
                supplier.withPool(poolBuilder.build());
            } });
        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
            if (DESERT_TEMPLE_LOOT_TABLE_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder().rolls(ConstantLootTableRange.create(1)).with(ItemEntry.builder(Moditems.RUBY)).withFunction(SetCountLootFunction.builder(UniformLootTableRange.between(0.0f,1.0f)).build());
                supplier.withPool(poolBuilder.build());
            } });
        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
            if (VILLAGE_TEMPLE_LOOT_TABLE_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder().rolls(ConstantLootTableRange.create(1)).with(ItemEntry.builder(Moditems.RUBY)).withFunction(SetCountLootFunction.builder(UniformLootTableRange.between(0.0f,2.0f)).build());
                supplier.withPool(poolBuilder.build());
            } });
        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
            if (JUNGLE_TEMPLE_LOOT_TABLE_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder().rolls(ConstantLootTableRange.create(1)).with(ItemEntry.builder(Moditems.RUBY)).withFunction(SetCountLootFunction.builder(UniformLootTableRange.between(0.0f,2.0f)).build());
                supplier.withPool(poolBuilder.build());
            } });

    }

    @Override
    public void onInitialize() {
        modifyLootTables();
        Moditems.registerItems();
        Modblocks.registerBlocks();
        WanderingTraderTrades.init();
        Sounds.init();
        VillagerTrades.init();
        VillagerData2.setExperience();
        try{
            ClothingFeatureRender.addRuby();}
        catch(RuntimeException runtimeException){}
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier("vanillarubies", "ore_ruby_ore_overworld"), ORE_RUBY_ORE_OVERWORLD);
        LootTable.init();


    }
}
