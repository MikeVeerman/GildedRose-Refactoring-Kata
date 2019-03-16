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

    @Test 
    public void testCreateAgedBrie(){
        Item agedBrie = new Item("Aged Brie", 10, 20);
        Item[] legacyItems = new Item[]{agedBrie};
        WrappedItem[] items = ItemFactory.create(legacyItems);

        assertNotNull(items);
        assertEquals("There should be one item", 1, items.length);
        assertEquals("The name should match", agedBrie.name, items[0].getName());
        assertEquals("The quality should match", agedBrie.quality, items[0].getQuality());
        assertEquals("The sellIn should match", agedBrie.sellIn, items[0].getSellIn());
        assertTrue("It should be an AgedBrie", items[0] instanceof AgedBrie);
    }

    @Test 
    public void testCreateSulfuras(){
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, 20);
        Item[] legacyItems = new Item[]{sulfuras};
        WrappedItem[] items = ItemFactory.create(legacyItems);

        assertNotNull(items);
        assertEquals("There should be one item", 1, items.length);
        assertEquals("The name should match", sulfuras.name, items[0].getName());
        assertEquals("The quality should match", sulfuras.quality, items[0].getQuality());
        assertEquals("The sellIn should match", sulfuras.sellIn, items[0].getSellIn());
        assertTrue("It should be a Sulfuras", items[0] instanceof Sulfuras);
    }
}