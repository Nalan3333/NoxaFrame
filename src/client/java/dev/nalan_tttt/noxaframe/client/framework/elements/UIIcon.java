package dev.nalan_tttt.noxaframe.client.framework.elements;

import dev.nalan_tttt.noxaframe.client.framework.utils.IRenderContext;
import dev.nalan_tttt.noxaframe.client.framework.utils.Icon;

/**
 * Icon element for NoxaFrame UI API
 * @since 1.0-A
 */
public class UIIcon extends UIElement {
    private Icon icon;
    public UIIcon(Icon icon) {
        this.icon = icon;
    }

    @Override
    public void render(IRenderContext context, int mouseX, int mouseY, float delta) {
        context.renderIcon(icon, this.width, this.height, this.x, this.y);
    }

    public Icon getIcon() {
        return icon;
    }

    public void icon(Icon icon) {
        this.icon = icon;
    }
}
