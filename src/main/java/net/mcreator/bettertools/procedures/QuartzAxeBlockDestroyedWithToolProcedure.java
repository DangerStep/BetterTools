package net.mcreator.bettertools.procedures;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.bettertools.TimberScript;

public class QuartzAxeBlockDestroyedWithToolProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		BlockPos pos = BlockPos.containing(x, y, z);
		BlockState state = world.getBlockState(pos);

		// Check if the block at the position is within the logs tag
		if (!entity.isShiftKeyDown() && state.is(BlockTags.LOGS)) {
			TimberScript.repeatChop(world, (int) x, (int) y, (int) z);
		}
	}
}
