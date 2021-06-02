package com.psychopathic_dragon.vanilla_rubies.registry;

import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;

import java.util.HashSet;
import java.util.Set;

public class LootTable {
    static final LootPool POOL;

    static final Set<Identifier> IDS;

    static {
        FabricLootPoolBuilder Pool_Builder = FabricLootPoolBuilder.builder();
        Pool_Builder.withCondition(RandomChanceLootCondition.builder(0.20F).build());
        Pool_Builder.withEntry(ItemEntry.builder(Moditems.RUBY).build());
        POOL = Pool_Builder.build();

        IDS = new HashSet<>();
        IDS.add(new Identifier("minecraft", "chests/buried_treasure"));
        IDS.add(new Identifier("minecraft", "chests/desert_pyramid"));
        IDS.add(new Identifier("minecraft", "chests/jungle_temple"));
        IDS.add(new Identifier("minecraft", "chests/shipwreck_treasure"));
        IDS.add(new Identifier("minecraft", "chests/woodland_mansion"));
    }

    public static  void init(){
        LootTableLoadingCallback.EVENT.register((resourceManager, manager, id, supplier, setter) -> {
            if(IDS.stream().anyMatch(i-> i.equals(id))){
                supplier.withPool(POOL);
            }
        });
    }
}

