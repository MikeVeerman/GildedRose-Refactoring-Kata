package com.gildedrose.wrapper;

import org.junit.Test;
import com.gildedrose.Item;
import static org.junit.Assert.*;

public class BackstagePassTest{
    @Test
    public void testConstructor(){
        Item legacyItem = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20);

        BackstagePass item = new BackstagePass(legacyItem);

        assertEquals("The name should be set", legacyItem.name, item.getName());
        assertEquals("The quality should be set", legacyItem.quality, item.getQuality());
        assertEquals("The sellIn should be set", legacyItem.sellIn, item.getSellIn());
    }

    @Test
    public void QualityShouldIncreaseByOneWhenMoreThan10days(){
        Item legacyItem = new Item("Backstage passes to a TAFKAL80ETC concert", 12, 20);

        BackstagePass item = new BackstagePass(legacyItem);

        item.updateQuality();

        assertEquals("The quality should match", 21, item.getQuality());
        assertEquals("The sellIn should match", 11, item.getSellIn());

        item.updateQuality();

        assertEquals("The quality should match", 22, item.getQuality());
        assertEquals("The sellIn should match", 10, item.getSellIn());
    }

    @Test
    public void QualityShouldIncreaseByTwoWhenBetween6And10Days(){
        Item legacyItem = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20);

        BackstagePass item = new BackstagePass(legacyItem);

        item.updateQuality();

        assertEquals("The quality should match", 22, item.getQuality());
        assertEquals("The sellIn should match", 9, item.getSellIn());

        item.updateQuality();

        assertEquals("The quality should match", 24, item.getQuality());
        assertEquals("The sellIn should match", 8, item.getSellIn());
    }

    @Test
    public void QualityShouldIncreaseByThreeWhen5DaysOrLess(){
        Item legacyItem = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20);

        BackstagePass item = new BackstagePass(legacyItem);

        item.updateQuality();

        assertEquals("The quality should match", 23, item.getQuality());
        assertEquals("The sellIn should match", 4, item.getSellIn());

        item.updateQuality();

        assertEquals("The quality should match", 26, item.getQuality());
        assertEquals("The sellIn should match", 3, item.getSellIn());
    }

    @Test
    public void QualityShouldBeZeroAfterConcert(){
        Item legacyItem = new Item("Backstage passes to a TAFKAL80ETC concert", 2, 20);

        BackstagePass item = new BackstagePass(legacyItem);

        item.updateQuality();

        assertEquals("The quality should match", 23, item.getQuality());
        assertEquals("The sellIn should match", 1, item.getSellIn());

        item.updateQuality();

        assertEquals("The quality should match", 0, item.getQuality());
        assertEquals("The sellIn should match", 0, item.getSellIn());
    }

    @Test
    public void qualityIsNeverAbove50(){
        Item legacyItem = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 48);

        BackstagePass item = new BackstagePass(legacyItem);


        item.updateQuality();
        assertEquals("The quality should match", 49, item.getQuality());

        item.updateQuality();
        assertEquals("The quality should match", 50, item.getQuality());

        item.updateQuality();
        assertEquals("The quality should match", 50, item.getQuality());
        assertEquals("The sellIn should match", 12, item.getSellIn());
    }
}