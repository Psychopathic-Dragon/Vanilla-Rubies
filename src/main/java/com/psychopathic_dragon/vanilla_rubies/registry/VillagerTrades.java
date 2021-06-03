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



        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 6, factories -> {
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 2), new ItemStack(Items.GOLDEN_APPLE, 1), 12, 45, .05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 1), new ItemStack(Items.PUMPKIN_PIE, 3), 12, 45, .05f));
        });



        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FISHERMAN, 6, factories -> {
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 1), new ItemStack(Items.TROPICAL_FISH_BUCKET, 1), 12, 45, .05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 1), new ItemStack(Items.PUFFERFISH_BUCKET, 1), 12, 45, .05f));
        });




        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 6, (factories) -> {
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 1), new ItemStack(Items.PRISMARINE, 4), 3, 45, 0.05F));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 1), new ItemStack(Items.DARK_PRISMARINE, 4), 3, 45, 0.05F));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 1), new ItemStack(Items.PRISMARINE_BRICKS, 4), 3, 45, 0.05F));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 1), new ItemStack(Items.SEA_LANTERN, 1), 12, 45, 0.05F));
        });




        TradeOfferHelper.registerVillagerOffers(VillagerProfession.LEATHERWORKER, 6, factories -> {
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 5), new ItemStack(Items.TURTLE_HELMET, 1), 12, 45, .05f));
        });



        TradeOfferHelper.registerVillagerOffers(VillagerProfession.LIBRARIAN, 6, factories -> {
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 5), new ItemStack(Moditems.RUBY, 1), 12, 45, .05f));
            factories.add(new RubyEnchantBookFactory(25));

        });



        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 6, factories -> {
            factories.add(new RubySellPotionHoldingItemFactory(Items.GLASS_BOTTLE, 1, Items.POTION, 1, 1, 12, 40));
        });



        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 6, factories -> {
            factories.add(new RubySellMapFactory(3, StructureFeature.BURIED_TREASURE, MapIcon.Type.RED_X, 6, 45));
            factories.add(new RubySellMapFactory(3, StructureFeature.DESERT_PYRAMID, MapIcon.Type.TARGET_POINT, 6, 45));
            factories.add(new RubySellMapFactory(3, StructureFeature.JUNGLE_PYRAMID, MapIcon.Type.TARGET_POINT, 6, 45));
        });



        TradeOfferHelper.registerVillagerOffers(VillagerProfession.BUTCHER, 6, factories -> {
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 1), new ItemStack(Items.COOKED_BEEF, 10), 6, 40, .05f));
        });





        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FLETCHER, 6, factories -> {
            factories.add(new RubySellPotionHoldingItemFactory(Items.ARROW, 15, Items.TIPPED_ARROW, 15, 1, 6, 40));
        });



        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 6, factories -> {
            factories.add(new RubySellEnchantedToolFactory(Items.NETHERITE_SHOVEL, 20, 4, 45));
            factories.add(new RubySellEnchantedToolFactory(Items.NETHERITE_HOE, 15, 4, 45));
            factories.add(new RubySellEnchantedToolFactory(Items.NETHERITE_AXE, 20, 4, 45));
            factories.add(new RubySellEnchantedToolFactory(Items.NETHERITE_PICKAXE, 20, 4, 45));
        });



        TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 6, factories -> {
            factories.add(new RubySellEnchantedToolFactory(Items.NETHERITE_SWORD, 25, 4, 45));
            factories.add(new RubySellEnchantedToolFactory(Items.TRIDENT, 25, 4, 45));
        });


        TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 6, factories -> {
            factories.add(new RubySellEnchantedToolFactory(Items.NETHERITE_HELMET, 20, 4, 45));
            factories.add(new RubySellEnchantedToolFactory(Items.NETHERITE_CHESTPLATE, 20, 4, 45));
            factories.add(new RubySellEnchantedToolFactory(Items.NETHERITE_LEGGINGS, 20, 4, 45));
            factories.add(new RubySellEnchantedToolFactory(Items.NETHERITE_BOOTS, 20, 4, 45));
        });


        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 6, factories -> {
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 1), new ItemStack(Items.BLACK_DYE, 8), 8, 30, .05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 1), new ItemStack(Items.BLUE_DYE, 8), 8, 30, .05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 1), new ItemStack(Items.RED_DYE, 8), 8, 30, .05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 1), new ItemStack(Items.GREEN_DYE, 8), 8, 30, .05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 1), new ItemStack(Items.LIGHT_BLUE_DYE, 8), 8, 30, .05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 1), new ItemStack(Items.LIGHT_GRAY_DYE, 8), 8, 30, .05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 1), new ItemStack(Items.YELLOW_DYE, 8), 8, 30, .05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 1), new ItemStack(Items.LIME_DYE, 8), 8, 30, .05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 1), new ItemStack(Items.CYAN_DYE, 8), 8, 30, .05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 1), new ItemStack(Items.GRAY_DYE, 8), 8, 30, .05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 1), new ItemStack(Items.WHITE_DYE, 8), 8, 30, .05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 1), new ItemStack(Items.PINK_DYE, 8), 8, 30, .05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 1), new ItemStack(Items.BROWN_DYE, 8), 8, 30, .05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 1), new ItemStack(Items.MAGENTA_DYE, 8), 8, 30, .05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 1), new ItemStack(Items.PURPLE_DYE, 8), 8, 30, .05f));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Moditems.RUBY, 1), new ItemStack(Items.ORANGE_DYE, 8), 8, 30, .05f));
        });


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


