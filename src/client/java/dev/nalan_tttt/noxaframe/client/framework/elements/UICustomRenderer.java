package dev.nalan_tttt.noxaframe.client.framework.elements;

import dev.nalan_tttt.noxaframe.client.framework.utils.IRenderContext;

import java.util.function.Consumer;

public class UICustomRenderer extends UIElement {
    private Consumer<IRenderContext> customRenderer = (ctx) -> {};

    public UICustomRenderer(Consumer<IRenderContext> customRenderer) {
        this.customRenderer = customRenderer;
    }

    @Override
    public void render(IRenderContext context, int mouseX, int mouseY, float delta) {
        customRenderer.accept(context);
    }
}
