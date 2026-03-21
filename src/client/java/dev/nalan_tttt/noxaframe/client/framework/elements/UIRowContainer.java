package dev.nalan_tttt.noxaframe.client.framework.elements;

/**
 * A container that positions child elements in a row.
 * @since 1.0-A
 * @see UIContainer
 * @see UIColumnContainer
 */
public class UIRowContainer extends UIContainer {
    private int spacing = 0;

    public UIRowContainer(int spacing) {
        this.spacing = spacing;
    }

    public UIRowContainer() {}

    @Override
    protected void onLayout() {

        int offsetX = 0;
        int maxHeight = 0;
        boolean first = true;

        for (UIElement child : getChildren()) {
            child.layout();
            if (first) {
                child.x(this.x + offsetX);
                first = false;
            } else {
                child.x(this.x + offsetX + spacing);
            }
            child.y(this.y);

            offsetX += child.width;

            if (child.height > maxHeight) {
                maxHeight = child.height;
            }
        }

        this.width = offsetX;
        this.height = maxHeight;
    }
}
