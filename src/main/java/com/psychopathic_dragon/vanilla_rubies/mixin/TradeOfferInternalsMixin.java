package com.psychopathic_dragon.vanilla_rubies.mixin;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.fabricmc.fabric.impl.object.builder.TradeOfferInternals;
import net.fabricmc.fabric.mixin.object.builder.TradeOffersAccessor;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.VillagerProfession;
import org.apache.commons.lang3.ArrayUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.HashMap;
import java.util.Map;

@Mixin(TradeOfferInternals.class)
public class TradeOfferInternalsMixin {
    private static final Map<VillagerProfession, Int2ObjectMap<TradeOffers.Factory[]>> VILLAGER_TRADE_FACTORIES = new HashMap<>();


    @Overwrite
    private static void refreshVillagerOffers() {
        TradeOffersAccessor.setVillagerTradeMap(VILLAGER_TRADE_FACTORIES);
}}
