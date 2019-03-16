package com.gildedrose.wrapper;

import org.junit.Test;
import com.gildedrose.Item;
import static org.junit.Assert.*;
import com.gildedrose.wrapper.Sulfuras;

public class SulfurasTest{
    @Test
    public void testConstructor(){
        Item legacyItem = new Item("Sulfuras, Hand of Ragnaros", 0, 20);

        Sulfuras item = new Sulfuras(legacyItem);

        assertEquals("The name should be set", legacyItem.name, item.getName());
        assertEquals("The quality should be set", legacyItem.quality, item.getQuality());
        assertEquals("The sellIn should be set", legacyItem.sellIn, item.getSellIn());
    }

    @Test
    public void QualityAndSellInShouldRemain(){
        Item legacyItem = new Item("Sulfuras, Hand of Ragnaros", 0, 20);

        Sulfuras item = new Sulfuras(legacyItem);

        item.updateQuality();

        assertEquals("The quality should match", 20, item.getQuality());
        assertEquals("The sellIn should match", 0, item.getSellIn());

        item.updateQuality();

        assertEquals("The quality should match", 20, item.getQuality());
        assertEquals("The sellIn should match", 0, item.getSellIn());
    }
}