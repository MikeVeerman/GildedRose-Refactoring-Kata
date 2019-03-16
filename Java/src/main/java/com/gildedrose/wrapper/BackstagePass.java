package com.gildedrose.wrapper;

import com.gildedrose.Item;

public class BackstagePass extends WrappedItem{

    public BackstagePass(Item legacyItem){
        super(legacyItem);
    }
    
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