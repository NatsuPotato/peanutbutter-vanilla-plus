package net.bluebunnex.peanutbutter;

import net.bluebunnex.peanutbutter.block.CustomCropBlock;
import net.bluebunnex.peanutbutter.block.EctogelBlock;
import net.bluebunnex.peanutbutter.block.NetherCrownBlock;
import net.bluebunnex.peanutbutter.block.PlantTemplateBlock;
import net.bluebunnex.peanutbutter.entity.CockatriceEntity;
import net.bluebunnex.peanutbutter.entity.GoldenEggEntity;
import net.bluebunnex.peanutbutter.entity.SwampMonsterEntity;
import net.bluebunnex.peanutbutter.item.GoldenEggItem;
import net.bluebunnex.peanutbutter.item.SlimeHammer;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.biome.Biome;
import net.modificationstation.stationapi.api.event.entity.EntityRegister;
import net.modificationstation.stationapi.api.event.registry.BlockRegistryEvent;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.template.item.TemplateFoodItem;
import net.modificationstation.stationapi.api.template.item.TemplateItem;
import net.modificationstation.stationapi.api.template.item.TemplateMushroomStewItem;
import net.modificationstation.stationapi.api.template.item.TemplateSeedsItem;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

import java.util.Random;

import static net.minecraft.block.Block.METAL_SOUND_GROUP;
import static net.minecraft.block.Block.STONE_SOUND_GROUP;

public class Peanutbutter {

    @Entrypoint.Namespace
    public static final Namespace NAMESPACE = Null.get();

    public static Block ECTOGEL;
    public static Block TOMATO_CROP;
    public static Block DAHLIA;
    public static Block NETHER_CROWN;
    public static Block STONE_BRICKS;
    public static Block RUNIC_STONE;
    public static Block CARVED_BONE;
    public static Block COPPER_ORE;
    public static Block COPPER_BLOCK;
    public static Block HEMATITE_ORE;

    public static Item COPPER_INGOT;
    public static Item HEMATITE_INGOT;
    public static Item SLIME_HAMMER;
    public static Item GOLDEN_EGG;
    public static Item GOLDEN_FEATHER;
    public static Item MUFFIN;
    public static Item TOMATO;
    public static Item TOMATO_SEEDS;
    public static Item CURRY;

    // note that blocks are registered before items

    @EventListener
    public void registerBlocks(BlockRegistryEvent event) {

        ECTOGEL = new EctogelBlock(NAMESPACE.id("ectogel"))
                .setHardness(0.2f)
                .setTranslationKey(NAMESPACE, "ectogel");

        TOMATO_CROP = new CustomCropBlock(NAMESPACE.id("tomato_crop"))
                .setTranslationKey(NAMESPACE, "tomato_crop");

        DAHLIA = new PlantTemplateBlock(NAMESPACE.id("dahlia"))
                .setTranslationKey(NAMESPACE, "dahlia");

        // TODO fix bounding box
        // TODO make this bish wearable
        NETHER_CROWN = new NetherCrownBlock(NAMESPACE.id("nether_crown"))
                .setTranslationKey(NAMESPACE, "nether_crown");

        STONE_BRICKS = new TemplateBlock(NAMESPACE.id("stone_bricks"), Material.STONE)
                .setHardness(1.5f) // copied from stone
                .setResistance(10.0f)
                .setSoundGroup(STONE_SOUND_GROUP)
                .setTranslationKey(NAMESPACE, "stone_bricks");

        RUNIC_STONE = new TemplateBlock(NAMESPACE.id("runic_stone"), Material.STONE)
                .setHardness(1.5f)
                .setResistance(10.0f)
                .setSoundGroup(STONE_SOUND_GROUP)
                .setTranslationKey(NAMESPACE, "runic_stone");

        CARVED_BONE = new TemplateBlock(NAMESPACE.id("carved_bone"), Material.STONE)
                .setHardness(1.5f) // copied from stone
                .setResistance(10.0f)
                .setSoundGroup(STONE_SOUND_GROUP)
                .setTranslationKey(NAMESPACE, "carved_bone");

        // gilded bone? (golden)

        COPPER_ORE = new TemplateBlock(NAMESPACE.id("copper_ore"), Material.STONE)
                .setHardness(2.0f) // iron is 3.0F
                .setResistance(10.0f)
                .setSoundGroup(STONE_SOUND_GROUP)
                .setTranslationKey(NAMESPACE, "copper_ore");

        COPPER_BLOCK = new TemplateBlock(NAMESPACE.id("copper_block"), Material.METAL)
                .setHardness(5.0F) // copied from iron/gold
                .setResistance(10.0F)
                .setSoundGroup(METAL_SOUND_GROUP)
                .setTranslationKey(NAMESPACE, "copper_block");

        HEMATITE_ORE = new TemplateBlock(NAMESPACE.id("hematite_ore"), Material.STONE) // TODO make this ore only drop with diamond tool
                .setHardness(10.0f) // copied from obsidian
                .setResistance(2000.0f)
                .setSoundGroup(STONE_SOUND_GROUP)
                .setLuminance(0.625F) // copied from redstone ore
                .setTranslationKey(NAMESPACE, "hematite_ore");
    }

    @EventListener
    public void registerItems(ItemRegistryEvent event) {

        SLIME_HAMMER = new SlimeHammer(NAMESPACE.id("slime_hammer"))
                .setTranslationKey(NAMESPACE, "slime_hammer");

        COPPER_INGOT = new TemplateItem(NAMESPACE.id("copper_ingot"))
                .setTranslationKey(NAMESPACE, "copper_ingot");

        HEMATITE_INGOT = new TemplateItem(NAMESPACE.id("hematite_ingot"))
                .setTranslationKey(NAMESPACE, "hematite_ingot");

        GOLDEN_EGG = new GoldenEggItem(NAMESPACE.id("golden_egg"))
                .setTranslationKey(NAMESPACE, "golden_egg");

        GOLDEN_FEATHER = new TemplateItem(NAMESPACE.id("golden_feather"))
                .setTranslationKey(NAMESPACE, "golden_feather");

        MUFFIN = new TemplateFoodItem(NAMESPACE.id("muffin"), 9, false)
                .setTranslationKey(NAMESPACE, "muffin");

        TOMATO = new TemplateFoodItem(NAMESPACE.id("tomato"), 2, false)
                .setMaxCount(8)
                .setTranslationKey(NAMESPACE, "tomato");

        TOMATO_SEEDS = new TemplateSeedsItem(NAMESPACE.id("tomato_seeds"), TOMATO_CROP.id)
                .setTranslationKey(NAMESPACE, "tomato_seeds");

        ((CustomCropBlock) TOMATO_CROP).setProductAndSeed(TOMATO, TOMATO_SEEDS);

        CURRY = new TemplateMushroomStewItem(NAMESPACE.id("curry"), 10)
                .setTranslationKey(NAMESPACE, "curry");

        // TODO either add copper armor or replace chainmail in ArmorRecipes
    }

    @EventListener
    public void registerEntities(EntityRegister event) {

        event.register(CockatriceEntity.class, "Cockatrice");
        event.register(GoldenEggEntity.class, "GoldenEgg");

        event.register(SwampMonsterEntity.class, "SwampMonster");
    }



    public static ItemStack getRandomChestItem(Random random, Biome biome) {

        if (biome == Biome.HELL) {

            int i = random.nextInt(5);

            return switch (i) {
                case 0 -> new ItemStack(Item.GOLDEN_APPLE);
                case 1 -> new ItemStack(Item.ARROW, random.nextInt(10) + 5);
                case 2 -> new ItemStack(Item.IRON_INGOT, random.nextInt(3) + 1);
                case 3 -> new ItemStack(Item.GOLD_INGOT, random.nextInt(3) + 1);
                default -> random.nextInt(4) == 0 ? Peanutbutter.getRareLoot(random, biome) : null;
            };

        } else {

            int i = random.nextInt(5);

            return switch (i) {
                case 0 -> random.nextInt(12) == 0 ? new ItemStack(Item.GOLDEN_APPLE) : new ItemStack(Item.APPLE);
                case 1 -> new ItemStack(Item.ARROW, random.nextInt(10) + 5);
                case 2 -> new ItemStack(Peanutbutter.COPPER_INGOT, random.nextInt(3) + 1);
                case 3 ->
                        new ItemStack(random.nextInt(2) == 0 ? Item.STONE_SWORD : Item.STONE_PICKAXE, 1, random.nextInt(ToolMaterial.STONE.getDurability() / 2, ToolMaterial.STONE.getDurability()));
                default -> random.nextInt(8) == 0 ? Peanutbutter.getRareLoot(random, biome) : null;
            };
        }
    }

    public static ItemStack getRareLoot(Random random, Biome biome) {

        int value;

        if (biome == Biome.HELL) {
            value = random.nextInt(2); // more loot possible if in nether to signify progression :D
        } else {
            value = 0;
        }

        return switch (value) {

            case 0 -> new ItemStack(SLIME_HAMMER);
            case 1 -> new ItemStack(GOLDEN_EGG, random.nextInt(8, 16));
            default -> null;
        };
    }
}
