
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.bettertools.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.bettertools.BetterToolsMod;

public class BetterToolsModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BetterToolsMod.MODID);
	public static final RegistryObject<CreativeModeTab> BETTER_TOOLS_TAB = REGISTRY.register("better_tools_tab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.better_tools.better_tools_tab")).icon(() -> new ItemStack(BetterToolsModItems.QUARTZ_SWORD.get())).displayItems((parameters, tabData) -> {
				tabData.accept(BetterToolsModItems.QUARTZ_SWORD.get());
				tabData.accept(BetterToolsModItems.QUARTZ_PICKAXE.get());
				tabData.accept(BetterToolsModItems.QUARTZ_AXE.get());
				tabData.accept(BetterToolsModItems.QUARTZ_SHOVEL.get());
				tabData.accept(BetterToolsModItems.EMERALD_SWORD.get());
			})

					.build());
}
