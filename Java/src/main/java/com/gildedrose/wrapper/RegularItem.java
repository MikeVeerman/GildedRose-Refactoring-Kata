package com.gildedrose.wrapper;

import com.gildedrose.Item;

public class RegularItem implements WrappedItem{

    private Item legacyItem;

    public RegularItem(Item legacyItem){
        this.legacyItem = legacyItem;
    }
    public String getName(){
        return this.legacyItem.name;
    }
    public int getSellIn(){
        return this.legacyItem.sellIn;
    }
    public int getQuality(){
        return this.legacyItem.quality;
    };
    /**
     * Regular items decrease in quality by 1 within the SellIn period.
     * After that, the decrease in quality by 2.
     */
    public void updateQuality(){
        if (getSellIn() > 0){
            this.legacyItem.quality--;
        }else{
            this.legacyItem.quality -= 2;
        }
        this.legacyItem.sellIn--;

        if (getQuality() < 0) {
            this.legacyItem.quality = 0;
        }
    };
}