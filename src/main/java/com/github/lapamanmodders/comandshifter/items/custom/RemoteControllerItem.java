package com.github.lapamanmodders.comandshifter.items.custom;

import com.github.lapamanmodders.comandshifter.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.context.UseOnContext;

public class RemoteControllerItem extends TieredItem {
    public RemoteControllerItem(Tier pTier, Properties pProperties) {
        super(pTier, pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        BlockPos positionClicked = pContext.getClickedPos();
        Player player = pContext.getPlayer();
        ItemStack itemStack = pContext.getItemInHand();

        // Cambiar esto en un futuro
        if (pContext.getLevel().isClientSide()) {
            pContext.getLevel().playSound(player, positionClicked, ModSounds.REMOTE_BUTTON_CLICKED.get(),
                    SoundSource.BLOCKS, 2f, 1f);
        }

        // Disminuir la durabilidad en 1
        itemStack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(pContext.getHand()));

        return super.useOn(pContext);
    }
}
