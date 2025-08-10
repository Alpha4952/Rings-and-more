package alpheta.rings_and_more.item;

import alpheta.rings_and_more.RingsAndMore;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup Rings_Item_Group = Registry.register(
            Registries.ITEM_GROUP,
            Identifier.of(RingsAndMore.MOD_ID, "rings"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.golden_ring))
                    .displayName(Text.translatable("itemgroup.rings_and_more.rings"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.golden_ring);
                    })
                    .build());

    public static final ItemGroup Supplements_Item_Group = Registry.register(
            Registries.ITEM_GROUP,
            Identifier.of(RingsAndMore.MOD_ID, "supplements"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.cigarette))
                    .displayName(Text.translatable("itemgroup.rings_and_more.supplements"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.cigarette);
                    })
                    .build());


    public static void registerModItemGroups () {
        RingsAndMore.LOGGER.info("Registering Mod Item Groups for " + RingsAndMore.MOD_ID);
    }
}
