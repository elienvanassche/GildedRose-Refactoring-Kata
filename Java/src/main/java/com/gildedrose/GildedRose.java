package com.gildedrose;

import java.util.Arrays;
import java.util.stream.Stream;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            //degrade or increase quality item
            if(Stream.of("Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros").noneMatch(item.name::equals)
                && item.quality>0){
                item.quality--;
                if(item.name.equals("Conjured Mana Cake") && item.quality>0) item.quality--;
            } else if (item.quality < 50) {
                item.quality++;
                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.sellIn < 11) item.quality ++;
                    if (item.sellIn < 6) item.quality ++;
                }
            }

            //degrade sellIn item
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) item.sellIn --;

            //quality degrades or increases twice as fast or drops to 0
            if (item.sellIn < 0) {
                if (item.name.equals("Aged Brie") && item.quality<50) item.quality++;
                else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) item.quality=0;
                else if (Arrays.asList("+5 Dexterity Vest", "Elixir of the Mongoose", "Conjured Mana Cake").contains(item.name) && item.quality > 0){
                    item.quality--;
                    if(item.name.equals("Conjured Mana Cake") && item.quality>0) item.quality --;
                }
            }
        }
    }
}
