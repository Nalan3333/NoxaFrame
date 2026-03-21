package dev.nalan_tttt.noxaframe.client.framework.utils;

import net.minecraft.resources.ResourceLocation;

/**
 * Icon data for UIIcon.
 * @since 1.0-A
 * @see dev.nalan_tttt.noxaframe.client.framework.elements.UIIcon
 */
public class Icon {
    private final int widthTexture;
    private final int heightTexture;
    private final int iconWidth;
    private final int iconHeight;
    private final int u;
    private final int v;
    private final ResourceLocation texture;

    public Icon(ResourceLocation texture, int iconWidth, int iconHeight, int u, int v, int widthTexture, int heightTexture) {
        this.texture = texture;
        this.iconWidth = iconWidth;
        this.iconHeight = iconHeight;
        this.u = u;
        this.v = v;
        this.widthTexture = widthTexture;
        this.heightTexture = heightTexture;
    }
    public int getWidthTexture() {
        return widthTexture;
    }

    public int getHeightTexture() {
        return heightTexture;
    }

    public ResourceLocation getTexture() {
        return texture;
    }

    public int getU() {
        return u;
    }

    public int getV() {
        return v;
    }

    public int getIconWidth() {
        return iconWidth;
    }

    public int getIconHeight() {
        return iconHeight;
    }
}
