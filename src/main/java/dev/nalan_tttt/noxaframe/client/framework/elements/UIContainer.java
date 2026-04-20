package dev.nalan_tttt.noxaframe.client.framework.elements;

import dev.nalan_tttt.noxaframe.client.framework.utils.IRenderContext;

import java.util.ArrayList;
import java.util.List;

/**
 * A basic container in which child elements decide their own position.
 * @apiNote Expand from this container if you want to make a new type of container.
 * @since 1.0-A
 * @see UIRowContainer
 * @see UIColumnContainer
 *
 */
public class UIContainer extends UIElement {
    private final List<UIElement> children = new ArrayList<>();

    public UIContainer(int width, int height) {
        this.width = width;
        this.height = height;
        this.x = 0;
        this.y = 0;
    }
    public UIContainer() {}

    public void addChild(UIElement child) {
        children.add(child);
        child.parent = this;
    }

    @Override
    protected void onLayout() {
        for (UIElement child : children) {
            child.layout();
        }
    }

    public void removeChild(UIElement child) {
        children.remove(child);
        child.parent = null;
    }

    protected List<UIElement> getChildren() {
        return children;
    }

    @Override
    public void render(IRenderContext context, int mouseX, int mouseY, float delta) {
        for (UIElement child : children) {
            child.render(context, mouseX, mouseY, delta);
        }
    }

    @Override
    public boolean onMouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
        for (int i = children.size() - 1; i >= 0; i--) {
            if (children.get(i).onMouseDragged(mouseX, mouseY, button, dragX, dragY)) return true;
        }
        return false;
    }

    @Override
    public boolean onMouseReleased(double mouseX, double mouseY, int button) {
        for (int i = children.size() - 1; i >= 0; i--) {
            if (children.get(i).onMouseReleased(mouseX, mouseY, button)) return true;
        }
        return false;
    }

    @Override
    public boolean onMouseClicked(double mouseX, double mouseY, int button) {
        for (int i = children.size() - 1; i >= 0; i--) {
            if (children.get(i).onMouseClicked(mouseX, mouseY, button)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean onKeyPressed(int keyCode, int scanCode, int modifiers) {
        for (int i = children.size() - 1; i >= 0; i--) {
            if (children.get(i).onKeyPressed(keyCode, scanCode, modifiers)) {
                return true;
            }
        }
        return false;
    }
}
