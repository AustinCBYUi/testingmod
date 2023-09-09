package net.aussie.tutorial.block;

import net.aussie.tutorial.TutorialMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    //Create new blocks here
    //Ruby Block constructor
    public static final Block RUBY_BLOCK = registerBlock("ruby_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK))); //Copy of the Iron Block

    //Raw Ruby constructor
    public static final Block RAW_RUBY_ORE = registerBlock("raw_ruby_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_CLUSTER))); //Copy of Emerald Block

    public static final Block RUBY_ORE = registerBlock("ruby_ore",
        new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(2f), UniformIntProvider.create(2, 3)));
    public static final Block DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).strength(4f), UniformIntProvider.create(2, 5)));
    public static final Block NETHER_RUBY_ORE = registerBlock("nether_ruby_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.NETHERRACK).strength(1.5f), UniformIntProvider.create(1, 2)));
    public static final Block END_STONE_RUBY_ORE = registerBlock("end_stone_ruby_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.END_STONE).strength(3f), UniformIntProvider.create(4, 7)));


    //Helper Function
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(TutorialMod.mod_ID, name), block);
    }

    //Helper function
    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.mod_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        TutorialMod.LOGGER.info("Registering ModBlocks for " + TutorialMod.mod_ID);
    }
}
