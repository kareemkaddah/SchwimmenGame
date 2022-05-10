package entity

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SchimmenCardTest {
    
    
    
    // Some cards to perform the tests with
    private val aceOfSpades = SchwimmenCard(CardSuit.SPADES, CardValue.ACE)
    private val jackOfClubs = SchwimmenCard(CardSuit.CLUBS, CardValue.JACK)
    private val queenOfHearts = SchwimmenCard(CardSuit.HEARTS, CardValue.QUEEN)
    private val jackOfDiamonds = SchwimmenCard(CardSuit.DIAMONDS, CardValue.JACK)
    private val fourOfHearts=SchwimmenCard(CardSuit.HEARTS,CardValue.FOUR)
    private val sevenOfSpades=SchwimmenCard(CardSuit.SPADES,CardValue.SEVEN)


//testing get value method

    @Test
    fun testValue(){
        assertEquals(
            aceOfSpades.getValue(),11.0
        )

    }

    @Test
    fun testSuit(){
        assertEquals(
            aceOfSpades.getSuit(),CardSuit.SPADES
        )

    }

}