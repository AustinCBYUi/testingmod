package net.aussie.tutorial.item;

import net.aussie.tutorial.TutorialMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    //registerItem string cannot be uppercase. Basically it is a classname.
    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));

    //Ender Claw
    public static final Item ENDER_CLAW = registerItem("ender_claw", new Item(new FabricItemSettings()));
    public static final Item RAW_RUBY = registerItem("raw_ruby", new Item(new FabricItemSettings()));

    //bow texture test?
    public static final Item ENDER_BOW = registerItem("ender_bow", new BowItem(new FabricItemSettings().maxDamage(650)));

    //Creative mode tab
    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(RUBY);
        entries.add(RAW_RUBY);
        entries.add(ENDER_BOW);
        entries.add(ENDER_CLAW);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.mod_ID, name), item);
    }

    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registering mod items for " + TutorialMod.mod_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
