package dev.nalan_tttt.noxaframe.client.framework.utils;

import net.minecraft.client.gui.Font;
import net.minecraft.resources.ResourceLocation;

/**
 * Abstract renderer for compatibility with other minecraft versions
 */
public interface IRenderContext {
    void fillRect(int x, int y, int w, int h);
    void fillRect(int x, int y, int w, int h, int color);
    void drawText(String text, int x, int y, int color);
    void drawText(Font font, String text, int x, int y, int color);
    void drawTexture(ResourceLocation location, int x, int y);
    void drawTexture(ResourceLocation location, int x, int y, int width, int height);
    void drawTexture(ResourceLocation location, int x, int y, int u, int v, int iconSize, int widthTexture, int heightTexture);
    void renderIcon(Icon icon, int width, int height, int x, int y);
    void enableScissor(int x1, int y1, int x2, int y2);
    void disableScissor();
    String version();
}
