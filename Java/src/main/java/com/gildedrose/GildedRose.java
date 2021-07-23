package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            //decrease sellIn
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) item.sellIn --;

            //factor for double increase/degrade if sellIn negative
            int factor;
            if (item.sellIn < 0) factor = 2;
            else factor = 1;

            //change quality item
            switch(item.name){
                case "Aged Brie":
                    item.quality = Math.min(item.quality + factor,50);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    if (item.sellIn<0) item.quality=0;
                    else if(item.sellIn<5) item.quality = Math.min(item.quality+3,50);
                    else if(item.sellIn<10) item.quality = Math.min(item.quality+2,50);
                    else item.quality = Math.min(item.quality+1,50);
                    break;
                case "Conjured Mana Cake":
                    item.quality = Math.max(item.quality-2*factor,0);
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    break;
                default:
                    item.quality = Math.max(item.quality - factor, 0);
                    break;
            }
        }
    }
}
