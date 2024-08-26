package com.github.lapamanmodders.comandshifter.effects;

import com.github.lapamanmodders.comandshifter.ComandShifter;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, ComandShifter.MOD_ID);

    public static final RegistryObject<MobEffect> INVERT_CONTROLS = EFFECTS.register("invert_controls", InvertControlsEffect::new);
}
