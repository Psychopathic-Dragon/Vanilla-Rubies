package com.psychopathic_dragon.vanilla_rubies.registry;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;

public class WanderingTraderTrades {


    public static void init() {
        TradeOfferHelper.registerWanderingTraderOffers(3, factories -> {
                factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY,2), new ItemStack(Items.SCUTE, 1), 5, 2,.05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY,1), new ItemStack(Items.RABBIT_FOOT, 1), 5, 2,.05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY,1), new ItemStack(Items.PHANTOM_MEMBRANE, 1), 5, 2,.05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY,7), new ItemStack(Items.HEART_OF_THE_SEA, 1), 1, 2,.05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY,2), new ItemStack(Items.NAUTILUS_SHELL, 1), 8, 2,.05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY,1), new ItemStack(Items.HONEYCOMB, 4), 1, 2,.05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY,1), new ItemStack(Items.HONEY_BOTTLE, 2), 1, 2,.05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY,1), new ItemStack(Items.EMERALD, 5), 12, 2,.05f));

        });
        TradeOfferHelper.registerWanderingTraderOffers(4, factories -> {
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY,10), new ItemStack(Items.ZOMBIE_HEAD, 1), 1, 2,.05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY,10), new ItemStack(Items.PLAYER_HEAD, 1), 1, 2,.05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY,10), new ItemStack(Items.SKELETON_SKULL, 1), 1, 2,.05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY,36), new ItemStack(Items.WITHER_ROSE, 1), 4, 2,.05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY,2), new ItemStack(Items.FIREWORK_ROCKET, 8), 8, 2,.05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY,25), new ItemStack(Items.TOTEM_OF_UNDYING, 1), 1, 2,.05f));

        });

        TradeOfferHelper.registerWanderingTraderOffers(5, factories -> {
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY,5), new ItemStack(Items.MUSIC_DISC_11, 1), 1, 2,.05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY,5), new ItemStack(Items.MUSIC_DISC_13, 1), 1, 2,.05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY,5), new ItemStack(Items.MUSIC_DISC_BLOCKS, 1), 1, 2,.05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY,5), new ItemStack(Items.MUSIC_DISC_CAT, 1), 1, 2,.05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY,5), new ItemStack(Items.MUSIC_DISC_CHIRP, 1), 1, 2,.05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY,5), new ItemStack(Items.MUSIC_DISC_FAR, 1), 1, 2,.05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY,5), new ItemStack(Items.MUSIC_DISC_MALL, 1), 1, 2,.05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY,5), new ItemStack(Items.MUSIC_DISC_MELLOHI, 1), 1, 2,.05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY,5), new ItemStack(Items.MUSIC_DISC_STAL, 1), 1, 2,.05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY,5), new ItemStack(Items.MUSIC_DISC_STRAD, 1), 1, 2,.05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY,5), new ItemStack(Items.MUSIC_DISC_WAIT, 1), 1, 2,.05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY,5), new ItemStack(Items.MUSIC_DISC_WARD, 1), 1, 2,.05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY,10), new ItemStack(Moditems.MUSIC_DISC_NO_PRESSURE, 1), 1, 2,.05f));



        });



}

}
