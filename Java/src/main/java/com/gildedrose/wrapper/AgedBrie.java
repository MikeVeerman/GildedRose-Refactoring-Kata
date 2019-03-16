package com.gildedrose.wrapper;

import com.gildedrose.Item;

public class AgedBrie extends WrappedItem{
    public AgedBrie(Item legacyItem) {
        super(legacyItem);
    }

    @Override
    public void updateQuality() {
        if (getQuality() < 50) {
            getLegacyItem().quality ++;
        }
        getLegacyItem().sellIn--;
    }

}