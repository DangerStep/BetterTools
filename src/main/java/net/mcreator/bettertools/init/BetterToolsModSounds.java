
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.bettertools.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.bettertools.BetterToolsMod;

public class BetterToolsModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, BetterToolsMod.MODID);
	public static final RegistryObject<SoundEvent> RICK_ROLL = REGISTRY.register("rick-roll", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("better_tools", "rick-roll")));
	public static final RegistryObject<SoundEvent> HUH = REGISTRY.register("huh", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("better_tools", "huh")));
	public static final RegistryObject<SoundEvent> BABY_SHARK = REGISTRY.register("baby-shark", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("better_tools", "baby-shark")));
	public static final RegistryObject<SoundEvent> DOORBELL = REGISTRY.register("doorbell", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("better_tools", "doorbell")));
}
