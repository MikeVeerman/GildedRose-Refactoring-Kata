package com.gildedrose.wrapper;

import com.gildedrose.Item;

public class Sulfuras extends WrappedItem {

    public Sulfuras(Item legacyItem){
        super(legacyItem);
    }
    /**
     * Sulfuras doesn't decline in quality.
     * It's sellIn date never changes.
     */
    public void updateQuality() {
        // Nothing to do.
    }

}