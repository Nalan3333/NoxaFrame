package dev.nalan_tttt.noxaframe.client;

import dev.nalan_tttt.noxaframe.client.framework.utils.IconManager;
import net.fabricmc.api.ClientModInitializer;

public class NoxaframeClient implements ClientModInitializer {


    @Override
    public void onInitializeClient() {
        IconManager.init();
        //ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> {
        //    client.setScreen(new TestGUI());
        //});
    }
}
