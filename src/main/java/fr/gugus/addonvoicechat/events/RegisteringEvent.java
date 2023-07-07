package fr.gugus.addonvoicechat.events;

import fr.gugus.addonvoicechat.init.ModItems;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RegisteringEvent {

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> e){

        ModItems.INSTANCE.init();
        e.getRegistry().registerAll(ModItems.INSTANCE.getItems().toArray(new Item[0]));

    }

}
