package dev.nalan_tttt.noxaframe.client.framework.elements;

/**
 * A container that positions child elements in a column.
 * @since 1.0-A
 * @see UIContainer
 * @see UIRowContainer
 */
public class UIColumnContainer extends UIContainer {
    private int spacing = 0;

    public UIColumnContainer(int spacing) {
        this.spacing = spacing;
    }

    public UIColumnContainer() {}

    @Override
    protected void onLayout() {

        int offsetY = 0;
        int maxWidth = 0;
        boolean first = true;

        for (UIElement child : getChildren()) {

            child.layout();

            if (!first) {
                offsetY += spacing;
            }

            child.x(this.x);
            child.y(this.y + offsetY);

            offsetY += child.height;

            if (child.width > maxWidth) {
                maxWidth = child.width;
            }

            first = false;
        }

        this.height = offsetY;
        this.width = maxWidth;
    }
}
