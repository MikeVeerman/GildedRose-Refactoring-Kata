package com.gildedrose.wrapper;

import org.junit.Test;
import com.gildedrose.Item;
import static org.junit.Assert.*;
import com.gildedrose.wrapper.RegularItem;

public class RegularItemTest{
    @Test
    public void testConstructor(){
        Item legacyItem = new Item("+5 Dexterity Vest", 10, 20);

        RegularItem item = new RegularItem(legacyItem);

        assertEquals("The name should be set", legacyItem.name, item.getName());
        assertEquals("The quality should be set", legacyItem.quality, item.getQuality());
        assertEquals("The sellIn should be set", legacyItem.sellIn, item.getSellIn());
    }

    @Test
    public void QualityShouldDecreaseWithOneWithinSellInPeriod(){
        Item legacyItem = new Item("+5 Dexterity Vest", 10, 20);

        RegularItem item = new RegularItem(legacyItem);

        item.updateQuality();

        assertEquals("The quality should match", 19, item.getQuality());
        assertEquals("The sellIn should match", 9, item.getSellIn());

        item.updateQuality();

        assertEquals("The quality should match", 18, item.getQuality());
        assertEquals("The sellIn should match", 8, item.getSellIn());
    }

    @Test
    public void QualityShouldDecreaseWithTwoOutsideSellInPeriod(){
        Item legacyItem = new Item("+5 Dexterity Vest", 0, 20);

        RegularItem item = new RegularItem(legacyItem);

        item.updateQuality();
        assertEquals("The quality should match", 18, item.getQuality());
        
        item.updateQuality();
        assertEquals("The quality should match", 16, item.getQuality());

    }

    @Test
    public void qualityIsNeverNegative(){
        Item legacyItem = new Item("+5 Dexterity Vest", 2, 2);
        RegularItem item = new RegularItem(legacyItem);

        item.updateQuality();
        assertEquals("The quality should match", 1, item.getQuality());

        item.updateQuality();
        assertEquals("The quality should match", 0, item.getQuality());

        item.updateQuality();
        assertEquals("The quality should match", 0, item.getQuality());
        assertEquals("The sellIn should match", -1, item.getSellIn());
    }
}