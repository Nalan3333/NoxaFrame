package dev.nalan_tttt.noxaframe.client.framework.utils;

import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

public class IconManager {
    private static final Map<String, Icon> icons = new HashMap<>();
    /* a testing icons. */
    public static final String noxaFrame = "ROOT./noxaFrame";
    public static final String icon = "TEST./icon";
    public static final String test = "TEST./test";

    public static void init() {
        registerIcon(new Icon(
                new ResourceLocation("noxaframe", "icon.png"),
                32,
                32,
                0,
                0,
                32,
                32
        ), noxaFrame);
        registerIcon(new Icon(
                new ResourceLocation("noxaframe", "icons.png"),
                16,
                16,
                0,
                0,
                128,
                128
        ), "TEST./icon");
        registerIcon((new Icon(
                new ResourceLocation("noxaframe", "icons.png"),
                16,
                16,
                16,
                0,
                128,
                128
        )), "TEST./test");
    }

    public static Icon getIcon(String id) {
        return icons.get(id);
    }
    public static void registerIcon(Icon icon, String id) {
        icons.put(id, icon);
    }
}
