package xyz.reknown.skycarrier;

import gg.essential.api.EssentialAPI;
import gg.essential.universal.ChatColor;
import lombok.Getter;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.reknown.skycarrier.commands.SkycarrierCommand;
import xyz.reknown.skycarrier.config.SkyCarrierConfig;
import xyz.reknown.skycarrier.events.ClientChatReceivedCallback;

public class SkyCarrier implements ModInitializer {
	public static SkyCarrier INSTANCE;
	public static final Logger LOGGER = LoggerFactory.getLogger("skycarrier");

	@Getter private SkyCarrierConfig config;

	@Override
	public void onInitialize() {
		INSTANCE = this;

		config = new SkyCarrierConfig();
		config.preload();

		EssentialAPI.getCommandRegistry().registerCommand(new SkycarrierCommand());

		ClientChatReceivedCallback.EVENT.register((message) -> {
			String str = message.getString();
			if (str.startsWith("Your new API key is ")) {
				config.setApiKey(str.substring(20, 56)); // key is 36 characters long
				MinecraftClient.getInstance().player.sendMessage(Text.literal(ChatColor.GREEN + "[SkyCarrier] Successfully set your API key!"));
			} else if (config.isBlocksInTheWayHidden() && str.equals("There are blocks in the way!")) {
				return ActionResult.FAIL;
			}

			return ActionResult.PASS;
		});
	}
}
