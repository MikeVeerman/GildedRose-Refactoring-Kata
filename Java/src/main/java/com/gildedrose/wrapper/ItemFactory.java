package com.gildedrose.wrapper;

import com.gildedrose.Item;

public class ItemFactory{
    public static WrappedItem[] create(Item[] legacyItems){
        WrappedItem[] result = new WrappedItem[legacyItems.length];

        for (int i = 0; i < legacyItems.length; i++) {
            String name = legacyItems[i].name;
            WrappedItem wrappedItem;

            switch(name){
                case "Aged Brie": {
                    wrappedItem = new AgedBrie(legacyItems[i]); 
                    break;
                }
                case "Sulfuras, Hand of Ragnaros": {
                    wrappedItem = new Sulfuras(legacyItems[i]);
                    break;
                }
                default: {
                    wrappedItem = new RegularItem(legacyItems[i]);
                    break;
                }
            }
            result[i] = wrappedItem;
        }

        return result;
    }
}