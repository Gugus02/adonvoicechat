package fr.gugus.addonvoicechat.init;

import fr.gugus.addonvoicechat.items.Megaphone;
import fr.gugus.addonvoicechat.utils.References;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = References.MODID)
public class ModItems {

    public static Item megaphone;

    public static void init(){

        megaphone = new Megaphone("megaphone");

    }
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event){

        event.getRegistry().registerAll(megaphone);

    }

   @SubscribeEvent
   public static void registerRenders(ModelRegistryEvent event){

        registerRender(megaphone);

   }

   private static void registerRender(Item item){

        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(),"inventory"));

   }
}
