package com.psychopathic_dragon.vanilla_rubies.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.ingame.BeaconScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.BeaconScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerListener;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import com.psychopathic_dragon.vanilla_rubies.registry.Moditems;


@Mixin(BeaconScreen.class)
public class BeaconScreenMixin extends HandledScreen<BeaconScreenHandler> {
    private static final Identifier TEXTURE = new Identifier("textures/gui/container/beacon.png");
    private static final Text PRIMARY_POWER_TEXT = new TranslatableText("block.minecraft.beacon.primary");
    private static final Text SECONDARY_POWER_TEXT = new TranslatableText("block.minecraft.beacon.secondary");
    private boolean consumeGem;
    private StatusEffect primaryEffect;
    private StatusEffect secondaryEffect;

    public BeaconScreenMixin(final BeaconScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.backgroundWidth = 230;
        this.backgroundHeight = 219;
        handler.addListener(new ScreenHandlerListener() {
            public void onHandlerRegistered(ScreenHandler handlerx, DefaultedList<ItemStack> stacks) {
            }

            public void onSlotUpdate(ScreenHandler handlerx, int slotId, ItemStack stack) {
            }

            public void onPropertyUpdate(ScreenHandler handlerx, int property, int value) {
                BeaconScreenMixin.this.primaryEffect = handler.getPrimaryEffect();
                BeaconScreenMixin.this.secondaryEffect = handler.getSecondaryEffect();
                BeaconScreenMixin.this.consumeGem = true;
            }
        });
    }

    @Overwrite
    public void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.client.getTextureManager().bindTexture(TEXTURE);
        int i = (this.width - this.backgroundWidth) / 2;
        int j = (this.height - this.backgroundHeight) / 2;
        this.drawTexture(matrices, i, j, 0, 0, this.backgroundWidth, this.backgroundHeight);
        this.itemRenderer.zOffset = 100.0F;
        this.itemRenderer.renderInGuiWithOverrides(new ItemStack(Items.NETHERITE_INGOT), i + 10, j + 109);
        this.itemRenderer.renderInGuiWithOverrides(new ItemStack(Moditems.RUBY),i +31 ,j + 109 );
        this.itemRenderer.renderInGuiWithOverrides(new ItemStack(Items.EMERALD), i + 49, j + 109);
        this.itemRenderer.renderInGuiWithOverrides(new ItemStack(Items.DIAMOND), i + 68, j + 109);
        this.itemRenderer.renderInGuiWithOverrides(new ItemStack(Items.GOLD_INGOT), i + 88, j + 109);
        this.itemRenderer.renderInGuiWithOverrides(new ItemStack(Items.IRON_INGOT), i + 112, j + 109);
        this.itemRenderer.zOffset = 0.0F;
    }
}
