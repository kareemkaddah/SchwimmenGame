package entity

import org.junit.jupiter.api.Test
import kotlin.random.Random
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class DeckTest {

    private fun createCards(): ArrayDeque<SchwimmenCard> {
        val deck = ArrayDeque<SchwimmenCard>();
        for (index in 0..31) {

            deck.addFirst(
                SchwimmenCard(
                    CardSuit.values()[index / 8],
                    CardValue.values()[(index % 8 + 5)]
                )
            )
        }
        return deck
    }



    private val generatedCards = createCards()

    var generatedDeck = Deck(generatedCards)


    @Test
    fun testDeckSize() {
//Testing that deck is not empty
        assertFalse(generatedDeck.isEmpty)

//Testing that deck size is equal to 32        
        assertEquals(
            generatedDeck.size, 32
        )
    }

    @Test
    fun extractThreeCardsTest(){
        val extractedCards=generatedDeck.extractThreeCards()
        assertEquals(
            extractedCards.size, 3
        )
        assertEquals(
            generatedDeck.size, 29
        )
    }


//    TODO @Kareem test put on top

}