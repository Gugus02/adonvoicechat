package fr.gugus.addonvoicechat.init;

import com.google.common.collect.Lists;
import fr.gugus.addonvoicechat.items.Megaphone;
import fr.gugus.addonvoicechat.utils.References;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;

@Mod.EventBusSubscriber(modid = References.MODID)
public class ModItems {

    public static final ModItems INSTANCE = new ModItems();

    public static Item megaphone;

    private List<Item> items;

    public void init(){

        items = Lists.newArrayList();

        megaphone = new Megaphone("megaphone");

    }

    @SubscribeEvent
    public void registerModels(ModelRegistryEvent e){

        for(Item item : items){

            registerModel(item);
        }


    }

    private void registerModel(Item item){

        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(References.MODID, item.getUnlocalizedName().substring(5)), "inventory"));

    }

    public List<Item> getItems() {

        return items;

    }
}
