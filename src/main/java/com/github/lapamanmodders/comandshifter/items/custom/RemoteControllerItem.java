package com.github.lapamanmodders.comandshifter.items.custom;

import com.github.lapamanmodders.comandshifter.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap;


public class RemoteControllerItem extends TieredItem {
    public RemoteControllerItem(Tier pTier, Properties pProperties) {
        super(pTier, pProperties);


    }


    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        BlockPos positionClicked = pContext.getClickedPos();
        Player player = pContext.getPlayer();


        //Cambiar esto en un futuro
        if(pContext.getLevel().isClientSide()) {
            pContext.getLevel().playSound(player, positionClicked, ModSounds.REMOTE_BUTTON_CLICKED.get(),
                    SoundSource.BLOCKS, 2f, 1f);

        }

        return super.useOn(pContext);
    }

}