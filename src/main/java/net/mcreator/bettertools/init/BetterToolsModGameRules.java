
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.bettertools.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BetterToolsModGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> DO_SPECIAL_ABILITIES = GameRules.register("doSpecialAbilities", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
}
