
package net.mcreator.bettertools.item;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class AmethystSwordItem extends SwordItem {
	public AmethystSwordItem() {
		super(new Tier() {
			public int getUses() {
				return 1350;
			}

			public float getSpeed() {
				return 6f;
			}

			public float getAttackDamageBonus() {
				return 1f;
			}

			public int getLevel() {
				return 3;
			}

			public int getEnchantmentValue() {
				return 10;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Blocks.AMETHYST_CLUSTER), new ItemStack(Items.AMETHYST_SHARD));
			}
		}, 3, -3.6f, new Item.Properties());
	}
}
