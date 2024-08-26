package com.github.lapamanmodders.comandshifter.items.custom;

import com.github.lapamanmodders.comandshifter.effects.ModEffects;
import com.github.lapamanmodders.comandshifter.sound.ModSounds;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.level.Level;

public class RemoteControllerItem extends TieredItem {
    private static final int COOLDOWN_SECONDS = 3;

    public RemoteControllerItem(Tier pTier, Properties pProperties) {
        super(pTier, pProperties);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity target, InteractionHand hand) {
        Level level = player.level;

        // Verifica si el ítem está en cooldown
        if (player.getCooldowns().isOnCooldown(this)) {
            return InteractionResult.PASS;
        }

        // Verifica si el código se está ejecutando en el cliente (lado del jugador)
        if (level.isClientSide()) {
            level.playSound(player, player.blockPosition(), ModSounds.REMOTE_BUTTON_CLICKED.get(),
                    SoundSource.PLAYERS, 2f, 1f);
        }

        // Aplicar el efecto de invertir controles durante 10 segundos
        target.addEffect(new MobEffectInstance(ModEffects.INVERT_CONTROLS.get(), 200, 0)); // 200 ticks = 10 segundos

        // Establecer un cooldown de 3 segundos en el ítem
        player.getCooldowns().addCooldown(this, COOLDOWN_SECONDS * 20); // 20 ticks por segundo

        // Disminuir la durabilidad en 1
        stack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(hand));

        // Retorna SUCCESS si todo va bien
        return InteractionResult.sidedSuccess(level.isClientSide());
    }
}
