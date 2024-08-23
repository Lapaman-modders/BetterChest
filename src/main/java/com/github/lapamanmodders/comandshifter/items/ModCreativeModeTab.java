package com.github.lapamanmodders.comandshifter.items;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab REMOTE_TAB = new CreativeModeTab("comandshiftertab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.REMOTE.get());
        }
    };
}
