package dev.nalan_tttt.noxaframe.client.framework;

import dev.nalan_tttt.noxaframe.client.framework.elements.*;
import dev.nalan_tttt.noxaframe.client.framework.utils.IconManager;

/**
 * GUI Example.
 * @since 1.0-A
 */
public class TestGUI extends GUI {
    UIIcon test;
    UIIcon two;
    UIButton button;
    UIButton twoButton;
    UIRowContainer container;
    UIColumnContainer columnContainer;
    UILabel label;
    boolean clicked;
    @Override
    public void init() {
        super.init();
        container = new UIRowContainer(1);
        container.wh(16, 60);
        container.xy(0.5f, 0.45f);
        test = new UIIcon(IconManager.getIcon(IconManager.test));
        button = new UIButton("Click me!", 0xFF0000FF, (button) -> {
            if (!clicked) {
                button.text("You clicked me!");
                clicked = true;
            } else {
                button.text("Click me again!");
                clicked = false;
            }
        });
        twoButton = new UIButton("hi!", 0xFFFF00FF, (button) -> {
            if (twoButton.pressed) {
                twoButton.text("what?");
            } else {
                twoButton.text("hi!");
            }
        });
        twoButton.h(24).w(1f);
        button.h(16).w(1f);
        columnContainer = new UIColumnContainer(1);
        label = new UILabel("Hello, world!");
        label.wh(100, 100);
        label.xy(0.6f, 0.5f);
        columnContainer.xy(0.4f, 0.5f);
        columnContainer.wh(32, 32);
        columnContainer.addChild(button);
        columnContainer.addChild(twoButton);
        test.xy(0, 0);
        test.wh(16, 16);
        container.addChild(test);
        container.addChild(new UIIcon(IconManager.getIcon(IconManager.icon)).wh(16, 16).xy(0, 0));
        this.root.addChild(container);
        this.root.addChild(columnContainer);
        this.root.addChild(label);

    }
}
