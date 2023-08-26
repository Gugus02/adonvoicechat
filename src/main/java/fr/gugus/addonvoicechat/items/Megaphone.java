package fr.gugus.addonvoicechat.items;


import fr.gugus.addonvoicechat.utils.handlers.SoundsHandler;
import fr.gugus.addonvoicechat.utils.handlers.VoiceHandler;
import fr.nathanael2611.modularvoicechat.api.StartVoiceRecordEvent;
import fr.nathanael2611.modularvoicechat.api.StopVoiceRecordEvent;
import fr.nathanael2611.modularvoicechat.api.VoiceKeyEvent;
import fr.nathanael2611.modularvoicechat.client.voice.audio.MicroManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.world.World;


public class Megaphone extends Item {

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


        if (megaphoneOpen == false){

            megaphoneOpen = true;

            System.out.println(megaphoneOpen);

        }else {
            megaphoneOpen = false;

            System.out.println(megaphoneOpen);

        }

        new VoiceHandler(megaphoneOpen);


        playerIn.setActiveHand(handIn);

        return new ActionResult<>(EnumActionResult.SUCCESS, heldItem);
    }

}
