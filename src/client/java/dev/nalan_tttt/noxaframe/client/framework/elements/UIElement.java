package dev.nalan_tttt.noxaframe.client.framework.elements;

import dev.nalan_tttt.noxaframe.client.framework.utils.IRenderContext;

/**
 * Basic UI-element NoxaFrame UI API.
 * @apiNote everyone UI-elements NoxaFrame UI API must have extended at UIElement.
 * @since 1.0-A
 */
public abstract class UIElement {
    private Float relativeX;
    private Float relativeY;
    private Float relativeWidth;
    private Float relativeHeight;

    protected int x = 0;
    protected int y = 0;
    protected int width = 0;
    protected int height = 0;

    protected UIContainer parent;

    public final void layout() {
        if (parent != null) {
            if (relativeX != null) this.x = parent.x + (int)(parent.width * relativeX);
            if (relativeY != null) this.y = parent.y + (int)(parent.height * relativeY);
            if (relativeWidth != null) this.width = (int)(parent.width * relativeWidth);
            if (relativeHeight != null) this.height = (int)(parent.height * relativeHeight);
        }
        onLayout();
    }

    public UIElement x(float x) {
        this.relativeX = x;
        return this;
    }
    public UIElement y(float y) {
        this.relativeY = y;
        return this;
    }
    public UIElement x(int x) {
        this.x = x;
        return this;
    }
    public UIElement y(int y) {
        this.y = y;
        return this;
    }
    public UIElement xy(int x, int y) {
        this.x = x;
        this.y = y;
        return this;
    }
    public UIElement xy(float x, float y) {
        this.relativeY = y;
        this.relativeX = x;
        return this;
    }
    public UIElement w(float width) {
        this.relativeWidth = width;
        return this;
    }
    public UIElement h(float height) {
        this.relativeHeight = height;
        return this;
    }
    public UIElement wh(float width, float height) {
        this.relativeWidth = width;
        this.relativeHeight = height;
        return this;
    }
    public UIElement w(int width) {
        this.width = width;
        return this;
    }
    public UIElement h(int height) {
        this.height = height;
        return this;
    }
    public UIElement wh(int width, int height) {
        this.width = width;
        this.height = height;
        return this;
    }
    public float getRelativeX() {
        return relativeX;
    }
    public float getRelativeY() {
        return relativeY;
    }
    public float getRelativeWidth() {
        return relativeWidth;
    }
    public float getRelativeHeight() {
        return relativeHeight;
    }

    protected void onLayout() {

    }

    public boolean onMouseClicked(double mouseX, double mouseY, int button) {
        return false;
    }
    public boolean onKeyPressed(int keyCode, int scanCode, int modifiers) {
        return false;
    }
    public boolean onMouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
        return false;
    }
    public boolean onMouseReleased(double mouseX, double mouseY, int button) {
        return false;
    }
    public abstract void render(IRenderContext context, int mouseX, int mouseY, float delta);
}
