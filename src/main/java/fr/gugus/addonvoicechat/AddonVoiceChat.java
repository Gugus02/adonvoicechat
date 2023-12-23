package fr.gugus.addonvoicechat;

import fr.gugus.addonvoicechat.init.ModItems;
import fr.gugus.addonvoicechat.items.Megaphone;
import fr.gugus.addonvoicechat.proxy.CommonProxy;
import fr.gugus.addonvoicechat.utils.References;
import fr.gugus.addonvoicechat.utils.config.ConfigAddon;
import fr.gugus.addonvoicechat.utils.handlers.SoundsHandler;
import fr.nathanael2611.modularvoicechat.api.HearDistanceEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

@Mod(modid = References.MODID,name = References.NAME,version = References.VERSION)
public class AddonVoiceChat {

    public static File config;

    @Mod.Instance(References.MODID)
    public static AddonVoiceChat instance;

    @SidedProxy(clientSide = References.CLIENT,serverSide = References.SERVER)
    public static CommonProxy proxy;

    @SubscribeEvent
    public void hearDistance(HearDistanceEvent event){

        System.out.println("§ctest1");


    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e){

        ModItems.init();

        SoundsHandler.registerSounds();

        proxy.preInit();

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e){



        proxy.init();

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e){

        proxy.postInit();

    }


}
