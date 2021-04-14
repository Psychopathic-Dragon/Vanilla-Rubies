package com.psychopathic_dragon.vanilla_rubies.registry;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.item.map.MapIcon;
import net.minecraft.item.map.MapState;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtil;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.village.*;
import net.minecraft.world.gen.feature.StructureFeature;
import org.jetbrains.annotations.Nullable;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import net.minecraft.item.EnchantedBookItem;



public class VillagerTrades {
    public static void init() {


        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1, factories -> {
            factories.add(new BuyForOneEmeraldFactory(Items.WHEAT, 20, 16, 2));
            factories.add(new BuyForOneEmeraldFactory(Items.POTATO, 26, 16, 2));
            factories.add(new BuyForOneEmeraldFactory(Items.CARROT, 22, 16, 2));
            factories.add(new BuyForOneEmeraldFactory(Items.BEETROOT, 15, 16, 2));
            factories.add(new SellItemFactory(Items.BREAD, 1, 6, 16, 1));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 2, factories -> {
            factories.add(new BuyForOneEmeraldFactory(Blocks.PUMPKIN, 6, 12, 10));
            factories.add(new SellItemFactory(Items.PUMPKIN_PIE, 1, 4, 5));
            factories.add(new SellItemFactory(Items.APPLE, 1, 4, 16, 5));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 3, factories -> {
            factories.add(new SellItemFactory(Items.COOKIE, 3, 18, 10));
            factories.add(new BuyForOneEmeraldFactory(Blocks.MELON, 4, 12, 20));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 4, factories -> {
            factories.add(new SellItemFactory(Blocks.CAKE, 1, 1, 12, 15));
            factories.add(new SellSuspiciousStewFactory(StatusEffects.NIGHT_VISION, 100, 15));
            factories.add(new SellSuspiciousStewFactory(StatusEffects.JUMP_BOOST, 160, 15));
            factories.add(new SellSuspiciousStewFactory(StatusEffects.WEAKNESS, 140, 15));
            factories.add(new SellSuspiciousStewFactory(StatusEffects.BLINDNESS, 120, 15));
            factories.add(new SellSuspiciousStewFactory(StatusEffects.POISON, 280, 15));
            factories.add(new SellSuspiciousStewFactory(StatusEffects.SATURATION, 7, 15));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 5, factories -> {
            factories.add(new SellItemFactory(Items.GOLDEN_CARROT, 3, 3, 30));
            factories.add(new SellItemFactory(Items.GLISTERING_MELON_SLICE, 4, 3, 30));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 6, factories -> {
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 2), new ItemStack(Items.GOLDEN_APPLE, 1), 12, 45, .05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 1), new ItemStack(Items.PUMPKIN_PIE, 3), 12, 45, .05f));
        });

        
        

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FISHERMAN, 1, factories -> {
            factories.add(new BuyForOneEmeraldFactory(Items.STRING, 20, 16, 2));
            factories.add(new BuyForOneEmeraldFactory(Items.COAL, 10, 16, 2));
            factories.add(new ProcessItemFactory(Items.COD, 6, Items.COOKED_COD, 6, 16, 1));
            factories.add(new SellItemFactory(Items.COD_BUCKET, 3, 1, 16, 1));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FISHERMAN, 2, factories -> {
            factories.add(new BuyForOneEmeraldFactory(Items.COD, 15, 16, 10));
            factories.add(new ProcessItemFactory(Items.SALMON, 6, Items.COOKED_SALMON, 6, 16, 5));
            factories.add(new SellItemFactory(Items.CAMPFIRE, 2, 1, 5));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FISHERMAN, 3, factories -> {
            factories.add(new BuyForOneEmeraldFactory(Items.SALMON, 13, 16, 20));
            factories.add(new SellEnchantedToolFactory(Items.FISHING_ROD, 3, 3, 10, 0.2F));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FISHERMAN, 4, factories -> {
            factories.add(new BuyForOneEmeraldFactory(Items.TROPICAL_FISH, 6, 12, 30));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FISHERMAN, 5, factories -> {
            factories.add(new BuyForOneEmeraldFactory(Items.PUFFERFISH, 4, 12, 30));
            factories.add(new BuyForOneEmeraldFactory(Items.OAK_BOAT, 1, 12, 30));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FISHERMAN, 6, factories -> {
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 1), new ItemStack(Items.TROPICAL_FISH_BUCKET, 1), 12, 45, .05f));
        });






        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 1, (factories) -> {
            factories.add(new BuyForOneEmeraldFactory(Items.CLAY_BALL, 10, 16, 2));
            factories.add(new SellItemFactory(Items.BRICK, 1, 10, 16, 1));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 2, (factories) -> {
            factories.add(new BuyForOneEmeraldFactory(Blocks.STONE, 20, 16, 10));
            factories.add(new SellItemFactory(Blocks.CHISELED_STONE_BRICKS, 1, 4, 16, 5));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 3, (factories) -> {
            factories.add(new BuyForOneEmeraldFactory(Blocks.GRANITE, 16, 16, 20));
            factories.add(new BuyForOneEmeraldFactory(Blocks.ANDESITE, 16, 16, 20));
            factories.add(new BuyForOneEmeraldFactory(Blocks.DIORITE, 16, 16, 20));
            factories.add(new SellItemFactory(Blocks.POLISHED_ANDESITE, 1, 4, 16, 10));
            factories.add(new SellItemFactory(Blocks.POLISHED_DIORITE, 1, 4, 16, 10));
            factories.add(new SellItemFactory(Blocks.POLISHED_GRANITE, 1, 4, 16, 10));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, (factories) -> {
            factories.add(new BuyForOneEmeraldFactory(Items.QUARTZ, 12, 12, 30));
            factories.add(new SellItemFactory(Blocks.ORANGE_TERRACOTTA, 1, 1, 12, 15));
            factories.add(new SellItemFactory(Blocks.WHITE_TERRACOTTA, 1, 1, 12, 15));
            factories.add(new SellItemFactory(Blocks.BLUE_TERRACOTTA, 1, 1, 12, 15));
            factories.add(new SellItemFactory(Blocks.LIGHT_BLUE_TERRACOTTA, 1, 1, 12, 15));
            factories.add(new SellItemFactory(Blocks.GRAY_TERRACOTTA, 1, 1, 12, 15));
            factories.add(new SellItemFactory(Blocks.LIGHT_GRAY_TERRACOTTA, 1, 1, 12, 15));
            factories.add(new SellItemFactory(Blocks.BLACK_TERRACOTTA, 1, 1, 12, 15));
            factories.add(new SellItemFactory(Blocks.RED_TERRACOTTA, 1, 1, 12, 15));
            factories.add(new SellItemFactory(Blocks.PINK_TERRACOTTA, 1, 1, 12, 15));
            factories.add(new SellItemFactory(Blocks.MAGENTA_TERRACOTTA, 1, 1, 12, 15));
            factories.add(new SellItemFactory(Blocks.LIME_TERRACOTTA, 1, 1, 12, 15));
            factories.add(new SellItemFactory(Blocks.GREEN_TERRACOTTA, 1, 1, 12, 15));
            factories.add(new SellItemFactory(Blocks.CYAN_TERRACOTTA, 1, 1, 12, 15));
            factories.add(new SellItemFactory(Blocks.PURPLE_TERRACOTTA, 1, 1, 12, 15));
            factories.add(new SellItemFactory(Blocks.YELLOW_TERRACOTTA, 1, 1, 12, 15));
            factories.add(new SellItemFactory(Blocks.BROWN_TERRACOTTA, 1, 1, 12, 15));
            factories.add(new SellItemFactory(Blocks.ORANGE_GLAZED_TERRACOTTA, 1, 1, 12, 15));
            factories.add(new SellItemFactory(Blocks.WHITE_GLAZED_TERRACOTTA, 1, 1, 12, 15));
            factories.add(new SellItemFactory(Blocks.BLUE_GLAZED_TERRACOTTA, 1, 1, 12, 15));
            factories.add(new SellItemFactory(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA, 1, 1, 12, 15));
            factories.add(new SellItemFactory(Blocks.GRAY_GLAZED_TERRACOTTA, 1, 1, 12, 15));
            factories.add(new SellItemFactory(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA, 1, 1, 12, 15));
            factories.add(new SellItemFactory(Blocks.BLACK_GLAZED_TERRACOTTA, 1, 1, 12, 15));
            factories.add(new SellItemFactory(Blocks.RED_GLAZED_TERRACOTTA, 1, 1, 12, 15));
            factories.add(new SellItemFactory(Blocks.PINK_GLAZED_TERRACOTTA, 1, 1, 12, 15));
            factories.add(new SellItemFactory(Blocks.MAGENTA_GLAZED_TERRACOTTA, 1, 1, 12, 15));
            factories.add(new SellItemFactory(Blocks.LIME_GLAZED_TERRACOTTA, 1, 1, 12, 15));
            factories.add(new SellItemFactory(Blocks.GREEN_GLAZED_TERRACOTTA, 1, 1, 12, 15));
            factories.add(new SellItemFactory(Blocks.CYAN_GLAZED_TERRACOTTA, 1, 1, 12, 15));
            factories.add(new SellItemFactory(Blocks.PURPLE_GLAZED_TERRACOTTA, 1, 1, 12, 15));
            factories.add(new SellItemFactory(Blocks.YELLOW_GLAZED_TERRACOTTA, 1, 1, 12, 15));
            factories.add(new SellItemFactory(Blocks.BROWN_GLAZED_TERRACOTTA, 1, 1, 12, 15));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 5, (factories) -> {
            factories.add(new SellItemFactory(Blocks.QUARTZ_PILLAR, 1, 1, 12, 30));
            factories.add(new SellItemFactory(Blocks.QUARTZ_BLOCK, 1, 1, 12, 30));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 6, (factories) -> {
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 1), new ItemStack(Items.PRISMARINE, 4), 3, 45, 0.05F));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 1), new ItemStack(Items.DARK_PRISMARINE, 4), 3, 45, 0.05F));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 1), new ItemStack(Items.PRISMARINE_BRICKS, 4), 3, 45, 0.05F));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 1), new ItemStack(Items.SEA_LANTERN, 1), 12, 45, 0.05F));
        });





        TradeOfferHelper.registerVillagerOffers(VillagerProfession.LEATHERWORKER, 1, factories -> {
            factories.add(new BuyForOneEmeraldFactory(Items.LEATHER, 6, 16, 2));
            factories.add(new SellDyedArmorFactory(Items.LEATHER_LEGGINGS, 3));
            factories.add(new SellDyedArmorFactory(Items.LEATHER_CHESTPLATE, 7));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.LEATHERWORKER, 2, factories -> {
            factories.add(new BuyForOneEmeraldFactory(Items.FLINT, 26, 12, 10));
            factories.add(new SellDyedArmorFactory(Items.LEATHER_HELMET, 5, 12, 5));
            factories.add(new SellDyedArmorFactory(Items.LEATHER_BOOTS, 4, 12, 5));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.LEATHERWORKER, 3, factories -> {
            factories.add(new BuyForOneEmeraldFactory(Items.RABBIT_HIDE, 9, 12, 20));
            factories.add(new SellDyedArmorFactory(Items.LEATHER_CHESTPLATE, 7));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.LEATHERWORKER, 4, factories -> {
            factories.add(new BuyForOneEmeraldFactory(Items.SCUTE, 4, 12, 30));
            factories.add(new SellDyedArmorFactory(Items.LEATHER_HORSE_ARMOR, 6, 12, 15));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.LEATHERWORKER, 5, factories -> {
            factories.add(new SellItemFactory(new ItemStack(Items.SADDLE), 6, 1, 12, 30, 0.2F));
            factories.add(new SellDyedArmorFactory(Items.LEATHER_HELMET, 5, 12, 30));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.LEATHERWORKER, 6, factories -> {
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 5), new ItemStack(Items.TURTLE_HELMET, 1), 12, 45, .05f));
        });

        
        

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.LIBRARIAN, 1, factories -> {
            factories.add(new BuyForOneEmeraldFactory(Items.PAPER, 24, 16, 2));
            factories.add(new EnchantBookFactory(1));
            factories.add(new SellItemFactory(Blocks.BOOKSHELF, 9, 1, 12, 1));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.LIBRARIAN, 2, factories -> {
            factories.add(new BuyForOneEmeraldFactory(Items.BOOK, 4, 12, 10));
            factories.add(new EnchantBookFactory(5));
            factories.add(new SellItemFactory(Items.LANTERN, 1, 1, 5));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.LIBRARIAN, 3, factories -> {
            factories.add(new BuyForOneEmeraldFactory(Items.INK_SAC, 5, 12, 20));
            factories.add(new EnchantBookFactory(10));
            factories.add(new SellItemFactory(Items.GLASS, 1, 4, 10));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.LIBRARIAN, 4, factories -> {
            factories.add(new BuyForOneEmeraldFactory(Items.WRITABLE_BOOK, 2, 12, 30));
            factories.add(new EnchantBookFactory(15));
            factories.add(new SellItemFactory(Items.CLOCK, 5, 1, 15));
            factories.add(new SellItemFactory(Items.COMPASS, 4, 1, 15));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.LIBRARIAN, 5, factories -> {
            factories.add(new SellItemFactory(Items.NAME_TAG, 20, 1, 30));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.LIBRARIAN, 6, factories -> {
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 5), new ItemStack(Moditems.RUBY, 1), 12, 45, .05f));
            factories.add(new RubyEnchantBookFactory(25));
            factories.add(new RubyEnchantBookFactory(25));
        });
        
        
        
        
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 1, factories -> { 
            factories.add(new BuyForOneEmeraldFactory(Items.ROTTEN_FLESH, 32, 16, 2));
            factories.add(new SellItemFactory(Items.REDSTONE, 1, 2, 1));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 2, factories -> {
            factories.add(new BuyForOneEmeraldFactory(Items.GOLD_INGOT, 3, 12, 10));
            factories.add(new SellItemFactory(Items.LAPIS_LAZULI, 1, 1, 5));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 3, factories -> {
            factories.add(new BuyForOneEmeraldFactory(Items.RABBIT_FOOT, 2, 12, 20));
            factories.add(new SellItemFactory(Blocks.GLOWSTONE, 4, 1, 12, 10));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 4, factories -> {
                    factories.add(new BuyForOneEmeraldFactory(Items.SCUTE, 4, 12, 30));
                    factories.add(new BuyForOneEmeraldFactory(Items.GLASS_BOTTLE, 9, 12, 30));
                    factories.add(new SellItemFactory(Items.ENDER_PEARL, 5, 1, 15));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 5, factories -> {
                    factories.add(new BuyForOneEmeraldFactory(Items.NETHER_WART, 22, 12, 30));
                    factories.add(new SellItemFactory(Items.EXPERIENCE_BOTTLE, 3, 1, 30));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 6, factories -> {
            factories.add(new RubySellPotionHoldingItemFactory(Items.GLASS_BOTTLE, 1, Items.POTION, 1, 1, 12, 40));
        });




        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 1, factories -> { 
            factories.add(new BuyForOneEmeraldFactory(Items.PAPER, 24, 16, 2));
            factories.add(new SellItemFactory(Items.MAP, 7, 1, 1));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 2, factories -> {
            factories.add(new BuyForOneEmeraldFactory(Items.GLASS_PANE, 11, 16, 10));
            factories.add(new SellMapFactory(13, StructureFeature.MONUMENT, MapIcon.Type.MONUMENT, 12, 5));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 3, factories -> {
            factories.add(new BuyForOneEmeraldFactory(Items.COMPASS, 1, 12, 20));
            factories.add(new SellMapFactory(14, StructureFeature.MANSION, MapIcon.Type.MANSION, 12, 10));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 4, factories -> {
            factories.add(new SellItemFactory(Items.ITEM_FRAME, 7, 1, 15));
            factories.add(new SellItemFactory(Items.WHITE_BANNER, 3, 1, 15));
            factories.add(new SellItemFactory(Items.BLUE_BANNER, 3, 1, 15));
            factories.add(new SellItemFactory(Items.LIGHT_BLUE_BANNER, 3, 1, 15));
            factories.add(new SellItemFactory(Items.RED_BANNER, 3, 1, 15));
            factories.add(new SellItemFactory(Items.PINK_BANNER, 3, 1, 15));
            factories.add(new SellItemFactory(Items.GREEN_BANNER, 3, 1, 15));
            factories.add(new SellItemFactory(Items.LIME_BANNER, 3, 1, 15));
            factories.add(new SellItemFactory(Items.GRAY_BANNER, 3, 1, 15));
            factories.add(new SellItemFactory(Items.BLACK_BANNER, 3, 1, 15));
            factories.add(new SellItemFactory(Items.PURPLE_BANNER, 3, 1, 15));
            factories.add(new SellItemFactory(Items.MAGENTA_BANNER, 3, 1, 15));
            factories.add(new SellItemFactory(Items.CYAN_BANNER, 3, 1, 15));
            factories.add(new SellItemFactory(Items.BROWN_BANNER, 3, 1, 15));
            factories.add(new SellItemFactory(Items.YELLOW_BANNER, 3, 1, 15));
            factories.add(new SellItemFactory(Items.ORANGE_BANNER, 3, 1, 15));
            factories.add(new SellItemFactory(Items.LIGHT_GRAY_BANNER, 3, 1, 15));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 5, factories -> {
            factories.add(new SellItemFactory(Items.GLOBE_BANNER_PATTERN, 8, 1, 30));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 6, factories -> {
            factories.add(new RubySellMapFactory(3, StructureFeature.BURIED_TREASURE, MapIcon.Type.RED_X, 6, 45));
            factories.add(new RubySellMapFactory(3, StructureFeature.DESERT_PYRAMID, MapIcon.Type.TARGET_POINT, 6, 45));
            factories.add(new RubySellMapFactory(3, StructureFeature.JUNGLE_PYRAMID, MapIcon.Type.TARGET_POINT, 6, 45));
        });


        TradeOfferHelper.registerVillagerOffers(VillagerProfession.BUTCHER, 1, factories -> {
            factories.add(new BuyForOneEmeraldFactory(Items.CHICKEN, 14, 16, 2));
            factories.add(new BuyForOneEmeraldFactory(Items.PORKCHOP, 7, 16, 2));
            factories.add(new BuyForOneEmeraldFactory(Items.RABBIT, 4, 16, 2));
            factories.add(new SellItemFactory(Items.RABBIT_STEW, 1, 1, 1));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.BUTCHER, 2, factories -> {
            factories.add(new BuyForOneEmeraldFactory(Items.COAL, 15, 16, 2));
            factories.add(new SellItemFactory(Items.COOKED_PORKCHOP, 1, 5, 16, 5));
            factories.add(new SellItemFactory(Items.COOKED_CHICKEN, 1, 8, 16, 5));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.BUTCHER, 3, factories -> {
            factories.add(new BuyForOneEmeraldFactory(Items.MUTTON, 7, 16, 20));
            factories.add(new BuyForOneEmeraldFactory(Items.BEEF, 10, 16, 20));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.BUTCHER, 4, factories -> {
            factories.add(new BuyForOneEmeraldFactory(Items.DRIED_KELP_BLOCK, 10, 12, 30));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.BUTCHER, 5, factories -> {
            factories.add(new BuyForOneEmeraldFactory(Items.SWEET_BERRIES, 10, 12, 30));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.BUTCHER, 6, factories -> {
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 1), new ItemStack(Items.COOKED_BEEF, 10), 6, 40, .05f));
        });

        
        
        
        

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FLETCHER, 1, factories -> {
            factories.add(new BuyForOneEmeraldFactory(Items.STICK, 32, 16, 2));
            factories.add(new SellItemFactory(Items.ARROW, 1, 16, 1));
            factories.add(new ProcessItemFactory(Blocks.GRAVEL, 10, Items.FLINT, 10, 12, 1));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FLETCHER, 2, factories -> {
            factories.add(new BuyForOneEmeraldFactory(Items.FLINT, 26, 12, 10));
            factories.add(new SellItemFactory(Items.BOW, 2, 1, 5));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FLETCHER, 3, factories -> {
            factories.add(new BuyForOneEmeraldFactory(Items.STRING, 14, 16, 20));
            factories.add(new SellItemFactory(Items.CROSSBOW, 3, 1, 10));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FLETCHER, 4, factories -> {
            factories.add(new BuyForOneEmeraldFactory(Items.FEATHER, 24, 16, 30));
            factories.add(new SellEnchantedToolFactory(Items.BOW, 2, 3, 15));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FLETCHER, 5, factories -> {
            factories.add(new BuyForOneEmeraldFactory(Items.TRIPWIRE_HOOK, 8, 12, 30));
            factories.add(new SellEnchantedToolFactory(Items.CROSSBOW, 3, 3, 15));
            factories.add(new SellPotionHoldingItemFactory(Items.ARROW, 5, Items.TIPPED_ARROW, 5, 2, 12, 30));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FLETCHER, 6, factories -> {
            factories.add(new RubySellPotionHoldingItemFactory(Items.ARROW, 15, Items.TIPPED_ARROW, 15, 1, 6, 40));
        });



        
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 1, factories -> {
            factories.add(new BuyForOneEmeraldFactory(Items.COAL, 15, 16, 2));
            factories.add(new SellItemFactory(new ItemStack(Items.STONE_AXE), 1, 1, 12, 1, 0.2F));
            factories.add(new SellItemFactory(new ItemStack(Items.STONE_SHOVEL), 1, 1, 12, 1, 0.2F));
            factories.add(new SellItemFactory(new ItemStack(Items.STONE_PICKAXE), 1, 1, 12, 1, 0.2F));
            factories.add(new SellItemFactory(new ItemStack(Items.STONE_HOE), 1, 1, 12, 1, 0.2F));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 2, factories -> {
            factories.add(new BuyForOneEmeraldFactory(Items.IRON_INGOT, 4, 12, 10));
            factories.add(new SellItemFactory(new ItemStack(Items.BELL), 36, 1, 12, 5, 0.2F));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 3, factories -> {
            factories.add(new BuyForOneEmeraldFactory(Items.FLINT, 30, 12, 20));
            factories.add(new SellEnchantedToolFactory(Items.IRON_AXE, 1, 3, 10, 0.2F));
            factories.add(new SellEnchantedToolFactory(Items.IRON_SHOVEL, 2, 3, 10, 0.2F));
            factories.add(new SellEnchantedToolFactory(Items.IRON_PICKAXE, 3, 3, 10, 0.2F));
            factories.add(new SellItemFactory(new ItemStack(Items.DIAMOND_HOE), 4, 1, 3, 10, 0.2F));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 4, factories -> {
            factories.add(new BuyForOneEmeraldFactory(Items.DIAMOND, 1, 12, 30));
            factories.add(new SellEnchantedToolFactory(Items.DIAMOND_AXE, 12, 3, 15, 0.2F));
            factories.add(new SellEnchantedToolFactory(Items.DIAMOND_SHOVEL, 5, 3, 15, 0.2F));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 5, factories -> {
            factories.add(new SellEnchantedToolFactory(Items.DIAMOND_PICKAXE, 13, 3, 30, 0.2F));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 6, factories -> {
            factories.add(new RubySellEnchantedToolFactory(Items.NETHERITE_SHOVEL, 20, 4, 45));
            factories.add(new RubySellEnchantedToolFactory(Items.NETHERITE_HOE, 15, 4, 45));
            factories.add(new RubySellEnchantedToolFactory(Items.NETHERITE_AXE, 20, 4, 45));
            factories.add(new RubySellEnchantedToolFactory(Items.NETHERITE_PICKAXE, 20, 4, 45));
        });


        

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 1, factories -> {
            factories.add(new BuyForOneEmeraldFactory(Items.COAL, 15, 16, 2));
            factories.add(new SellItemFactory(new ItemStack(Items.IRON_AXE), 3, 1, 12, 1, 0.2F));
            factories.add(new SellEnchantedToolFactory(Items.IRON_SWORD, 2, 3, 1));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 2, factories -> {
            factories.add(new BuyForOneEmeraldFactory(Items.IRON_INGOT, 4, 12, 10));
            factories.add(new SellItemFactory(new ItemStack(Items.BELL), 36, 1, 12, 5, 0.2F));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 3, factories -> {
            factories.add(new BuyForOneEmeraldFactory(Items.FLINT, 24, 12, 20));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 4, factories -> {
            factories.add(new BuyForOneEmeraldFactory(Items.DIAMOND, 1, 12, 30));
            factories.add(new SellEnchantedToolFactory(Items.DIAMOND_AXE, 12, 3, 15, 0.2F));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 5, factories -> {
            factories.add(new SellEnchantedToolFactory(Items.DIAMOND_SWORD, 8, 3, 30, 0.2F));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 6, factories -> {
            factories.add(new RubySellEnchantedToolFactory(Items.NETHERITE_SWORD, 25, 4, 45));
            factories.add(new RubySellEnchantedToolFactory(Items.TRIDENT, 25, 4, 45));
        });




        
        
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 1, factories -> {
            factories.add(new BuyForOneEmeraldFactory(Items.COAL, 15, 16, 2));
            factories.add(new SellItemFactory(new ItemStack(Items.IRON_LEGGINGS), 7, 1, 12, 1, 0.2F));
            factories.add(new SellItemFactory(new ItemStack(Items.IRON_BOOTS), 4, 1, 12, 1, 0.2F));
            factories.add(new SellItemFactory(new ItemStack(Items.IRON_HELMET), 5, 1, 12, 1, 0.2F));
            factories.add(new SellItemFactory(new ItemStack(Items.IRON_CHESTPLATE), 9, 1, 12, 1, 0.2F));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 2, factories -> {
            factories.add(new BuyForOneEmeraldFactory(Items.IRON_INGOT, 4, 12, 10));
            factories.add(new SellItemFactory(new ItemStack(Items.BELL), 36, 1, 12, 5, 0.2F));
            factories.add(new SellItemFactory(new ItemStack(Items.CHAINMAIL_BOOTS), 1, 1, 12, 5, 0.2F));
            factories.add(new SellItemFactory(new ItemStack(Items.CHAINMAIL_LEGGINGS), 3, 1, 12, 5, 0.2F));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 3, factories -> {
            factories.add(new BuyForOneEmeraldFactory(Items.LAVA_BUCKET, 1, 12, 20));
            factories.add(new BuyForOneEmeraldFactory(Items.DIAMOND, 1, 12, 20));
            factories.add(new SellItemFactory(new ItemStack(Items.CHAINMAIL_HELMET), 1, 1, 12, 10, 0.2F));
            factories.add(new SellItemFactory(new ItemStack(Items.CHAINMAIL_CHESTPLATE), 4, 1, 12, 10, 0.2F));
            factories.add(new SellItemFactory(new ItemStack(Items.SHIELD), 5, 1, 12, 10, 0.2F));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 4, factories -> {
            factories.add(new SellEnchantedToolFactory(Items.DIAMOND_LEGGINGS, 14, 3, 15, 0.2F));
            factories.add(new SellEnchantedToolFactory(Items.DIAMOND_BOOTS, 8, 3, 15, 0.2F));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 5, factories -> {
            factories.add(new SellEnchantedToolFactory(Items.DIAMOND_HELMET, 8, 3, 30, 0.2F));
            factories.add(new SellEnchantedToolFactory(Items.DIAMOND_CHESTPLATE, 16, 3, 30, 0.2F));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 6, factories -> {
            factories.add(new RubySellEnchantedToolFactory(Items.NETHERITE_HELMET, 20, 4, 45));
            factories.add(new RubySellEnchantedToolFactory(Items.NETHERITE_CHESTPLATE, 20, 4, 45));
            factories.add(new RubySellEnchantedToolFactory(Items.NETHERITE_LEGGINGS, 20, 4, 45));
            factories.add(new RubySellEnchantedToolFactory(Items.NETHERITE_BOOTS, 20, 4, 45));
        });


        
        
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 1, factories -> {
            factories.add(new BuyForOneEmeraldFactory(Blocks.WHITE_WOOL, 18, 16, 2));
            factories.add(new BuyForOneEmeraldFactory(Blocks.BROWN_WOOL, 18, 16, 2));
            factories.add(new BuyForOneEmeraldFactory(Blocks.BLACK_WOOL, 18, 16, 2));
            factories.add(new BuyForOneEmeraldFactory(Blocks.GRAY_WOOL, 18, 16, 2));
            factories.add(new SellItemFactory(Items.SHEARS, 2, 1, 1));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> {
            factories.add(new BuyForOneEmeraldFactory(Items.WHITE_DYE, 12, 16, 10));
            factories.add(new BuyForOneEmeraldFactory(Items.GRAY_DYE, 12, 16, 10));
            factories.add(new BuyForOneEmeraldFactory(Items.BLACK_DYE, 12, 16, 10));
            factories.add(new BuyForOneEmeraldFactory(Items.LIGHT_BLUE_DYE, 12, 16, 10));
            factories.add(new BuyForOneEmeraldFactory(Items.LIME_DYE, 12, 16, 10));
            factories.add(new SellItemFactory(Blocks.WHITE_WOOL, 1, 1, 16, 5));
            factories.add(new SellItemFactory(Blocks.ORANGE_WOOL, 1, 1, 16, 5));
            factories.add(new SellItemFactory(Blocks.MAGENTA_WOOL, 1, 1, 16, 5));
            factories.add(new SellItemFactory(Blocks.LIGHT_BLUE_WOOL, 1, 1, 16, 5));
            factories.add(new SellItemFactory(Blocks.YELLOW_WOOL, 1, 1, 16, 5));
            factories.add(new SellItemFactory(Blocks.LIME_WOOL, 1, 1, 16, 5));
            factories.add(new SellItemFactory(Blocks.PINK_WOOL, 1, 1, 16, 5));
            factories.add(new SellItemFactory(Blocks.GRAY_WOOL, 1, 1, 16, 5));
            factories.add(new SellItemFactory(Blocks.LIGHT_GRAY_WOOL, 1, 1, 16, 5));
            factories.add(new SellItemFactory(Blocks.CYAN_WOOL, 1, 1, 16, 5));
            factories.add(new SellItemFactory(Blocks.PURPLE_WOOL, 1, 1, 16, 5));
            factories.add(new SellItemFactory(Blocks.BLUE_WOOL, 1, 1, 16, 5));
            factories.add(new SellItemFactory(Blocks.BROWN_WOOL, 1, 1, 16, 5));
            factories.add(new SellItemFactory(Blocks.GREEN_WOOL, 1, 1, 16, 5));
            factories.add(new SellItemFactory(Blocks.RED_WOOL, 1, 1, 16, 5));
            factories.add(new SellItemFactory(Blocks.BLACK_WOOL, 1, 1, 16, 5));
            factories.add(new SellItemFactory(Blocks.WHITE_CARPET, 1, 4, 16, 5));
            factories.add(new SellItemFactory(Blocks.ORANGE_CARPET, 1, 4, 16, 5));
            factories.add(new SellItemFactory(Blocks.MAGENTA_CARPET, 1, 4, 16, 5));
            factories.add(new SellItemFactory(Blocks.LIGHT_BLUE_CARPET, 1, 4, 16, 5));
            factories.add(new SellItemFactory(Blocks.YELLOW_CARPET, 1, 4, 16, 5));
            factories.add(new SellItemFactory(Blocks.LIME_CARPET, 1, 4, 16, 5));
            factories.add(new SellItemFactory(Blocks.PINK_CARPET, 1, 4, 16, 5));
            factories.add(new SellItemFactory(Blocks.GRAY_CARPET, 1, 4, 16, 5));
            factories.add(new SellItemFactory(Blocks.LIGHT_GRAY_CARPET, 1, 4, 16, 5));
            factories.add(new SellItemFactory(Blocks.CYAN_CARPET, 1, 4, 16, 5));
            factories.add(new SellItemFactory(Blocks.PURPLE_CARPET, 1, 4, 16, 5));
            factories.add(new SellItemFactory(Blocks.BLUE_CARPET, 1, 4, 16, 5));
            factories.add(new SellItemFactory(Blocks.BROWN_CARPET, 1, 4, 16, 5));
            factories.add(new SellItemFactory(Blocks.GREEN_CARPET, 1, 4, 16, 5));
            factories.add(new SellItemFactory(Blocks.RED_CARPET, 1, 4, 16, 5));
            factories.add(new SellItemFactory(Blocks.BLACK_CARPET, 1, 4, 16, 5));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories -> {
            factories.add(new BuyForOneEmeraldFactory(Items.YELLOW_DYE, 12, 16, 20));
            factories.add(new BuyForOneEmeraldFactory(Items.LIGHT_GRAY_DYE, 12, 16, 20));
            factories.add(new BuyForOneEmeraldFactory(Items.ORANGE_DYE, 12, 16, 20));
            factories.add(new BuyForOneEmeraldFactory(Items.RED_DYE, 12, 16, 20));
            factories.add(new BuyForOneEmeraldFactory(Items.PINK_DYE, 12, 16, 20));
            factories.add(new SellItemFactory(Blocks.WHITE_BED, 3, 1, 12, 10));
            factories.add(new SellItemFactory(Blocks.YELLOW_BED, 3, 1, 12, 10));
            factories.add(new SellItemFactory(Blocks.RED_BED, 3, 1, 12, 10));
            factories.add(new SellItemFactory(Blocks.BLACK_BED, 3, 1, 12, 10));
            factories.add(new SellItemFactory(Blocks.BLUE_BED, 3, 1, 12, 10));
            factories.add(new SellItemFactory(Blocks.BROWN_BED, 3, 1, 12, 10));
            factories.add(new SellItemFactory(Blocks.CYAN_BED, 3, 1, 12, 10));
            factories.add(new SellItemFactory(Blocks.GRAY_BED, 3, 1, 12, 10));
            factories.add(new SellItemFactory(Blocks.GREEN_BED, 3, 1, 12, 10));
            factories.add(new SellItemFactory(Blocks.LIGHT_BLUE_BED, 3, 1, 12, 10));
            factories.add(new SellItemFactory(Blocks.LIGHT_GRAY_BED, 3, 1, 12, 10));
            factories.add(new SellItemFactory(Blocks.LIME_BED, 3, 1, 12, 10));
            factories.add(new SellItemFactory(Blocks.MAGENTA_BED, 3, 1, 12, 10));
            factories.add(new SellItemFactory(Blocks.ORANGE_BED, 3, 1, 12, 10));
            factories.add(new SellItemFactory(Blocks.PINK_BED, 3, 1, 12, 10));
            factories.add(new SellItemFactory(Blocks.PURPLE_BED, 3, 1, 12, 10));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> {
            factories.add(new BuyForOneEmeraldFactory(Items.BROWN_DYE, 12, 16, 30));
            factories.add(new BuyForOneEmeraldFactory(Items.PURPLE_DYE, 12, 16, 30));
            factories.add(new BuyForOneEmeraldFactory(Items.BLUE_DYE, 12, 16, 30));
            factories.add(new BuyForOneEmeraldFactory(Items.GREEN_DYE, 12, 16, 30));
            factories.add(new BuyForOneEmeraldFactory(Items.MAGENTA_DYE, 12, 16, 30));
            factories.add(new BuyForOneEmeraldFactory(Items.CYAN_DYE, 12, 16, 30));
            factories.add(new SellItemFactory(Items.WHITE_BANNER, 3, 1, 12, 15));
            factories.add(new SellItemFactory(Items.BLUE_BANNER, 3, 1, 12, 15));
            factories.add(new SellItemFactory(Items.LIGHT_BLUE_BANNER, 3, 1, 12, 15));
            factories.add(new SellItemFactory(Items.RED_BANNER, 3, 1, 12, 15));
            factories.add(new SellItemFactory(Items.PINK_BANNER, 3, 1, 12, 15));
            factories.add(new SellItemFactory(Items.GREEN_BANNER, 3, 1, 12, 15));
            factories.add(new SellItemFactory(Items.LIME_BANNER, 3, 1, 12, 15));
            factories.add(new SellItemFactory(Items.GRAY_BANNER, 3, 1, 12, 15));
            factories.add(new SellItemFactory(Items.BLACK_BANNER, 3, 1, 12, 15));
            factories.add(new SellItemFactory(Items.PURPLE_BANNER, 3, 1, 12, 15));
            factories.add(new SellItemFactory(Items.MAGENTA_BANNER, 3, 1, 12, 15));
            factories.add(new SellItemFactory(Items.CYAN_BANNER, 3, 1, 12, 15));
            factories.add(new SellItemFactory(Items.BROWN_BANNER, 3, 1, 12, 15));
            factories.add(new SellItemFactory(Items.YELLOW_BANNER, 3, 1, 12, 15));
            factories.add(new SellItemFactory(Items.ORANGE_BANNER, 3, 1, 12, 15));
            factories.add(new SellItemFactory(Items.LIGHT_GRAY_BANNER, 3, 1, 12, 15));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 5, factories -> {
            factories.add(new SellItemFactory(Items.PAINTING, 2, 3, 30));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 6, factories -> {
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 1), new ItemStack(Items.BLACK_DYE, 8), 8, 30, .05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 1), new ItemStack(Items.BLUE_DYE, 8), 8, 30, .05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 1), new ItemStack(Items.RED_CONCRETE, 8), 8, 30, .05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 1), new ItemStack(Items.GREEN_DYE, 8), 8, 30, .05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 1), new ItemStack(Items.LIGHT_BLUE_DYE, 8), 8, 30, .05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 1), new ItemStack(Items.LIGHT_GRAY_DYE, 8), 8, 30, .05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 1), new ItemStack(Items.YELLOW_DYE, 8), 8, 30, .05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 1), new ItemStack(Items.LIME_DYE, 8), 8, 30, .05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 1), new ItemStack(Items.CYAN_CONCRETE, 8), 8, 30, .05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 1), new ItemStack(Items.GRAY_DYE, 8), 8, 30, .05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 1), new ItemStack(Items.WHITE_DYE, 8), 8, 30, .05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 1), new ItemStack(Items.PINK_DYE, 8), 8, 30, .05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 1), new ItemStack(Items.BROWN_DYE, 8), 8, 30, .05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 1), new ItemStack(Items.MAGENTA_DYE, 8), 8, 30, .05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 1), new ItemStack(Items.PURPLE_DYE, 8), 8, 30, .05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 1), new ItemStack(Items.ORANGE_DYE, 8), 8, 30, .05f));
        });


    }


    static class ProcessItemFactory implements TradeOffers.Factory {
        private final ItemStack secondBuy;
        private final int secondCount;
        private final int price;
        private final ItemStack sell;
        private final int sellCount;
        private final int maxUses;
        private final int experience;
        private final float multiplier;

        public ProcessItemFactory(ItemConvertible item, int secondCount, Item sellItem, int sellCount, int maxUses, int experience) {
            this(item, secondCount, 1, sellItem, sellCount, maxUses, experience);
        }

        public ProcessItemFactory(ItemConvertible item, int secondCount, int price, Item sellItem, int sellCount, int maxUses, int experience) {
            this.secondBuy = new ItemStack(item);
            this.secondCount = secondCount;
            this.price = price;
            this.sell = new ItemStack(sellItem);
            this.sellCount = sellCount;
            this.maxUses = maxUses;
            this.experience = experience;
            this.multiplier = 0.05F;
        }

        @Nullable
        public TradeOffer create(Entity entity, Random random) {
            return new TradeOffer(new ItemStack(Items.EMERALD, this.price), new ItemStack(this.secondBuy.getItem(), this.secondCount), new ItemStack(this.sell.getItem(), this.sellCount), this.maxUses, this.experience, this.multiplier);
        }
    }

    static class SellMapFactory implements TradeOffers.Factory {
        private final int price;
        private final StructureFeature<?> structure;
        private final MapIcon.Type iconType;
        private final int maxUses;
        private final int experience;

        public SellMapFactory(int price, StructureFeature<?> feature, MapIcon.Type iconType, int maxUses, int experience) {
            this.price = price;
            this.structure = feature;
            this.iconType = iconType;
            this.maxUses = maxUses;
            this.experience = experience;
        }

        @Nullable
        public TradeOffer create(Entity entity, Random random) {
            if (!(entity.world instanceof ServerWorld)) {
                return null;
            } else {
                ServerWorld serverWorld = (ServerWorld) entity.world;
                BlockPos blockPos = serverWorld.locateStructure(this.structure, entity.getBlockPos(), 100, true);
                if (blockPos != null) {
                    ItemStack itemStack = FilledMapItem.createMap(serverWorld, blockPos.getX(), blockPos.getZ(), (byte) 2, true, true);
                    FilledMapItem.fillExplorationMap(serverWorld, itemStack);
                    MapState.addDecorationsTag(itemStack, blockPos, "+", this.iconType);
                    itemStack.setCustomName(new TranslatableText("filled_map." + this.structure.getName().toLowerCase(Locale.ROOT)));
                    return new TradeOffer(new ItemStack(Items.EMERALD, this.price), new ItemStack(Items.COMPASS), itemStack, this.maxUses, this.experience, 0.2F);
                } else {
                    return null;
                }
            }
        }
    }

    static class EnchantBookFactory implements TradeOffers.Factory {
        private final int experience;

        public EnchantBookFactory(int experience) {
            this.experience = experience;
        }

        public TradeOffer create(Entity entity, Random random) {
            List<Enchantment> list = (List) Registry.ENCHANTMENT.stream().filter(Enchantment::isAvailableForEnchantedBookOffer).collect(Collectors.toList());
            Enchantment enchantment = (Enchantment) list.get(random.nextInt(list.size()));
            int i = MathHelper.nextInt(random, enchantment.getMinLevel(), enchantment.getMaxLevel());
            ItemStack itemStack = EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(enchantment, i));
            int j = 2 + random.nextInt(5 + i * 10) + 3 * i;
            if (enchantment.isTreasure()) {
                j *= 2;
            }

            if (j > 64) {
                j = 64;
            }

            return new TradeOffer(new ItemStack(Items.EMERALD, j), new ItemStack(Items.BOOK), itemStack, 12, this.experience, 0.2F);
        }
    }

    static class SellDyedArmorFactory implements TradeOffers.Factory {
        private final Item sell;
        private final int price;
        private final int maxUses;
        private final int experience;

        public SellDyedArmorFactory(Item item, int price) {
            this(item, price, 12, 1);
        }

        public SellDyedArmorFactory(Item item, int price, int maxUses, int experience) {
            this.sell = item;
            this.price = price;
            this.maxUses = maxUses;
            this.experience = experience;
        }

        public TradeOffer create(Entity entity, Random random) {
            ItemStack itemStack = new ItemStack(Items.EMERALD, this.price);
            ItemStack itemStack2 = new ItemStack(this.sell);
            if (this.sell instanceof DyeableArmorItem) {
                List<DyeItem> list = Lists.newArrayList();
                list.add(getDye(random));
                if (random.nextFloat() > 0.7F) {
                    list.add(getDye(random));
                }

                if (random.nextFloat() > 0.8F) {
                    list.add(getDye(random));
                }

                itemStack2 = DyeableItem.blendAndSetColor(itemStack2, list);
            }

            return new TradeOffer(itemStack, itemStack2, this.maxUses, this.experience, 0.2F);
        }

        private static DyeItem getDye(Random random) {
            return DyeItem.byColor(DyeColor.byId(random.nextInt(16)));
        }
    }

    static class SellPotionHoldingItemFactory implements TradeOffers.Factory {
        private final ItemStack sell;
        private final int sellCount;
        private final int price;
        private final int maxUses;
        private final int experience;
        private final Item secondBuy;
        private final int secondCount;
        private final float priceMultiplier;

        public SellPotionHoldingItemFactory(Item arrow, int secondCount, Item tippedArrow, int sellCount, int price, int maxUses, int experience) {
            this.sell = new ItemStack(tippedArrow);
            this.price = price;
            this.maxUses = maxUses;
            this.experience = experience;
            this.secondBuy = arrow;
            this.secondCount = secondCount;
            this.sellCount = sellCount;
            this.priceMultiplier = 0.05F;
        }

        public TradeOffer create(Entity entity, Random random) {
            ItemStack itemStack = new ItemStack(Items.EMERALD, this.price);
            List<Potion> list = (List) Registry.POTION.stream().filter((potionx) -> {
                return !potionx.getEffects().isEmpty() && BrewingRecipeRegistry.isBrewable(potionx);
            }).collect(Collectors.toList());
            Potion potion = (Potion) list.get(random.nextInt(list.size()));
            ItemStack itemStack2 = PotionUtil.setPotion(new ItemStack(this.sell.getItem(), this.sellCount), potion);
            return new TradeOffer(itemStack, new ItemStack(this.secondBuy, this.secondCount), itemStack2, this.maxUses, this.experience, this.priceMultiplier);
        }
    }

    static class SellEnchantedToolFactory implements TradeOffers.Factory {
        private final ItemStack tool;
        private final int basePrice;
        private final int maxUses;
        private final int experience;
        private final float multiplier;

        public SellEnchantedToolFactory(Item item, int basePrice, int maxUses, int experience) {
            this(item, basePrice, maxUses, experience, 0.05F);
        }

        public SellEnchantedToolFactory(Item item, int basePrice, int maxUses, int experience, float multiplier) {
            this.tool = new ItemStack(item);
            this.basePrice = basePrice;
            this.maxUses = maxUses;
            this.experience = experience;
            this.multiplier = multiplier;
        }

        public TradeOffer create(Entity entity, Random random) {
            int i = 5 + random.nextInt(15);
            ItemStack itemStack = EnchantmentHelper.enchant(random, new ItemStack(this.tool.getItem()), i, false);
            int j = Math.min(this.basePrice + i, 64);
            ItemStack itemStack2 = new ItemStack(Items.EMERALD, j);
            return new TradeOffer(itemStack2, itemStack, this.maxUses, this.experience, this.multiplier);
        }
    }

    static class SellSuspiciousStewFactory implements TradeOffers.Factory {
        final StatusEffect effect;
        final int duration;
        final int experience;
        private final float multiplier;

        public SellSuspiciousStewFactory(StatusEffect effect, int duration, int experience) {
            this.effect = effect;
            this.duration = duration;
            this.experience = experience;
            this.multiplier = 0.05F;
        }

        @Nullable
        public TradeOffer create(Entity entity, Random random) {
            ItemStack itemStack = new ItemStack(Items.SUSPICIOUS_STEW, 1);
            SuspiciousStewItem.addEffectToStew(itemStack, this.effect, this.duration);
            return new TradeOffer(new ItemStack(Items.EMERALD, 1), itemStack, 12, this.experience, this.multiplier);
        }
    }

    static class SellItemFactory implements TradeOffers.Factory {
        private final ItemStack sell;
        private final int price;
        private final int count;
        private final int maxUses;
        private final int experience;
        private final float multiplier;

        public SellItemFactory(Block block, int price, int count, int maxUses, int experience) {
            this(new ItemStack(block), price, count, maxUses, experience);
        }

        public SellItemFactory(Item item, int price, int count, int experience) {
            this((ItemStack) (new ItemStack(item)), price, count, 12, experience);
        }

        public SellItemFactory(Item item, int price, int count, int maxUses, int experience) {
            this(new ItemStack(item), price, count, maxUses, experience);
        }

        public SellItemFactory(ItemStack stack, int price, int count, int maxUses, int experience) {
            this(stack, price, count, maxUses, experience, 0.05F);
        }

        public SellItemFactory(ItemStack stack, int price, int count, int maxUses, int experience, float multiplier) {
            this.sell = stack;
            this.price = price;
            this.count = count;
            this.maxUses = maxUses;
            this.experience = experience;
            this.multiplier = multiplier;
        }

        public TradeOffer create(Entity entity, Random random) {
            return new TradeOffer(new ItemStack(Items.EMERALD, this.price), new ItemStack(this.sell.getItem(), this.count), this.maxUses, this.experience, this.multiplier);
        }
    }

    static class TypeAwareBuyForOneEmeraldFactory implements TradeOffers.Factory {
        private final Map<VillagerType, Item> map;
        private final int count;
        private final int maxUses;
        private final int experience;

        public TypeAwareBuyForOneEmeraldFactory(int count, int maxUses, int experience, Map<VillagerType, Item> map) {
            Registry.VILLAGER_TYPE.stream().filter((villagerType) -> {
                return !map.containsKey(villagerType);
            }).findAny().ifPresent((villagerType) -> {
                throw new IllegalStateException("Missing trade for villager type: " + Registry.VILLAGER_TYPE.getId(villagerType));
            });
            this.map = map;
            this.count = count;
            this.maxUses = maxUses;
            this.experience = experience;
        }

        @Nullable
        public TradeOffer create(Entity entity, Random random) {
            if (entity instanceof VillagerDataContainer) {
                ItemStack itemStack = new ItemStack((ItemConvertible) this.map.get(((VillagerDataContainer) entity).getVillagerData().getType()), this.count);
                return new TradeOffer(itemStack, new ItemStack(Items.EMERALD), this.maxUses, this.experience, 0.05F);
            } else {
                return null;
            }
        }
    }

    static class BuyForOneEmeraldFactory implements TradeOffers.Factory {
        private final Item buy;
        private final int price;
        private final int maxUses;
        private final int experience;
        private final float multiplier;

        public BuyForOneEmeraldFactory(ItemConvertible item, int price, int maxUses, int experience) {
            this.buy = item.asItem();
            this.price = price;
            this.maxUses = maxUses;
            this.experience = experience;
            this.multiplier = 0.05F;
        }

        public TradeOffer create(Entity entity, Random random) {
            ItemStack itemStack = new ItemStack(this.buy, this.price);
            return new TradeOffer(itemStack, new ItemStack(Items.EMERALD), this.maxUses, this.experience, this.multiplier);
        }
    }
    static class RubyEnchantBookFactory implements TradeOffers.Factory {
        private final int experience;

        public RubyEnchantBookFactory(int experience) {
            this.experience = experience;
        }

        public TradeOffer create(Entity entity, Random random) {
            List<Enchantment> list = (List) Registry.ENCHANTMENT.stream().filter(Enchantment::isAvailableForEnchantedBookOffer).collect(Collectors.toList());
            Enchantment enchantment = (Enchantment) list.get(random.nextInt(list.size()));
            int i = enchantment.getMaxLevel();
            ItemStack itemStack = EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(enchantment, i));
            int j = 2 + random.nextInt(5 + i * 4) + 3 * i;

            if (j > 64) {
                j = 64;
            }

            return new TradeOffer(new ItemStack(Moditems.RUBY, j), new ItemStack(Items.BOOK), itemStack, 12, this.experience, 0.2F);
        }
    }
    static class RubySellPotionHoldingItemFactory implements TradeOffers.Factory {
        private final ItemStack sell;
        private final int sellCount;
        private final int price;
        private final int maxUses;
        private final int experience;
        private final Item secondBuy;
        private final int secondCount;
        private final float priceMultiplier;

        public RubySellPotionHoldingItemFactory(Item arrow, int secondCount, Item tippedArrow, int sellCount, int price, int maxUses, int experience) {
            this.sell = new ItemStack(tippedArrow);
            this.price = price;
            this.maxUses = maxUses;
            this.experience = experience;
            this.secondBuy = arrow;
            this.secondCount = secondCount;
            this.sellCount = sellCount;
            this.priceMultiplier = 0.05F;
        }

        public TradeOffer create(Entity entity, Random random) {
            ItemStack itemStack = new ItemStack(Moditems.RUBY, this.price);
            List<Potion> list = (List) Registry.POTION.stream().filter((potionx) -> {
                return !potionx.getEffects().isEmpty() && BrewingRecipeRegistry.isBrewable(potionx);
            }).collect(Collectors.toList());
            Potion potion = (Potion) list.get(random.nextInt(list.size()));
            ItemStack itemStack2 = PotionUtil.setPotion(new ItemStack(this.sell.getItem(), this.sellCount), potion);
            return new TradeOffer(itemStack, new ItemStack(this.secondBuy, this.secondCount), itemStack2, this.maxUses, this.experience, this.priceMultiplier);
        }
    }
    static class RubySellMapFactory implements TradeOffers.Factory {
        private final int price;
        private final StructureFeature<?> structure;
        private final MapIcon.Type iconType;
        private final int maxUses;
        private final int experience;

        public RubySellMapFactory(int price, StructureFeature<?> feature, MapIcon.Type iconType, int maxUses, int experience) {
            this.price = price;
            this.structure = feature;
            this.iconType = iconType;
            this.maxUses = maxUses;
            this.experience = experience;
        }

        @Nullable
        public TradeOffer create(Entity entity, Random random) {
            if (!(entity.world instanceof ServerWorld)) {
                return null;
            } else {
                ServerWorld serverWorld = (ServerWorld) entity.world;
                BlockPos blockPos = serverWorld.locateStructure(this.structure, entity.getBlockPos(), 100, true);
                if (blockPos != null) {
                    ItemStack itemStack = FilledMapItem.createMap(serverWorld, blockPos.getX(), blockPos.getZ(), (byte) 2, true, true);
                    FilledMapItem.fillExplorationMap(serverWorld, itemStack);
                    MapState.addDecorationsTag(itemStack, blockPos, "+", this.iconType);
                    itemStack.setCustomName(new TranslatableText("filled_map." + this.structure.getName().toLowerCase(Locale.ROOT)));
                    return new TradeOffer(new ItemStack(Moditems.RUBY, this.price), new ItemStack(Items.COMPASS), itemStack, this.maxUses, this.experience, 0.2F);
                } else {
                    return null;
                }
            }
        }
    }
    static class RubySellEnchantedToolFactory implements TradeOffers.Factory {
        private final ItemStack tool;
        private final int basePrice;
        private final int maxUses;
        private final int experience;
        private final float multiplier;

        public RubySellEnchantedToolFactory(Item item, int basePrice, int maxUses, int experience) {
            this(item, basePrice, maxUses, experience, 0.05F);
        }

        public RubySellEnchantedToolFactory(Item item, int basePrice, int maxUses, int experience, float multiplier) {
            this.tool = new ItemStack(item);
            this.basePrice = basePrice;
            this.maxUses = maxUses;
            this.experience = experience;
            this.multiplier = multiplier;
        }

        public TradeOffer create(Entity entity, Random random) {
            int i = 5 + random.nextInt(15);
            ItemStack itemStack = EnchantmentHelper.enchant(random, new ItemStack(this.tool.getItem()), i, false);
            int j = Math.min(this.basePrice + i, 64);
            ItemStack itemStack2 = new ItemStack(Moditems.RUBY, j);
            return new TradeOffer(itemStack2, itemStack, this.maxUses, this.experience, this.multiplier);
        }
    }
}


