package com.psychopathic_dragon.vanilla_rubies.registry;

import com.psychopathic_dragon.vanilla_rubies.VanillaRubies;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Sounds {
    public  static  final SoundEvent SOUND_NO_PRESSURE = register("music_disc.no_pressure");

    public static SoundEvent register(String name) {
        Identifier id = new Identifier(VanillaRubies.Mod_ID, name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }
    public static void init() { }
}
