
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.bettertools.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.bettertools.client.gui.MusicSelectorScreen;
import net.mcreator.bettertools.client.gui.InfoGUIScreen;
import net.mcreator.bettertools.client.gui.InfoGUI2Screen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BetterToolsModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(BetterToolsModMenus.INFO_GUI.get(), InfoGUIScreen::new);
			MenuScreens.register(BetterToolsModMenus.INFO_GUI_2.get(), InfoGUI2Screen::new);
			MenuScreens.register(BetterToolsModMenus.MUSIC_SELECTOR.get(), MusicSelectorScreen::new);
		});
	}
}
