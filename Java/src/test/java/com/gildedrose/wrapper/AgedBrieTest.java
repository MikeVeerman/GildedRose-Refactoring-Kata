package com.gildedrose.wrapper;

import org.junit.Test;
import com.gildedrose.Item;
import static org.junit.Assert.*;
import com.gildedrose.wrapper.AgedBrie;

public class AgedBrieTest{
    @Test
    public void testConstructor(){
        Item legacyItem = new Item("Aged Brie", 10, 20);

        AgedBrie item = new AgedBrie(legacyItem);

        assertEquals("The name should be set", legacyItem.name, item.getName());
        assertEquals("The quality should be set", legacyItem.quality, item.getQuality());
        assertEquals("The sellIn should be set", legacyItem.sellIn, item.getSellIn());
    }

    @Test
    public void QualityShouldIncrease(){
        Item legacyItem = new Item("Aged Brie", 10, 20);

        AgedBrie item = new AgedBrie(legacyItem);

        item.updateQuality();

        assertEquals("The quality should match", 21, item.getQuality());
        assertEquals("The sellIn should match", 9, item.getSellIn());

        item.updateQuality();

        assertEquals("The quality should match", 22, item.getQuality());
        assertEquals("The sellIn should match", 8, item.getSellIn());
    }

    @Test
    public void qualityIsNeverAbove50(){
        Item legacyItem = new Item("Aged Brie", 2, 48);

        AgedBrie item = new AgedBrie(legacyItem);


        item.updateQuality();
        assertEquals("The quality should match", 49, item.getQuality());

        item.updateQuality();
        assertEquals("The quality should match", 50, item.getQuality());

        item.updateQuality();
        assertEquals("The quality should match", 50, item.getQuality());
        assertEquals("The sellIn should match", -1, item.getSellIn());
    }
}