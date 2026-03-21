package dev.nalan_tttt.noxaframe.client.framework;

import dev.nalan_tttt.noxaframe.client.framework.elements.UIContainer;
import dev.nalan_tttt.noxaframe.client.framework.utils.IRenderContext;
import dev.nalan_tttt.noxaframe.client.framework.utils.RenderContext_v1201;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

/**
 * A gui-base for NoxaFrame UI API.
 * @since 1.0-A
 *
 */
public class GUI extends Screen {
    UIContainer root;

    public GUI() {
        super(Component.empty());
    }

    @Override
    public void init() {
        super.init();
        Minecraft minecraft = Minecraft.getInstance();
        int height = minecraft.getWindow().getGuiScaledHeight();
        int width = minecraft.getWindow().getGuiScaledWidth();
        root = new UIContainer(width, height);
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float delta) {
        this.renderBackground(graphics);
        IRenderContext context = new RenderContext_v1201(graphics);
        int height = Minecraft.getInstance().getWindow().getGuiScaledHeight();
        int width = Minecraft.getInstance().getWindow().getGuiScaledWidth();
        root.wh(width, height);
        root.xy(0, 0);
        root.layout();
        root.render(context, mouseX, mouseY, delta);
    }
    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (root.onMouseClicked(mouseX, mouseY, button)) return true;

        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (root.onKeyPressed(keyCode, scanCode, modifiers)) return true;

        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        if (root.onMouseReleased(mouseX, mouseY, button)) return true;

        return super.mouseReleased(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
        if (root.onMouseDragged(mouseX, mouseY, button, dragX, dragY)) return true;

        return super.mouseDragged(mouseX, mouseY, button, dragX, dragY);
    }
}
