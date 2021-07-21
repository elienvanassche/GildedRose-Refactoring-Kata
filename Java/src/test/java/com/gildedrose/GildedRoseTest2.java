package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest2 {

    @Test
    /**
     * passed sell by date --> quality degrades or increases twice as fast
     */
    void foo() {
        Item[] items = new Item[] {
            new Item("+5 Dexterity Vest", 1, 30) , //
            new Item("Elixir of the Mongoose", 1, 20), //
            new Item("Aged Brie", 1, 0), //
            new Item("Conjured Mana Cake", 1, 6) };

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

}
