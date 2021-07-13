package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest3 {

    @Test
    /**
     * quality is never negative
     */
    void foo() {
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

}
