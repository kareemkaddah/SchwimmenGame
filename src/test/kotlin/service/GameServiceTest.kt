package service

import entity.CardSuit
import entity.CardValue
import entity.SchwimmenCard
import entity.SchwimmenPlayer
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class GameServiceTest {


    private val playerOne = SchwimmenPlayer("PlayerOne", 0)
    private val playerTwo = SchwimmenPlayer("PlayerTwo", 1)
    private val playerThree = SchwimmenPlayer("PlayerThree", 2)
    private val playerFour = SchwimmenPlayer("PlayerFour", 3)


    private fun createDeck(): MutableList<SchwimmenCard> {
        val deck = mutableListOf<SchwimmenCard>()
        val suits:MutableList<CardSuit> = mutableListOf(CardSuit.SPADES,CardSuit.HEARTS,CardSuit.CLUBS,CardSuit.DIAMONDS)
        val values:MutableList<CardValue> = mutableListOf(CardValue.SEVEN,CardValue.EIGHT,CardValue.NINE,CardValue.TEN,CardValue.JACK
        ,CardValue.QUEEN,CardValue.ACE,CardValue.KING)

        for(suit in suits){
            for(value in values){
                deck.add(SchwimmenCard(suit,value))
            }
        }
        return deck;

    }


    private val gameList = mutableListOf<SchwimmenPlayer>(playerOne, playerTwo, playerThree, playerFour)

val deck=createDeck()



    @Test
    fun startGame() {
        val rs=RootService()
        rs.gameService.startGame(gameList,deck)
        assertEquals(4, rs.currentGame!!.players.size)
        //checking that 17 cards are in deck remaining
        assertEquals(17, rs.currentGame!!.deckCards.size)
       //checking that table has 3 cards
        assertEquals(3,rs.currentGame!!.tableCards.size)

        //checking  that each player has three card
        assertEquals(3,rs.currentGame!!.players[0].handCards.size)
        assertEquals(3,rs.currentGame!!.players[1].handCards.size)
        assertEquals(3,rs.currentGame!!.players[2].handCards.size)
        assertEquals(3,rs.currentGame!!.players[3].handCards.size)
    }


}