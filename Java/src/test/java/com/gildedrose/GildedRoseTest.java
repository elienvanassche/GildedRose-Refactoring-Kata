package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    //passed sell by date --> quality degrades or increases twice as fast
    void passedSellByDate() {
        Item[] items = new Item[]{
            new Item("+5 Dexterity Vest", 1, 30), //
            new Item("Elixir of the Mongoose", 1, 20), //
            new Item("Aged Brie", 1, 0), //
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(29, app.items[0].quality);
        assertEquals(19, app.items[1].quality);
        assertEquals(1, app.items[2].quality);

        app.updateQuality();
        assertEquals(27, app.items[0].quality);
        assertEquals(17, app.items[1].quality);
        assertEquals(3, app.items[2].quality);
    }

    @Test
    //quality is never negative
    void isQualityPositive() {
        Item[] items = new Item[] {
            new Item("+5 Dexterity Vest", 1, 2) ,
            new Item("Elixir of the Mongoose", 0, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
        assertEquals(0, app.items[1].quality);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(0, app.items[1].quality);
    }

    @Test
    //Aged Brie increases in quality
    void testQualityAgedBrie() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

    @Test
    //Quality is never more than 50
    void testMaximumQuality() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    //Sulfaras never has to be sold or decreases in quality
    void testSulfarasForChange() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 5, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
        assertEquals(5, app.items[0].sellIn);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
        assertEquals(5, app.items[0].sellIn);
    }

    @Test
    //back stage passes
    void testQualityBackstagePasses() {
        Item[] items = new Item[]{
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(21, app.items[0].quality);
        assertEquals(22, app.items[1].quality);
        assertEquals(23, app.items[2].quality);
        assertEquals(0, app.items[3].quality);

    }

    @Test
    //Conjured items degrade twice as fast
    void testQualityConjuredItems() {
        Item[] items = new Item[]{
            new Item("Conjured Mana Cake", 1, 6),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].quality);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }
}
