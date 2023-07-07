package fr.gugus.addonvoicechat.items;

import fr.gugus.addonvoicechat.init.ModItems;
import fr.gugus.addonvoicechat.utils.handlers.SoundsHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Megaphone extends Item {

    public Megaphone(String name) {

        setRegistryName(name).setUnlocalizedName(name);

        ModItems.INSTANCE.getItems().add(this);

    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        worldIn.playSound(playerIn, playerIn.posX, playerIn.posY, playerIn.posZ, SoundsHandler.MEGAPHONE_PUSH, SoundCategory.AMBIENT, 1.0F, 1.0F);
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
