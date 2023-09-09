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
import net.minecraft.util.Rarity;

public class ModItems {
    /*registerItem string cannot be uppercase. Basically it is a classname.
    * This section is for creating new items using the examples below.
    */
    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));

    //Ender Claw
    public static final Item ENDER_CLAW = registerItem("ender_claw", new Item(new FabricItemSettings()));
    public static final Item RAW_RUBY = registerItem("raw_ruby", new Item(new FabricItemSettings()));

    //bow texture test?
    //TODO Need to fine tune rotation / translation of the bow in-hand. Definitely needs to be done for 3rd person.
    public static final Item ENDER_BOW = registerItem("ender_bow",
            new BowItem(new FabricItemSettings().maxDamage(640).rarity(Rarity.RARE))); //Was 700, way too OP.

    /*
    * Ingredient items belong here, so things that are specific ingredients for crafting.
    *
    */
    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(RUBY);
        entries.add(RAW_RUBY);
        entries.add(ENDER_CLAW);
    }

    /*
    * Combat Items belong in the Combat Item Group section below.
    */
    private static void addItemsToCombatItemGroup(FabricItemGroupEntries entries) {
        entries.add(ENDER_BOW);
    }

    /*
    * Helper function to register items.
    */
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.mod_ID, name), item);
    }

    /*
    * In-game registry for mod items, this will add the item to the group that the item belongs in.
    * */
    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registering mod items for " + TutorialMod.mod_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatItemGroup);
    }
}
