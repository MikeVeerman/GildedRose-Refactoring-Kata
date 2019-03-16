package com.gildedrose.wrapper;

import com.gildedrose.Item;

public class ItemFactory{
    public static WrappedItem[] create(Item[] legacyItems){
        WrappedItem[] result = new WrappedItem[legacyItems.length];

        for (int i = 0; i < legacyItems.length; i++) {
            if (legacyItems[i].name.equals("Aged Brie")){
                result[i] = new AgedBrie(legacyItems[i]);
            }else{
                result[i] = new RegularItem(legacyItems[i]);
            }            
        }

        return result;
    }
}