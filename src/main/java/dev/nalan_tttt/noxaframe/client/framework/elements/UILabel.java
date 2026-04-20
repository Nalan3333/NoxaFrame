package dev.nalan_tttt.noxaframe.client.framework.elements;

import dev.nalan_tttt.noxaframe.client.framework.utils.IRenderContext;

/**
 * A label in NoxaFrame UI API.
 * @since 1.0-A
 *
 */
public class UILabel extends UIElement {
    private String text = "";
    private int color = 0xFFFFFFFF;

    /**
     * @param text label text.
     * @param color text color.
     */
    public UILabel(String text, int color) {
        this.text = text;
        this.color = color;
    }

    /**
     * @param text label text.
     */
    public UILabel(String text) {
        this.text = text;
    }
    public UILabel() {}

    @Override
    public void render(IRenderContext context, int mouseX, int mouseY, float delta) {
        context.drawText(text, this.x, this.y, this.color);
    }

    public String getText() {
        return text;
    }
    public UILabel text(String text) {
        this.text = text;
        return this;
    }
    public int getColor() {
        return color;
    }
    public UILabel color(int color) {
        this.color = color;
        return this;
    }
}
