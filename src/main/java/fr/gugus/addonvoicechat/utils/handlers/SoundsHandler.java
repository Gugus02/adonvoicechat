package fr.gugus.addonvoicechat.utils.handlers;

import fr.gugus.addonvoicechat.utils.References;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class SoundsHandler {

    public static SoundEvent MEGAPHONE_PUSH;

    public static void registerSounds(){

        MEGAPHONE_PUSH = registerSound("megaphone.push");

    }

    private static SoundEvent registerSound(String name){

        ResourceLocation location = new ResourceLocation(References.MODID, name);
        SoundEvent event = new SoundEvent(location);
        event.setRegistryName(name);
        ForgeRegistries.SOUND_EVENTS.register(event);
        return event;

    }

}
