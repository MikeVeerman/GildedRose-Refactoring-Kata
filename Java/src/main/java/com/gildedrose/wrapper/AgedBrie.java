package com.gildedrose.wrapper;

import com.gildedrose.Item;

public class AgedBrie extends WrappedItem{
    public AgedBrie(Item legacyItem) {
        super(legacyItem);
    }

    /**
     * Aged Brie only gets better. The quality increases until it reaches 50.
     */
    public void updateQuality() {
        if (getQuality() < 50) {
            getLegacyItem().quality ++;
        }
        getLegacyItem().sellIn--;
    }

}