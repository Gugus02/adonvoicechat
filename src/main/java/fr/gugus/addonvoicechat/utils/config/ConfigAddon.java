package fr.gugus.addonvoicechat.utils.config;

import fr.gugus.addonvoicechat.AddonVoiceChat;
import fr.gugus.addonvoicechat.utils.References;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;
public class ConfigAddon {

    public static boolean CMegaphoneOpen(){
        return CMegaphoneOpen();
    }

    public static Configuration config;

    public static void init(File file){

        config = new Configuration(file);
        String category;

    }

    public static void registerConfig(FMLPreInitializationEvent event){
        AddonVoiceChat.config = new File(event.getModConfigurationDirectory() + "/" + References.MODID);
        AddonVoiceChat.config.mkdir();
        init(new File(AddonVoiceChat.config.getPath(), References.MODID + ".cfg"));
    }

}