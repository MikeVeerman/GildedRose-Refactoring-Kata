package com.gildedrose.wrapper;

import com.gildedrose.Item;

public class BackstagePass extends WrappedItem{

    public BackstagePass(Item legacyItem){
        super(legacyItem);
    }
    
    /**
     * Quality of Backstage passes increases:
     * - 3 in the last 5 days before the concert
     * - 2 in the last 6 to 10 days before the concert
     * - 1 10+ days before the concert
     * 
     * Once the concert date has passed, they have 0 quality.
     */
    public void updateQuality() {
        if (getSellIn() <=5){
            getLegacyItem().quality += 3;
        } else if (getSellIn() <= 10) {
            getLegacyItem().quality += 2;
        } else {
            getLegacyItem().quality++;
        }

        getLegacyItem().sellIn--;

        if (getSellIn() <= 0) {
            getLegacyItem().quality = 0;
        }

        if (getQuality() > 50){
            getLegacyItem().quality = 50;
        }

    }
    
}