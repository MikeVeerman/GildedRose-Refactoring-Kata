package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {
    
    @Test
    public void qualityShouldDecrease1WithinSellInPeriod(){
        Item item = new Item("foo", 1, 2);
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);
        assertEquals("The quality should match", 2, item.quality);
        assertEquals("The sellin days should match", 1, item.sellIn);

        app.updateQuality();

        assertEquals("The quality should match", 1, item.quality);
        assertEquals("The sellin days should match", 0, item.sellIn);
    }

    @Test
    public void qualityShouldDecrease2OutsideSellInPeriod(){
        Item item = new Item("foo", 0, 3);
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);
        assertEquals("The quality should match", 3, item.quality);
        assertEquals("The sellin days should match", 0, item.sellIn);

        app.updateQuality();

        assertEquals("The quality should match", 1, item.quality);
        assertEquals("The sellin days should match", -1, item.sellIn);
    }

    @Test
    public void qualityIsNeverNegative(){
        Item item = new Item("foo", 0, 2);
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        app.updateQuality();
        assertEquals("the quality should be 0 now", 0, item.quality);

        app.updateQuality();
        assertEquals("the quality should be 0 now", 0, item.quality);
    }

}
