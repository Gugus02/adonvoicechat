package fr.gugus.addonvoicechat.items;


import com.google.gson.JsonPrimitive;
import fr.gugus.addonvoicechat.utils.handlers.SoundsHandler;
import fr.nathanael2611.modularvoicechat.api.VoiceKeyEvent;
import fr.nathanael2611.modularvoicechat.client.voice.audio.MicroManager;
import fr.nathanael2611.modularvoicechat.config.ClientConfig;
import fr.nathanael2611.modularvoicechat.proxy.ClientProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.world.World;


public class Megaphone extends Item {

    public boolean toggle = false;
    public boolean megaphoneOpen = false;

    public Megaphone(String name) {

        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.MATERIALS);
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.BOW;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack heldItem = playerIn.getHeldItem(handIn);

        worldIn.playSound(playerIn, playerIn.posX, playerIn.posY, playerIn.posZ, SoundsHandler.MEGAPHONE_PUSH, SoundCategory.AMBIENT, 1.0F, 1.0F);

        VoiceKeyEvent voiceKeyEvent = new VoiceKeyEvent(ClientProxy.getConfig().get(ClientConfig.TOGGLE_TO_TALK).getAsBoolean());

        if (!voiceKeyEvent.isToggleToTalk()) {

            toggle = true;

            ClientProxy.getConfig().set(ClientConfig.TOGGLE_TO_TALK, new JsonPrimitive(true));

        }else if (toggle){

            ClientProxy.getConfig().set(ClientConfig.TOGGLE_TO_TALK, new JsonPrimitive(false));

            System.out.println("toggle");

            toggle = false;

        }
        if (megaphoneOpen == false){


            if (MicroManager.isRunning() && !MicroManager.getHandler().isSending()) {

                MicroManager.getHandler().start();
            }

            megaphoneOpen = true;

        }else {

            if (MicroManager.isRunning() && MicroManager.getHandler().isSending()) {

                MicroManager.getHandler().stop();

            }

            megaphoneOpen = false;

        }


        playerIn.setActiveHand(handIn);

        return new ActionResult<>(EnumActionResult.SUCCESS, heldItem);
    }


}
