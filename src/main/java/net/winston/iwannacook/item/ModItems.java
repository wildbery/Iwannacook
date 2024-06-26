package net.winston.iwannacook.item;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.winston.iwannacook.IWannaCook;

public class ModItems {

    public static final Item ORANGE = registerItem("orange", new Item(new Item.Settings()));
    public static final Item ORANGE_PEEL = registerItem("orange_peel", new Item(new Item.Settings()));

    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(ORANGE);
        entries.add(ORANGE_PEEL);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(IWannaCook.MOD_ID, name), item);
    }
    public static void registerModItems() {
        IWannaCook.LOGGER.info("Registering delicious (and terrible) foods...");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemsToIngredientTabItemGroup);
    }
}
