package com.github.lapamanmodders.comandshifter.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.phys.Vec3;

public class InvertControlsEffect extends MobEffect {

    public InvertControlsEffect() {
        super(MobEffectCategory.HARMFUL, 0x5A6C81); // Color y tipo de efecto (HARMFUL)
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (entity instanceof Mob) {
            Mob mobEntity = (Mob) entity;

            // Intentamos desactivar la IA momentáneamente
            mobEntity.getNavigation().stop();

            // Invertimos manualmente la dirección del movimiento
            Vec3 movement = mobEntity.getDeltaMovement();
            Vec3 invertedMovement = new Vec3(-movement.x(), -movement.y(), -movement.z());

            // Aplicar el nuevo vector de movimiento a la entidad
            mobEntity.setDeltaMovement(invertedMovement);
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true; // Aplica el efecto en cada tick mientras esté activo
    }
}
