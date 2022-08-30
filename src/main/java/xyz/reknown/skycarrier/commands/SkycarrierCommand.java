package xyz.reknown.skycarrier.commands;

import gg.essential.api.commands.Command;
import gg.essential.api.commands.DefaultHandler;
import gg.essential.api.utils.GuiUtil;
import xyz.reknown.skycarrier.SkyCarrier;

public class SkycarrierCommand extends Command {
    public SkycarrierCommand() {
        super("skycarrier");
    }

    @DefaultHandler
    public void handle() {
        GuiUtil.open(SkyCarrier.INSTANCE.getConfig().gui());
    }
}
