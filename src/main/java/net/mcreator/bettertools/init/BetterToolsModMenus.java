
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.bettertools.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.bettertools.world.inventory.MusicSelectorMenu;
import net.mcreator.bettertools.world.inventory.InfoGUIMenu;
import net.mcreator.bettertools.world.inventory.InfoGUI2Menu;
import net.mcreator.bettertools.BetterToolsMod;

public class BetterToolsModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, BetterToolsMod.MODID);
	public static final RegistryObject<MenuType<InfoGUIMenu>> INFO_GUI = REGISTRY.register("info_gui", () -> IForgeMenuType.create(InfoGUIMenu::new));
	public static final RegistryObject<MenuType<InfoGUI2Menu>> INFO_GUI_2 = REGISTRY.register("info_gui_2", () -> IForgeMenuType.create(InfoGUI2Menu::new));
	public static final RegistryObject<MenuType<MusicSelectorMenu>> MUSIC_SELECTOR = REGISTRY.register("music_selector", () -> IForgeMenuType.create(MusicSelectorMenu::new));
}
