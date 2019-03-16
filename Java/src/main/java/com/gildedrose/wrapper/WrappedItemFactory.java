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

            WrappedItem wrappedItem;
            if (isConjuredItem(legacyItems[i])){
                wrappedItem = new ConjuredItem(legacyItems[i]);
            }else {
                String name = legacyItems[i].name;
                switch(name){
                    case "Aged Brie": {
                        wrappedItem = new AgedBrie(legacyItems[i]); 
                        break;
                    }
                    case "Sulfuras, Hand of Ragnaros": {
                        wrappedItem = new Sulfuras(legacyItems[i]);
                        break;
                    }
                    case "Backstage passes to a TAFKAL80ETC concert": {
                        wrappedItem = new BackstagePass(legacyItems[i]);
                        break;
                    }
                    default: {
                        wrappedItem = new RegularItem(legacyItems[i]);
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