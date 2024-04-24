package net.mcreator.bettertools.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.bettertools.world.inventory.InfoGUIMenu;
import net.mcreator.bettertools.network.InfoGUIButtonMessage;
import net.mcreator.bettertools.BetterToolsMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class InfoGUIScreen extends AbstractContainerScreen<InfoGUIMenu> {
	private final static HashMap<String, Object> guistate = InfoGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_arrow;

	public InfoGUIScreen(InfoGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("better_tools:textures/screens/info_gui.png");

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

		guiGraphics.blit(new ResourceLocation("better_tools:textures/screens/quartz_sword.png"), this.leftPos + 15, this.topPos + 25, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("better_tools:textures/screens/quartz_pickaxe.png"), this.leftPos + 15, this.topPos + 52, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("better_tools:textures/screens/quartz_axe.png"), this.leftPos + 15, this.topPos + 79, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("better_tools:textures/screens/quartz_shovel.png"), this.leftPos + 15, this.topPos + 106, 0, 0, 16, 16, 16, 16);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.better_tools.info_gui.label_better_tools_info"), 42, 7, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.better_tools.info_gui.label_has_a_10_change_of_striking_lig"), 33, 25, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.better_tools.info_gui.label_striking_lighting"), 33, 34, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.better_tools.info_gui.label_converts_gold_or_copper_into_dia"), 33, 52, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.better_tools.info_gui.label_into_diamonds"), 33, 61, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.better_tools.info_gui.label_cuts_down_the_entire_tree_crouc"), 33, 79, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.better_tools.info_gui.label_crouch_to_disable"), 33, 88, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.better_tools.info_gui.label_super_shovel_mode"), 33, 106, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.better_tools.info_gui.label_rclick"), 33, 115, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.better_tools.info_gui.label_the_shovel_ability_has_a_cooldow"), 15, 133, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.better_tools.info_gui.label_cooldown_you_might_want_unbreak"), 15, 142, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.better_tools.info_gui.label_unbreaking_on_the_shovel"), 15, 151, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.better_tools.info_gui.label_12"), 141, 7, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_arrow = new ImageButton(this.leftPos + 150, this.topPos + 142, 16, 16, 0, 0, 16, new ResourceLocation("better_tools:textures/screens/atlas/imagebutton_arrow.png"), 16, 32, e -> {
			if (true) {
				BetterToolsMod.PACKET_HANDLER.sendToServer(new InfoGUIButtonMessage(0, x, y, z));
				InfoGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_arrow", imagebutton_arrow);
		this.addRenderableWidget(imagebutton_arrow);
	}
}
