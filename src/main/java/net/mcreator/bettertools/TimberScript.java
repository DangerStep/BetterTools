package net.mcreator.bettertools;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.core.BlockPos;
import net.mcreator.bettertools.BetterToolsMod;

public class TimberScript {
	public TimberScript() {
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		new TimberScript();
	}

	@Mod.EventBusSubscriber
	private static class ForgeBusEvents {
		@SubscribeEvent
		public static void serverLoad(ServerStartingEvent event) {
		}

		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void clientLoad(FMLClientSetupEvent event) {
		}
	}

	public static void repeatChop(LevelAccessor world, int x, int y, int z) {
    for (int i = -1; i <= 1; i++) {
        for (int j = -1; j <= 1; j++) {
            for (int k = -1; k <= 1; k++) {
                final int[] position = new int[]{x, y, z};
                BlockPos pos = new BlockPos(position[0] + i, position[1] + j, position[2] + k);
                if (world.getBlockState(pos).is(BlockTags.LOGS)) {
                    world.destroyBlock(pos, true);
                    final int[] newPos = new int[]{position[0] + i, position[1] + j, position[2] + k};
                    BetterToolsMod.queueServerWork(1, () -> {
                        repeatChop(world, newPos[0], newPos[1], newPos[2]);
                    });
                }
            }
        }
    }
}

}
