package com.psychopathic_dragon.vanilla_rubies.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.MerchantScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.MerchantScreenHandler;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
@Environment(EnvType.CLIENT)
@Mixin(MerchantScreen.class)
public abstract class MerchantScreenMixin extends HandledScreen<MerchantScreenHandler> {
    private static final Identifier TEXTURE = new Identifier("textures/gui/container/villager2.png");
    private static final Text TRADES_TEXT = new TranslatableText("merchant.trades");
    private static final Text SEPARATOR = new LiteralText(" - ");

    public MerchantScreenMixin(MerchantScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.backgroundWidth = 276;
        this.playerInventoryTitleX = 107;}

    @Overwrite
    public void drawForeground(MatrixStack matrices, int mouseX, int mouseY) {
        int i = ((MerchantScreenHandler)this.handler).getLevelProgress();
        if (i > 0 && i <= 6 && ((MerchantScreenHandler)this.handler).isLeveled()) {
            Text text = this.title.shallowCopy().append(SEPARATOR).append(new TranslatableText("merchant.level." + i));
            int j = this.textRenderer.getWidth(text);
            int k = 49 + this.backgroundWidth / 2 - j / 2;
            this.textRenderer.draw(matrices, text, (float)k, 6.0F, 4210752);
        } else {
            this.textRenderer.draw(matrices, this.title, (float)(49 + this.backgroundWidth / 2 - this.textRenderer.getWidth(this.title) / 2), 6.0F, 4210752);
        }

        this.textRenderer.draw(matrices, this.playerInventory.getDisplayName(), (float)this.playerInventoryTitleX, (float)this.playerInventoryTitleY, 4210752);
        int l = this.textRenderer.getWidth(TRADES_TEXT);
        this.textRenderer.draw(matrices, TRADES_TEXT, (float)(6 - l / 2 + 48), 6.0F, 4210752);
    }
    @Overwrite
    private void drawLevelInfo(MatrixStack matrices, int x, int y, TradeOffer tradeOffer) {
        this.client.getTextureManager().bindTexture(TEXTURE);
        int i = ((MerchantScreenHandler)this.handler).getLevelProgress();
        int j = ((MerchantScreenHandler)this.handler).getExperience();
        if (i < 6) {
            drawTexture(matrices, x + 136, y + 16, this.getZOffset(), 0.0F, 186.0F, 102, 5, 256, 512);
            int k = VillagerData.getLowerLevelExperience(i);
            if (j >= k && VillagerData.canLevelUp(i)) {

                float f = 100.0F / (float)(VillagerData.getUpperLevelExperience(i) - k);
                int m = Math.min(MathHelper.floor(f * (float)(j - k)), 100);
                drawTexture(matrices, x + 136, y + 16, this.getZOffset(), 0.0F, 191.0F, m + 1, 5, 256, 512);
                int n = ((MerchantScreenHandler)this.handler).getMerchantRewardedExperience();
                if (n > 0) {
                    int o = Math.min(MathHelper.floor((float)n * f), 100 - m);
                    drawTexture(matrices, x + 136 + m + 1, y + 16 + 1, this.getZOffset(), 2.0F, 182.0F, o, 3, 256, 512);
                }

            }
        }
    }


    }







