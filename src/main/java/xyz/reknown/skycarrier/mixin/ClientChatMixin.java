package xyz.reknown.skycarrier.mixin;

import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.client.gui.hud.MessageIndicator;
import net.minecraft.network.message.MessageSignatureData;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xyz.reknown.skycarrier.events.ClientChatReceivedCallback;

@Mixin(ChatHud.class)
public class ClientChatMixin {
    @Inject(method = "addMessage(Lnet/minecraft/text/Text;Lnet/minecraft/network/message/MessageSignatureData;ILnet/minecraft/client/gui/hud/MessageIndicator;Z)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/hud/ChatHud;logChatMessage(Lnet/minecraft/text/Text;Lnet/minecraft/client/gui/hud/MessageIndicator;)V", shift = At.Shift.AFTER), cancellable = true)
    public void onGameMessage(Text message, MessageSignatureData signature, int ticks, MessageIndicator indicator, boolean refresh, CallbackInfo ci) {
        ActionResult result = ClientChatReceivedCallback.EVENT.invoker().interact(message);

        if (result == ActionResult.FAIL) {
            ci.cancel();
        }
    }
}
