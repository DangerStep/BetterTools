package net.mcreator.bettertools.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.bettertools.world.inventory.InfoGUIMenu;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class InfoGUIScreen extends AbstractContainerScreen<InfoGUIMenu> {
	private final static HashMap<String, Object> guistate = InfoGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

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

		guiGraphics.blit(new ResourceLocation("better_tools:textures/screens/quartz_sword.png"), this.leftPos + 24, this.topPos + 25, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("better_tools:textures/screens/quartz_pickaxe.png"), this.leftPos + 24, this.topPos + 52, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("better_tools:textures/screens/quartz_axe.png"), this.leftPos + 24, this.topPos + 79, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("better_tools:textures/screens/quartz_shovel.png"), this.leftPos + 24, this.topPos + 106, 0, 0, 16, 16, 16, 16);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.better_tools.info_gui.label_has_a_10_change_of_striking_lig"), 42, 25, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.better_tools.info_gui.label_striking_lighting"), 42, 34, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.better_tools.info_gui.label_converts_gold_or_copper_into_dia"), 42, 52, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.better_tools.info_gui.label_into_diamonds"), 42, 61, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.better_tools.info_gui.label_cuts_down_the_entire_tree_crouc"), 42, 79, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.better_tools.info_gui.label_crouch_to_disable"), 42, 88, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.better_tools.info_gui.label_super_shovel_mode"), 42, 106, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.better_tools.info_gui.label_rclick"), 42, 115, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.better_tools.info_gui.label_the_shovel_ability_has_a_cooldow"), 24, 133, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.better_tools.info_gui.label_cooldown_you_might_want_unbreak"), 24, 142, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.better_tools.info_gui.label_unbreaking_on_the_shovel"), 24, 151, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.better_tools.info_gui.label_be_careful"), 105, 43, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
	}
}
