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

    public SkyCarrierConfig() {
        super(new File("./config/skycarrier.toml"), "SkyCarrier");
        initialize();
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
        markDirty();
    }
}
