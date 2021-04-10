package com.psychopathic_dragon.vanilla_rubies.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.passive.WanderingTraderEntity;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOfferList;
import net.minecraft.village.TradeOffers;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WanderingTraderEntity.class)
public abstract class WanderingTraderEntityMixin extends MerchantEntity {

    @Shadow
    public native void fillRecipes();

    @Shadow
    public native void afterUsing(TradeOffer offer);


    public WanderingTraderEntityMixin(EntityType<? extends MerchantEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(at = @At("RETURN"), method = "fillRecipes")
    public void add_new_list(CallbackInfo info) {
        TradeOffers.Factory[] factorys3 = TradeOffers.WANDERING_TRADER_TRADES.get(3);
        if (factorys3 != null) {
            if (this.getOffers() != null) {
                TradeOfferList tradeOfferList = this.getOffers();
                this.fillRecipesFromPool(tradeOfferList, factorys3, 1);


            }
        }

    }
    @Inject(at = @At("RETURN"), method = "fillRecipes")
    public void add_new_list2(CallbackInfo info) {
        TradeOffers.Factory[] factorys4 = TradeOffers.WANDERING_TRADER_TRADES.get(4);
        if (factorys4 != null) {
            if (this.getOffers() != null) {
                TradeOfferList tradeOfferList = this.getOffers();
                this.fillRecipesFromPool(tradeOfferList, factorys4, 1);


            }
        }

    }

    @Inject(at = @At("RETURN"), method = "fillRecipes")
    public void add_new_list3(CallbackInfo info) {
        TradeOffers.Factory[] factorys5 = TradeOffers.WANDERING_TRADER_TRADES.get(5);
        if (factorys5 != null) {
            if (this.getOffers() != null) {
                TradeOfferList tradeOfferList = this.getOffers();
                this.fillRecipesFromPool(tradeOfferList, factorys5, 1);


}}}}




