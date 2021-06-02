package com.psychopathic_dragon.vanilla_rubies.registry;

import com.psychopathic_dragon.vanilla_rubies.VanillaRubies;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class Moditems {

    public static final Item RUBY = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Item MUSIC_DISC_NO_PRESSURE = new RubyMusicDiscItem(14, Sounds.SOUND_NO_PRESSURE,new Item.Settings().rarity(Rarity.RARE).maxCount(1).group(ItemGroup.MISC));


    public static final BlockItem RUBY_BLOCK = new BlockItem(Modblocks.RUBY_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem RUBY_ORE = new BlockItem(Modblocks.RUBY_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));


    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(VanillaRubies.Mod_ID, "ruby"), RUBY);
        Registry.register(Registry.ITEM, new Identifier( VanillaRubies.Mod_ID, "ruby_block"), RUBY_BLOCK);
        Registry.register(Registry.ITEM, new Identifier( VanillaRubies.Mod_ID, "ruby_ore"), RUBY_ORE);
        Registry.register(Registry.ITEM, new Identifier( VanillaRubies.Mod_ID, "music_disc_no_pressure"), MUSIC_DISC_NO_PRESSURE);


    }
}
