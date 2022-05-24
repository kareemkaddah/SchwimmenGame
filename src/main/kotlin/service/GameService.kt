package service

import AbstractRefreshingService

import entity.*

class GameService(private val rootService: RootService) : AbstractRefreshingService() {

    fun endGame() {

        val listOfPlayers = rootService.currentGame?.players
        if (listOfPlayers != null) {
            for (player in listOfPlayers) {
                player.checkHandScore();
            }
        }
        //TODO sort players
        onAllRefreshables { refreshAfterGameEnd() }
    }


    fun startGame(players: MutableList<SchwimmenPlayer>, deckCards: MutableList<SchwimmenCard>) {

        val game=SchwimmenGame(0,true,true,Deck(deckCards))
        rootService.currentGame=game
        initializePlayers(players)
        val gameDeck= rootService.currentGame?.deckCards
        val gamePlayers= rootService.currentGame?.players
//        giving every player three cards
        if (gamePlayers != null) {
            for(player in gamePlayers){
                if (gameDeck != null) {
                    player.handCards=gameDeck.extractThreeCards()
                }
            }
        }

        //assigning three cards to the table

        if (gameDeck != null) {
            rootService.currentGame?.tableCards =gameDeck.extractThreeCards()
        }

        onAllRefreshables { refreshAfterGameStart() }

    }

    //TODO check if correct
    fun checkEndGame(): Boolean {
        return !rootService.currentGame?.gameActive!!
    }


    private fun initializePlayers(players: MutableList<SchwimmenPlayer>) {
        if (players.size < 2 || players.size > 4) {
            println("players number is not valid")
            return;
        }

        for (player in players) {
            rootService.currentGame?.addPlayer(player)
        }
        //assigning the current player the first player

        rootService.playerActionService.currentPlayer=players[0]

    }

    fun getPlayersSize(): Int? {
        return rootService.currentGame?.players?.size
    }
}