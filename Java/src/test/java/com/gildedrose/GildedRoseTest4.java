package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest4 {

    @Test
    /**
     * Aged Brie increases in quality
     */
    void foo() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

}
