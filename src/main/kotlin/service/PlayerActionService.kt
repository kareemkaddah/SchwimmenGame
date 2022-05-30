package service

import AbstractRefreshingService
import entity.*

class PlayerActionService(private val rootService: RootService) : AbstractRefreshingService() {



    fun knock() {
        rootService.currentGame!!.resetPassCounter()

        rootService.currentGame?.currentPlayer?.didKnock()
        nextTurn()
        onAllRefreshables { refreshAfterTurn() }
    }

    fun changeOneCard(handCard: SchwimmenCard, tableCard: SchwimmenCard) {

        rootService.currentGame!!.resetPassCounter()

        var playerCard = rootService.currentGame?.currentPlayer?.handCards

        val indexOfChosenCard = playerCard?.indexOf(handCard)
        val indexOfTableCard = rootService.currentGame?.tableCards!!.indexOf(tableCard)

        if (indexOfChosenCard != null) {
            playerCard?.set(indexOfChosenCard, tableCard)
        };
        rootService.currentGame?.tableCards!![indexOfTableCard] = handCard
        nextTurn()
        onAllRefreshables { refreshAfterTurn() }

    }


    fun changeAllCards() {

        rootService.currentGame!!.resetPassCounter()

        val tmp = rootService.currentGame?.currentPlayer?.handCards
        rootService.currentGame?.currentPlayer?.handCards = rootService.currentGame!!.tableCards
        if (tmp != null) {
            rootService.currentGame!!.tableCards = tmp
        }
        nextTurn()
        onAllRefreshables { refreshAfterTurn() }

    }


    fun pass() {

        rootService.currentGame?.incrementPassCounter();

        //draw new three cards from deck and rest player counter
        if(rootService.currentGame!!.passCounter==rootService.currentGame!!.players.size){
            rootService.currentGame!!.resetPassCounter()
            //draw three cards from the deck

            //check if more than three cards are remaining in deck

            if(rootService.currentGame!!.deckCards.size>=3){
                rootService.currentGame!!.tableCards= rootService.currentGame!!.deckCards.extractThreeCards()
            }
            else{
                //end game
                rootService.currentGame!!.endGame()
                onAllRefreshables { refreshAfterGameEnd()}

            }


        }
        nextTurn()
        onAllRefreshables { refreshAfterTurn() }
    }


    fun nextTurn(){
        rootService.currentGame!!.goToNextTurn()
        checkIfGameEnded()
        onAllRefreshables { refreshAfterTurn() }
    }

    fun checkIfGameEnded(){
        //TODO change to check before next player starts
        if (rootService.currentGame?.currentPlayer?.hasKnocked() == true) {
            rootService.currentGame!!.endGame()
            onAllRefreshables { refreshAfterGameEnd()}

        }
    }


}


