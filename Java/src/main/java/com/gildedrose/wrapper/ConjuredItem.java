package com.gildedrose.wrapper;

import com.gildedrose.Item;

public class ConjuredItem extends WrappedItem{
    public ConjuredItem(Item legacyItem) {
        super(legacyItem);
    }

    /**
     * Conjured items decrease in quality by 2 within the SellIn period.
     * After that, the decrease in quality by 4.
     */
    public void updateQuality() {
        if(getSellIn() > 0){
            getLegacyItem().quality -= 2;
        }else {
            getLegacyItem().quality -= 4;
        }

        if (getQuality() < 0) {
            getLegacyItem().quality = 0;
        }

        getLegacyItem().sellIn--;
    }

}