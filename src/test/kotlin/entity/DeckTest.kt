package entity

import kotlin.test.*

/**
 * Test cases for the [Deck]
 */
class DeckTest (var deck : Deck = Deck()){


    /**
     * Überprüft ob im Deck 32 Karten sind
     */
    @Test
    fun CardTest(){
        assertTrue(deck.cards.size == 32  )
    }

    /**
     * Überprüft ob es Zu einem Fehler beim Ziehen der Karten kommt
     */
    @Test
    fun extractThreeCardsTest() {
        assertTrue(deck.cards.size <= 32 && deck.cards.size > 0) //überprüft ob im Deck noch eine zugelassene Anzahl an Karten vorhanden sid
        assertEquals(deck.cards.size, 3)                             //überprüft ob es genauch 3 Karten endnommen wurden
        for (card in deck.cards) {                                          //überprüft ob die Endnommenen Karten nicht mehr im Deck sind
            assertFalse(deck.cards.contains(card))
        }
    }

}
