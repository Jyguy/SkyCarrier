package xyz.reknown.skycarrier.config;

import gg.essential.vigilance.Vigilant;
import gg.essential.vigilance.data.Property;
import gg.essential.vigilance.data.PropertyType;
import lombok.Getter;

import java.io.File;

@SuppressWarnings("FieldMayBeFinal")
public class SkyCarrierConfig extends Vigilant {
    @Property(
            type = PropertyType.TEXT,
            name = "API Key",
            description = "Your Hypixel API key. Using '/api new' will auto-fill this field.",
            category = "General",
            subcategory = "API",
            protectedText = true
    )
    @Getter private String apiKey = "";

    @Property(
            type = PropertyType.SWITCH,
            name = "Blocks in the Way Hider",
            description = "Hides the 'There are blocks in the way!' message when teleporting.",
            category = "Spam"
    )
    @Getter private boolean blocksInTheWayHidden = false;

    public SkyCarrierConfig() {
        super(new File("./config/skycarrier.toml"), "SkyCarrier");
        initialize();
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
        markDirty();
    }
}
