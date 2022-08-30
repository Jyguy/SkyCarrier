package xyz.reknown.skycarrier.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;

public interface ClientChatReceivedCallback {
    Event<ClientChatReceivedCallback> EVENT = EventFactory.createArrayBacked(ClientChatReceivedCallback.class,
            (listeners) -> (message) -> {
                for (ClientChatReceivedCallback listener : listeners) {
                    ActionResult result = listener.interact(message);

                    if (result != ActionResult.PASS) {
                        return result;
                    }
                }

                return ActionResult.PASS;
            });

    ActionResult interact(Text message);
}
