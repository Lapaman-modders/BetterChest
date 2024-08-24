package com.github.lapamanmodders.comandshifter.sound;

import com.github.lapamanmodders.comandshifter.ComandShifter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ComandShifter.MOD_ID);

    public static final RegistryObject<SoundEvent> REMOTE_BUTTON_CLICKED =
            registerSoundEvent("remote_button_clicked");

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(ComandShifter.MOD_ID, name)));
    };

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
