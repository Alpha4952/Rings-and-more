package alpheta.rings_and_more.item;

import alpheta.rings_and_more.RingsAndMore;
import alpheta.rings_and_more.item.custom.CigaretteItem;
import alpheta.rings_and_more.item.custom.RingItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item golden_ring = registerItem("golden_ring", new RingItem(new Item.Settings().maxCount(1)));
    public static final Item cigarette = registerItem("cigarette", new CigaretteItem(new Item.Settings().maxCount(1).maxDamage(3)));

    private static Item registerItem(String item_name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(RingsAndMore.MOD_ID, item_name), item);
    }

    public static void registerModItems() {
        RingsAndMore.LOGGER.info("Registering Mod Items for " + RingsAndMore.MOD_ID);
    }
}
