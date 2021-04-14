package com.psychopathic_dragon.vanilla_rubies.registry;


import com.psychopathic_dragon.vanilla_rubies.VanillaRubies;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Modblocks {

    public static final Block RUBY_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool().strength(5F, 30.0f).sounds(BlockSoundGroup.METAL));

    public static final Block RUBY_ORE= new OreBlock(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool().strength(3F, 15F).sounds(BlockSoundGroup.STONE));


    public  static  void  registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(VanillaRubies.Mod_ID, "ruby_block"), RUBY_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(VanillaRubies.Mod_ID, "ruby_ore"), RUBY_ORE);

    }
}
