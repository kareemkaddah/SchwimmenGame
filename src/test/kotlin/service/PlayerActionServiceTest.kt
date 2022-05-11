package service

import entity.CardSuit
import entity.CardValue
import entity.SchwimmenCard
import entity.SchwimmenPlayer
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class PlayerActionServiceTest {

    private val playerOne = SchwimmenPlayer("PlayerOne", 0)
    private val playerTwo = SchwimmenPlayer("PlayerTwo", 1)
    private val playerThree = SchwimmenPlayer("PlayerThree", 2)
    private val playerFour = SchwimmenPlayer("PlayerFour", 3)


    private fun createDeck(): MutableList<SchwimmenCard> {
        val deck = mutableListOf<SchwimmenCard>()
        val suits:MutableList<CardSuit> = mutableListOf(CardSuit.SPADES, CardSuit.HEARTS, CardSuit.CLUBS, CardSuit.DIAMONDS)
        val values:MutableList<CardValue> = mutableListOf(
            CardValue.SEVEN, CardValue.EIGHT, CardValue.NINE, CardValue.TEN, CardValue.JACK
            , CardValue.QUEEN, CardValue.ACE, CardValue.KING)

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
    fun  knock(){
        val rs=RootService()
        rs.gameService.startGame(gameList,deck)
        //player one knocks

        rs.playerActionService.knock();

        //test that player one has knocked

        assertTrue { rs.currentGame!!.players[0].hasKnocked() }

    }

    @Test
    fun changeOneCard(){
        val rs=RootService()
        rs.gameService.startGame(gameList,deck)
        val chosenTableCard=rs.currentGame!!.tableCards[0]
        val chosenPlayerCard=rs.currentGame!!.players[0].handCards[1]

        rs.playerActionService.changeOneCard(chosenPlayerCard,chosenTableCard)

        assertEquals(chosenTableCard,rs.currentGame!!.players[0].handCards[1])
        assertEquals(chosenPlayerCard,rs.currentGame!!.tableCards[0])
    }


    @Test
    fun changeALlCards(){
        val rs=RootService()
        rs.gameService.startGame(gameList,deck)

        val tableCards=rs.currentGame!!.tableCards
        val handCards=rs.currentGame!!.players[0].handCards

        rs.playerActionService.changeAllCards()


        assertEquals(tableCards,rs.currentGame!!.players[0].handCards)
        assertEquals(handCards,rs.currentGame!!.tableCards)

    }


}