package net.mcreator.bettertools.procedures;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.bettertools.TimberScript;

public class QuartzAxeBlockDestroyedWithToolProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (!entity.isShiftKeyDown() && world.getBlockState(new BlockPos((int)x, (int)y, (int)z)).is(BlockTags.LOGS)) {
            TimberScript.repeatChop(world, (int) x, (int) y, (int) z);
        }
    }
}
