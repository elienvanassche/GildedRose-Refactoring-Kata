package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest2 {

    @Test
    /**
     * passed sell by date --> quality degrades twice as fast
     */
    void foo() {
        Item[] items = new Item[] {
            new Item("+5 Dexterity Vest", 1, 30) ,
            new Item("Elixir of the Mongoose", 0, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(29, app.items[0].quality);
        assertEquals(18, app.items[1].quality);
        app.updateQuality();
        assertEquals(27, app.items[0].quality);
        assertEquals(16, app.items[1].quality);
    }

}
