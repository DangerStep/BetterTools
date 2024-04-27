
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.bettertools.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.bettertools.block.MusicBoxBlock;
import net.mcreator.bettertools.BetterToolsMod;

public class BetterToolsModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, BetterToolsMod.MODID);
	public static final RegistryObject<Block> MUSIC_BOX = REGISTRY.register("music_box", () -> new MusicBoxBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
