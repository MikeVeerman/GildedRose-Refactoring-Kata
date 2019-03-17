package com.gildedrose.wrapper;

import com.gildedrose.Item;

/**
 * Factory that takes an array of legacy code items and wraps them in
 * better interfaces.
 */
public class WrappedItemFactory{
    public static WrappedItem[] create(Item[] legacyItems){
        WrappedItem[] result = new WrappedItem[legacyItems.length];

        for (int i = 0; i < legacyItems.length; i++) {
            Item legacyItem = legacyItems[i];
            WrappedItem wrappedItem;
            
            if (isConjuredItem(legacyItem)){
                wrappedItem = new ConjuredItem(legacyItem);
            }else {
                switch(legacyItem.name){
                    case "Aged Brie": {
                        wrappedItem = new AgedBrie(legacyItem); 
                        break;
                    }
                    case "Sulfuras, Hand of Ragnaros": {
                        wrappedItem = new Sulfuras(legacyItem);
                        break;
                    }
                    case "Backstage passes to a TAFKAL80ETC concert": {
                        wrappedItem = new BackstagePass(legacyItem);
                        break;
                    }
                    default: {
                        wrappedItem = new RegularItem(legacyItem);
                        break;
                    }
                }
            }
            result[i] = wrappedItem;
        }

        return result;
    }

    private static boolean isConjuredItem(Item item) {
        return item.name.startsWith("Conjured");
    }
}