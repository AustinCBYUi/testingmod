package net.aussie.tutorial;

import net.aussie.tutorial.block.ModBlocks;
import net.aussie.tutorial.item.ModItemGroups;
import net.aussie.tutorial.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String mod_ID = "tutorialmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(mod_ID);

	@Override
	public void onInitialize() {

		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}