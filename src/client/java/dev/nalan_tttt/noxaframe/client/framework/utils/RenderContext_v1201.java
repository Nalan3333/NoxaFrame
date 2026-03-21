package dev.nalan_tttt.noxaframe.client.framework.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;

/**
 * Realization with IRenderContext for 1.20.1.
 * @see IRenderContext
 * @since 1.0-A
 */
public class RenderContext_v1201 implements IRenderContext {
    private final GuiGraphics graphics;
    public RenderContext_v1201(GuiGraphics graphics) {
        this.graphics = graphics;
    }

    @Override
    public void fillRect(int x, int y, int w, int h) {
        graphics.fill(x, y, x + w, y + h, 0xFFFFFFFF);
    }

    @Override
    public void fillRect(int x, int y, int w, int h, int color) {
        graphics.fill(x, y, x + w, y + h, color);
    }

    @Override
    public void drawText(String text, int x, int y, int color) {
        graphics.drawString(Minecraft.getInstance().font, text, x, y, color);
    }

    @Override
    public void drawText(Font font, String text, int x, int y, int color) {
        graphics.drawString(font, text, x, y, color);
    }

    @Override
    public void drawTexture(ResourceLocation location, int x, int y) {
        graphics.blit(location, x, y, 16, 16, 0, 0);
    }

    @Override
    public void drawTexture(ResourceLocation location, int x, int y, int width, int height) {
        graphics.blit(location, x, y, 0, 0, width, height);
    }

    @Override
    public void disableScissor() {
        graphics.disableScissor();
    }

    @Override
    public void enableScissor(int x1, int y1, int x2, int y2) {
        graphics.enableScissor(x1, y1, x2, y2);
    }

    @Override
    public void drawTexture(ResourceLocation location, int x, int y, int u, int v, int iconSize, int widthTexture, int heightTexture) {
        graphics.blit(location,
                x, y,
                u, v,
                iconSize, iconSize,
                widthTexture, heightTexture);
    }

    @Override
    public void renderIcon(Icon icon, int width, int height, int x, int y) {
        graphics.blit(
                icon.getTexture(),
                x, y,
                width, height,
                icon.getU(), icon.getV(),
                icon.getIconWidth(),
                icon.getIconHeight(),
                icon.getWidthTexture(),
                icon.getHeightTexture()
        );
    }

    @Override
    public String version() {
        return "1.20.1";
    }
}
