package service

import AbstractRefreshingService
import entity.*

class PlayerActionService(private val rootService: RootService) : AbstractRefreshingService() {

    var currentGame = rootService.currentGame
    val currentPlayer = currentGame?.currentPlayer


    fun knock() {
        val game = rootService.currentGame
        checkNotNull(game)
        currentPlayer?.didKnock()


    }

    fun changeOneCard(handCard: SchwimmenCard, tableCard: SchwimmenCard) {
        checkNotNull(currentGame)
        var playerCard = currentPlayer?.handCards

        val indexOfChosenCard = playerCard?.indexOf(handCard)
        val indexOfTableCard = currentGame?.tableCards!!.indexOf(tableCard)

        if (indexOfChosenCard != null) {
            playerCard?.set(indexOfChosenCard, tableCard)
        };
        currentGame?.tableCards!![indexOfTableCard] = handCard
        onAllRefreshables { refreshAfterTurn() }

    }


    fun changeAllCards() {
        checkNotNull(currentGame)
        val tmp = currentPlayer?.dealtHandCards
        currentPlayer?.dealtHandCards = currentGame!!.tableCards
        if (tmp != null) {
            currentGame!!.tableCards = tmp
        }
        onAllRefreshables { refreshAfterTurn() }

    }


    fun pass() {
        checkNotNull(currentGame)
        currentGame!!.passCounter += 1;
        onAllRefreshables { refreshAfterTurn() }
    }

    fun turn(t: Turn) {
        val playersSize = currentGame?.players?.size
        if (!currentGame?.gameActive!!) return;
        if(currentGame!!.deckCards.size<3){
            currentGame?.gameActive=false;
            return;
        }
        if (currentPlayer?.hasKnocked() == true) {
            currentGame!!.endGame()
            return;

        }
        when (t) {

            Turn.CHANGE_ALL -> changeAllCards();
            Turn.KNOCK -> knock();
            Turn.PASS -> pass();
            // TODO figure out how to pass the parameters
            Turn.CHANGE_ONE -> println("change here")

            else -> return;
        }

        currentGame!!.goToNextTurn()
    }


}