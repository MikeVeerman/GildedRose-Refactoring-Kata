package com.gildedrose.wrapper;

import com.gildedrose.Item;

public class AgedBrie implements WrappedItem{

    private Item legacyItem;

    public AgedBrie(Item legacyItem) {
        this.legacyItem = legacyItem;
    }

    @Override
    public String getName() {
        return this.legacyItem.name;
    }

    @Override
    public int getSellIn() {
        return this.legacyItem.sellIn;
    }

    @Override
    public int getQuality() {
        return this.legacyItem.quality;
    }

    @Override
    public void updateQuality() {
        if (getQuality() < 50) {
            this.legacyItem.quality ++;
        }
        this.legacyItem.sellIn--;
    }

}