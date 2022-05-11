package service

import AbstractRefreshingService

import entity.*

class GameService(private val rootService: RootService) : AbstractRefreshingService() {


    private val currentGame = rootService.currentGame

    fun endGame() {

        val listOfPlayers = currentGame?.players
        if (listOfPlayers != null) {
            for (player in listOfPlayers) {
                player.checkHandScore();
            }
        }
        //TODO sort players
        onAllRefreshables { refreshAfterGameEnd() }
    }


    fun startGame(players: MutableList<SchwimmenPlayer>, deckCards: MutableList<SchwimmenCard>) {
        initializePlayers(players)
        currentGame?.deckCards = Deck(deckCards)
        val gameDeck= currentGame?.deckCards
        val gamePlayers= currentGame?.players
        //giving every player three cards
        if (gamePlayers != null) {
            for(player in gamePlayers){
                if (gameDeck != null) {
                    player.handCards=gameDeck.extractThreeCards()
                }
            }
        }

        //assigning three cards to the table

        if (gameDeck != null) {
            currentGame?.tableCards =gameDeck.extractThreeCards()
        }

    }

    //TODO check if correct
    fun checkEndGame(): Boolean {
        return !currentGame?.gameActive!!
    }


    private fun initializePlayers(players: MutableList<SchwimmenPlayer>) {
        if (players.size < 2 || players.size > 4) {
            println("players number is not valid")
            return;
        }

        for (player in players) {
            currentGame?.addPlayer(player)
        }

    }

    fun getPlayersSize(): Int? {
        return currentGame?.players?.size
    }
}