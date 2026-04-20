package dev.nalan_tttt.noxaframe.client.framework.elements;

import dev.nalan_tttt.noxaframe.client.framework.utils.IRenderContext;
import dev.nalan_tttt.noxaframe.client.framework.utils.Icon;

import java.util.function.Consumer;
// TODO: finish.

/**
 * @apiNote This class is not finished.
 */
public class UIClickableIcon extends UIButton {
    private Icon icon;

    public UIClickableIcon(String text, int color, Icon icon, Consumer<UIButton> consumer) {
        super(text, color, consumer);
        this.icon = icon;
    }

    @Override
    public void render(IRenderContext context, int mouseX, int mouseY, float delta) {
        int offset = pressed ? 1 : 0;

        context.renderIcon(icon, this.width, this.height, this.x, this.y);

        int fontColor = 0xFFFFFFFF;
        context.drawText(text,  this.x + 4, this.y + 4 + offset, this.pressed ? darken(fontColor, 0.2f) : fontColor);
    }

    public UIClickableIcon icon(Icon icon) {
        this.icon = icon;
        return this;
    }
}
