package com.github.lapamanmodders.comandshifter.items;

import com.github.lapamanmodders.comandshifter.ComandShifter;
import com.github.lapamanmodders.comandshifter.items.custom.RemoteControllerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ComandShifter.MOD_ID);

    public static final RegistryObject<Item> REMOTE = ITEMS.register("comandshiftercobre",
            () -> new RemoteControllerItem(Tiers.WOOD,new Item.Properties().tab(ModCreativeModeTab.REMOTE_TAB)));

    public static final RegistryObject<Item> REMOTE2 = ITEMS.register("comandshifterhierro",
            () -> new RemoteControllerItem(Tiers.WOOD,new Item.Properties().tab(ModCreativeModeTab.REMOTE_TAB)));

    public static final RegistryObject<Item> REMOTE3 = ITEMS.register("comandshifteroro",
            () -> new RemoteControllerItem(Tiers.WOOD,new Item.Properties().tab(ModCreativeModeTab.REMOTE_TAB)));

    public static final RegistryObject<Item> REMOTE4 = ITEMS.register("comandshifterdiamante",
            () -> new RemoteControllerItem(Tiers.WOOD,new Item.Properties().tab(ModCreativeModeTab.REMOTE_TAB)));

    public static final RegistryObject<Item> REMOTE5 = ITEMS.register("comandshifternetherite",
            () -> new RemoteControllerItem(Tiers.WOOD,new Item.Properties().tab(ModCreativeModeTab.REMOTE_TAB)));



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
