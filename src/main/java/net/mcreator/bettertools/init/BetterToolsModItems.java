
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.bettertools.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.bettertools.item.QuartzSwordItem;
import net.mcreator.bettertools.item.QuartzShovelItem;
import net.mcreator.bettertools.item.QuartzPickaxeItem;
import net.mcreator.bettertools.item.QuartzAxeItem;
import net.mcreator.bettertools.item.ModInfoItem;
import net.mcreator.bettertools.item.EmeraldSwordItem;
import net.mcreator.bettertools.item.AmethystSwordItem;
import net.mcreator.bettertools.BetterToolsMod;

public class BetterToolsModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, BetterToolsMod.MODID);
	public static final RegistryObject<Item> QUARTZ_SWORD = REGISTRY.register("quartz_sword", () -> new QuartzSwordItem());
	public static final RegistryObject<Item> QUARTZ_PICKAXE = REGISTRY.register("quartz_pickaxe", () -> new QuartzPickaxeItem());
	public static final RegistryObject<Item> QUARTZ_AXE = REGISTRY.register("quartz_axe", () -> new QuartzAxeItem());
	public static final RegistryObject<Item> QUARTZ_SHOVEL = REGISTRY.register("quartz_shovel", () -> new QuartzShovelItem());
	public static final RegistryObject<Item> EMERALD_SWORD = REGISTRY.register("emerald_sword", () -> new EmeraldSwordItem());
	public static final RegistryObject<Item> MOD_INFO = REGISTRY.register("mod_info", () -> new ModInfoItem());
	public static final RegistryObject<Item> AMETHYST_SWORD = REGISTRY.register("amethyst_sword", () -> new AmethystSwordItem());
	public static final RegistryObject<Item> MUSIC_BOX = block(BetterToolsModBlocks.MUSIC_BOX);

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
