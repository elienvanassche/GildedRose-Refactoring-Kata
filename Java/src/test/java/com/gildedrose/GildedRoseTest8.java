package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest8 {

    @Test
    /**
     * Conjured items degrade twice as fast
     */
    void foo() {
        Item[] items = new Item[]{
            new Item("Conjured Mana Cake", 1, 4),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

}
