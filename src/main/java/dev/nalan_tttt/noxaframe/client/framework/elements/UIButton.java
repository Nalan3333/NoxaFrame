package dev.nalan_tttt.noxaframe.client.framework.elements;

import dev.nalan_tttt.noxaframe.client.framework.utils.IRenderContext;

import java.util.function.Consumer;

/**
 * A button in NoxaFrame UI API.
 * @since 1.0-A
 */
public class UIButton extends UIElement {
    protected String text;
    protected final Consumer<UIButton> consumer;
    protected int color;
    public boolean pressed;

    /**
     * @param text button text.
     * @param color color background for button
     * @param consumer invoke if button is pressed.
     */
    public UIButton(String text, int color, Consumer<UIButton> consumer) {
        this.text = text;
        this.consumer = consumer;
        this.color = color;
    }

    @Override
    public boolean onMouseReleased(double mouseX, double mouseY, int button) {
        if (pressed && isInside(mouseX, mouseY)) {
            consumer.accept(this);
            pressed = false;
            return true;
        }
        pressed = false;
        return false;
    }

    @Override
    public boolean onMouseClicked(double mouseX, double mouseY, int button) {
        if (isInside(mouseX, mouseY)) {
            pressed = true;
            return true;
        }
        return false;
    }

    @Override
    public void render(IRenderContext context, int mouseX, int mouseY, float delta) {
        int offset = pressed ? 1 : 0;

        context.fillRect(this.x, this.y + offset, this.width, this.height,  pressed ? darken(color, 0.2f) : color);

        int fontColor = 0xFFFFFFFF;
        context.drawText(text,  this.x + 4, this.y + 4 + offset, fontColor);
    }

    protected int darken(int color, float factor) {
        int a = (color >> 24) & 0xFF;
        int r = (color >> 16) & 0xFF;
        int g = (color >> 8) & 0xFF;
        int b = color & 0xFF;

        r *= (1 - factor);
        g *= (1 - factor);
        b *= (1 - factor);

        return (a << 24) | (r << 16) | (g << 8) | b;
    }

    public boolean isInside(double mouseX, double mouseY) {
        return mouseX >= x && mouseX <= x + width &&
                mouseY >= y && mouseY <= y + height;
    }

    public String getText() {
        return text;
    }

    public UIButton text(String text) {
        this.text = text;
        return this;
    }

    public int getColor() {
        return color;
    }
    public UIButton color(int color) {
        this.color = color;
        return this;
    }
}
