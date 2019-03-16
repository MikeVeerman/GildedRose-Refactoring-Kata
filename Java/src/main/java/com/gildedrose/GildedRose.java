package com.gildedrose;

import com.gildedrose.wrapper.WrappedItemFactory;
import com.gildedrose.wrapper.WrappedItem;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        WrappedItem[] wrappedItems = WrappedItemFactory.create(this.items);
        for (WrappedItem item : wrappedItems) {
            item.updateQuality();
        }
    }
}