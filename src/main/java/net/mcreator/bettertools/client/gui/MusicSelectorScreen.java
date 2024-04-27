package net.mcreator.bettertools.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.bettertools.world.inventory.MusicSelectorMenu;
import net.mcreator.bettertools.network.MusicSelectorButtonMessage;
import net.mcreator.bettertools.BetterToolsMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class MusicSelectorScreen extends AbstractContainerScreen<MusicSelectorMenu> {
	private final static HashMap<String, Object> guistate = MusicSelectorMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Checkbox play_locally;
	Button button_rick_roll;
	Button button_baby_shark;
	Button button_doorbell_noise;
	Button button_stop;
	Button button_huh;

	public MusicSelectorScreen(MusicSelectorMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 306;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("better_tools:textures/screens/music_selector.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.better_tools.music_selector.label_music_selector"), 125, 7, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_rick_roll = Button.builder(Component.translatable("gui.better_tools.music_selector.button_rick_roll"), e -> {
			if (true) {
				BetterToolsMod.PACKET_HANDLER.sendToServer(new MusicSelectorButtonMessage(0, x, y, z));
				MusicSelectorButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 125, this.topPos + 25, 72, 20).build();
		guistate.put("button:button_rick_roll", button_rick_roll);
		this.addRenderableWidget(button_rick_roll);
		button_baby_shark = Button.builder(Component.translatable("gui.better_tools.music_selector.button_baby_shark"), e -> {
			if (true) {
				BetterToolsMod.PACKET_HANDLER.sendToServer(new MusicSelectorButtonMessage(1, x, y, z));
				MusicSelectorButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 125, this.topPos + 79, 77, 20).build();
		guistate.put("button:button_baby_shark", button_baby_shark);
		this.addRenderableWidget(button_baby_shark);
		button_doorbell_noise = Button.builder(Component.translatable("gui.better_tools.music_selector.button_doorbell_noise"), e -> {
			if (true) {
				BetterToolsMod.PACKET_HANDLER.sendToServer(new MusicSelectorButtonMessage(2, x, y, z));
				MusicSelectorButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 125, this.topPos + 106, 98, 20).build();
		guistate.put("button:button_doorbell_noise", button_doorbell_noise);
		this.addRenderableWidget(button_doorbell_noise);
		button_stop = Button.builder(Component.translatable("gui.better_tools.music_selector.button_stop"), e -> {
			if (true) {
				BetterToolsMod.PACKET_HANDLER.sendToServer(new MusicSelectorButtonMessage(3, x, y, z));
				MusicSelectorButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 251, this.topPos + 133, 46, 20).build();
		guistate.put("button:button_stop", button_stop);
		this.addRenderableWidget(button_stop);
		button_huh = Button.builder(Component.translatable("gui.better_tools.music_selector.button_huh"), e -> {
			if (true) {
				BetterToolsMod.PACKET_HANDLER.sendToServer(new MusicSelectorButtonMessage(4, x, y, z));
				MusicSelectorButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 125, this.topPos + 52, 46, 20).build();
		guistate.put("button:button_huh", button_huh);
		this.addRenderableWidget(button_huh);
		play_locally = new Checkbox(this.leftPos + 17, this.topPos + 133, 20, 20, Component.translatable("gui.better_tools.music_selector.play_locally"), false);
		guistate.put("checkbox:play_locally", play_locally);
		this.addRenderableWidget(play_locally);
	}
}
