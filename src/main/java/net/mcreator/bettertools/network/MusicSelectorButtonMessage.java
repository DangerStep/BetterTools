
package net.mcreator.bettertools.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.bettertools.world.inventory.MusicSelectorMenu;
import net.mcreator.bettertools.procedures.OnButtonClickedRickRollProcedure;
import net.mcreator.bettertools.procedures.OnButtonClickedHuhProcedure;
import net.mcreator.bettertools.procedures.OnButtonClickedDoorbellProcedure;
import net.mcreator.bettertools.procedures.OnButtonClickedBabySharkProcedure;
import net.mcreator.bettertools.procedures.MusicBoxBlockDestroyedByPlayerProcedure;
import net.mcreator.bettertools.BetterToolsMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MusicSelectorButtonMessage {
	private final int buttonID, x, y, z;

	public MusicSelectorButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public MusicSelectorButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(MusicSelectorButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(MusicSelectorButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = MusicSelectorMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			OnButtonClickedRickRollProcedure.execute(world, x, y, z);
		}
		if (buttonID == 1) {

			OnButtonClickedBabySharkProcedure.execute(world, x, y, z);
		}
		if (buttonID == 2) {

			OnButtonClickedDoorbellProcedure.execute(world, x, y, z);
		}
		if (buttonID == 3) {

			MusicBoxBlockDestroyedByPlayerProcedure.execute(world, x, y, z);
		}
		if (buttonID == 4) {

			OnButtonClickedHuhProcedure.execute(world, x, y, z);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		BetterToolsMod.addNetworkMessage(MusicSelectorButtonMessage.class, MusicSelectorButtonMessage::buffer, MusicSelectorButtonMessage::new, MusicSelectorButtonMessage::handler);
	}
}
