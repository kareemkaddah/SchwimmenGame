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
        for (index in 0..31) {

            deck.add(
                SchwimmenCard(
                    CardSuit.values()[index / 8],
                    CardValue.values()[(index % 8 + 5)]
                )
            )
        }
        return deck
    }


    private val gameList = mutableListOf<SchwimmenPlayer>(playerOne, playerTwo, playerThree, playerFour)
    private val deck=createDeck()



    @Test
    fun startGame() {
        val rs=RootService()
        rs.gameService.startGame(gameList,deck)
        val currentGame=rs.currentGame
        checkNotNull(currentGame)
        assertEquals(4,currentGame.players.size)
//        assertEquals(17,rs.gameService.t)


    }
}