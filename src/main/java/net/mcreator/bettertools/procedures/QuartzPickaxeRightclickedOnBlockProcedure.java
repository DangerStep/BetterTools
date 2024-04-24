package net.mcreator.bettertools.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.bettertools.init.BetterToolsModGameRules;

import java.util.Map;

public class QuartzPickaxeRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		if (!entity.isShiftKeyDown() && world.getLevelData().getGameRules().getBoolean(BetterToolsModGameRules.DO_SPECIAL_ABILITIES)) {
			if (blockstate == Blocks.GOLD_ORE.defaultBlockState() || blockstate == Blocks.COPPER_ORE.defaultBlockState()) {
				{
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockState _bs = Blocks.DIAMOND_ORE.defaultBlockState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
						if (_property != null && _bs.getValue(_property) != null)
							try {
								_bs = _bs.setValue(_property, (Comparable) entry.getValue());
							} catch (Exception e) {
							}
					}
					world.setBlock(_bp, _bs, 3);
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.COMPOSTER, x, y, z, 20, 1, 1, 1, 1);
			} else if (blockstate == Blocks.DEEPSLATE_GOLD_ORE.defaultBlockState() || blockstate == Blocks.DEEPSLATE_COPPER_ORE.defaultBlockState()) {
				{
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockState _bs = Blocks.DEEPSLATE_DIAMOND_ORE.defaultBlockState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
						if (_property != null && _bs.getValue(_property) != null)
							try {
								_bs = _bs.setValue(_property, (Comparable) entry.getValue());
							} catch (Exception e) {
							}
					}
					world.setBlock(_bp, _bs, 3);
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.COMPOSTER, x, y, z, 20, 1, 1, 1, 1);
			}
		}
	}
}
