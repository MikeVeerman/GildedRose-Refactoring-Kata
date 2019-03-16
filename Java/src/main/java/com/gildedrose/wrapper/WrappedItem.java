package com.gildedrose.wrapper;

import com.gildedrose.Item;

public abstract class WrappedItem {
    private Item legacyItem;

    public WrappedItem(Item legacyItem) {
        this.legacyItem = legacyItem;
    }

    protected Item getLegacyItem(){
        return this.legacyItem;
    }
    public String getName(){
        return this.legacyItem.name;
    };
    public int getSellIn(){
        return this.legacyItem.sellIn;
    };
    public int getQuality(){
        return this.legacyItem.quality;
    };

    /**
     * Implement the quality updating logic here.
     */
    public abstract void updateQuality();
}