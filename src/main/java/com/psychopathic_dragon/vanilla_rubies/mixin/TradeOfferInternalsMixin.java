package com.psychopathic_dragon.vanilla_rubies.mixin;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.fabricmc.fabric.impl.object.builder.TradeOfferInternals;

import net.minecraft.village.TradeOffers;
import net.minecraft.village.VillagerProfession;
import org.apache.commons.lang3.ArrayUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.*;
import java.util.function.Consumer;

@Mixin(TradeOfferInternals.class)
public class TradeOfferInternalsMixin {
    private static final Map<VillagerProfession, Int2ObjectMap<TradeOffers.Factory[]>> VILLAGER_TRADE_FACTORIES = new HashMap<>();


    @Overwrite
    public static synchronized void registerVillagerOffers(VillagerProfession profession, int level, Consumer<List<TradeOffers.Factory>> factory) {
        Objects.requireNonNull(profession, "VillagerProfession may not be null.");
        registerOffers(VILLAGER_TRADE_FACTORIES.computeIfAbsent(profession, key -> new Int2ObjectOpenHashMap<>()), level, factory);
    }

    private static void registerOffers(Int2ObjectMap<TradeOffers.Factory[]> leveledTradeMap, int level, Consumer<List<TradeOffers.Factory>> factory) {
        final List<TradeOffers.Factory> list = new ArrayList<>();
        factory.accept(list);

        final TradeOffers.Factory[] originalEntries = leveledTradeMap.computeIfAbsent(level, key -> new TradeOffers.Factory[0]);
        final TradeOffers.Factory[] addedEntries = list.toArray(new TradeOffers.Factory[0]);

        final TradeOffers.Factory[] allEntries = ArrayUtils.addAll(originalEntries, addedEntries);
        leveledTradeMap.put(level, allEntries);
    }}
