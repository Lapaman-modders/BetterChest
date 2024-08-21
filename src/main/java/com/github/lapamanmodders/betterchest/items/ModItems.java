package com.github.lapamanmodders.betterchest.items;

import com.github.lapamanmodders.betterchest.BetterChest;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BetterChest.MOD_ID);

    public static final RegistryObject<Item> REMOTE = ITEMS.register("remote",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.REMOTE_TAB)));



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
