package com.gildedrose.wrapper;

import org.junit.Test;

import static org.junit.Assert.*;

import com.gildedrose.Item;

public class ItemFactoryTest{
    @Test 
    public void testCreateRegularItem(){
        Item dexterityVest = new Item("+5 Dexterity Vest", 10, 20);
        Item[] legacyItems = new Item[]{dexterityVest};
        WrappedItem[] items = ItemFactory.create(legacyItems);

        assertNotNull(items);
        assertEquals("There should be one item", 1, items.length);
        assertEquals("The name should match", dexterityVest.name, items[0].getName());
        assertEquals("The quality should match", dexterityVest.quality, items[0].getQuality());
        assertEquals("The sellIn should match", dexterityVest.sellIn, items[0].getSellIn());
        assertTrue("It should be a RegularItem", items[0] instanceof RegularItem);
    }
}