package com.gildedrose.wrapper;

import com.gildedrose.Item;

public class RegularItem extends WrappedItem{
    public RegularItem(Item legacyItem){
        super(legacyItem);
    }
   
    /**
     * Regular items decrease in quality by 1 within the SellIn period.
     * After that, the decrease in quality by 2.
     */
    public void updateQuality(){
        if (getSellIn() > 0){
            getLegacyItem().quality--;
        }else{
            getLegacyItem().quality -= 2;
        }
        getLegacyItem().sellIn--;

        if (getQuality() < 0) {
            getLegacyItem().quality = 0;
        }
    };
}