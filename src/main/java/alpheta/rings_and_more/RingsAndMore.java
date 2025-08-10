package alpheta.rings_and_more;

import alpheta.rings_and_more.item.ModItemGroups;
import alpheta.rings_and_more.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RingsAndMore implements ModInitializer {
	public static final String MOD_ID = "rings_and_more";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final Identifier CIGARETTE_SMOKING_ID = Identifier.of(MOD_ID, "cigarette_smoking");
    public static SoundEvent CIGARETTE_SMOKING = SoundEvent.of(CIGARETTE_SMOKING_ID);

	@Override
	public void onInitialize() {
        ModItemGroups.registerModItemGroups();
        ModItems.registerModItems();
        Registry.register(Registries.SOUND_EVENT, RingsAndMore.CIGARETTE_SMOKING_ID, CIGARETTE_SMOKING);
	}
}