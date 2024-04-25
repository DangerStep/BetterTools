package net.mcreator.bettertools.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.bettertools.world.inventory.InfoGUI2Menu;
import net.mcreator.bettertools.network.InfoGUI2ButtonMessage;
import net.mcreator.bettertools.BetterToolsMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class InfoGUI2Screen extends AbstractContainerScreen<InfoGUI2Menu> {
	private final static HashMap<String, Object> guistate = InfoGUI2Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_arrow_right;

	public InfoGUI2Screen(InfoGUI2Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("better_tools:textures/screens/info_gui_2.png");

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

		guiGraphics.blit(new ResourceLocation("better_tools:textures/screens/emerald_sword.png"), this.leftPos + 15, this.topPos + 25, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("better_tools:textures/screens/amethyst_sword.png"), this.leftPos + 15, this.topPos + 52, 0, 0, 16, 16, 16, 16);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.better_tools.info_gui_2.label_better_tools_info"), 42, 7, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.better_tools.info_gui_2.label_22"), 141, 7, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.better_tools.info_gui_2.label_has_a_25_chance_of_making_the_e"), 33, 25, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.better_tools.info_gui_2.label_the_entity_drop_their_weapon"), 33, 34, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.better_tools.info_gui_2.label_to_be_continued"), 42, 97, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.better_tools.info_gui_2.label_converts_logs_straight_into_plan"), 33, 52, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.better_tools.info_gui_2.label_into_planks"), 33, 61, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.better_tools.info_gui_2.label_you_kill_something"), 33, 70, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_arrow_right = new ImageButton(this.leftPos + 15, this.topPos + 142, 16, 16, 0, 0, 16, new ResourceLocation("better_tools:textures/screens/atlas/imagebutton_arrow_right.png"), 16, 32, e -> {
			if (true) {
				BetterToolsMod.PACKET_HANDLER.sendToServer(new InfoGUI2ButtonMessage(0, x, y, z));
				InfoGUI2ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_arrow_right", imagebutton_arrow_right);
		this.addRenderableWidget(imagebutton_arrow_right);
	}
}
