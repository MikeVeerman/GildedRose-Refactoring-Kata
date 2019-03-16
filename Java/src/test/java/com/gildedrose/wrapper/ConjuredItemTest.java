package com.gildedrose.wrapper;

import org.junit.Test;
import com.gildedrose.Item;
import static org.junit.Assert.*;


public class ConjuredItemTest{
    @Test
    public void testConstructor(){
        Item legacyItem = new Item("Conjured Mana Cake", 10, 20);

        ConjuredItem item = new ConjuredItem(legacyItem);

        assertEquals("The name should be set", legacyItem.name, item.getName());
        assertEquals("The quality should be set", legacyItem.quality, item.getQuality());
        assertEquals("The sellIn should be set", legacyItem.sellIn, item.getSellIn());
    }

    @Test
    public void QualityShouldDecreaseWithTwoWithinSellInPeriod(){
        Item legacyItem = new Item("Conjured Mana Cake", 10, 20);

        ConjuredItem item = new ConjuredItem(legacyItem);

        item.updateQuality();

        assertEquals("The quality should match", 18, item.getQuality());
        assertEquals("The sellIn should match", 9, item.getSellIn());

        item.updateQuality();

        assertEquals("The quality should match", 16, item.getQuality());
        assertEquals("The sellIn should match", 8, item.getSellIn());
    }

    @Test
    public void QualityShouldDecreaseWithFourOutsideSellInPeriod(){
        Item legacyItem = new Item("Conjured Mana Cake", 0, 20);

        ConjuredItem item = new ConjuredItem(legacyItem);

        item.updateQuality();
        assertEquals("The quality should match", 16, item.getQuality());
        
        item.updateQuality();
        assertEquals("The quality should match", 12, item.getQuality());

    }

    @Test
    public void qualityIsNeverNegative(){
        Item legacyItem = new Item("Conjured Mana Cake", 10, 4);

        ConjuredItem item = new ConjuredItem(legacyItem);

        item.updateQuality();
        assertEquals("The quality should match", 2, item.getQuality());

        item.updateQuality();
        assertEquals("The quality should match", 0, item.getQuality());

        item.updateQuality();
        assertEquals("The quality should match", 0, item.getQuality());
        assertEquals("The sellIn should match", 7, item.getSellIn());
    }
}