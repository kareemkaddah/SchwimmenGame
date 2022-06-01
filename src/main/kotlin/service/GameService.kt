package service

import AbstractRefreshingService

import entity.*

/**
 * @param endGame we check the handScore and we end the game
 * @param startGame startet eine neue spiel
 *
 */
class GameService(private val rootService: RootService) : AbstractRefreshingService() {

    fun endGame() {

        val listOfPlayers = rootService.currentGame?.players
        if (listOfPlayers != null) {
            for (player in listOfPlayers) {
                player.checkHandScore();
            }
        }

        onAllRefreshables { refreshAfterGameEnd() }
    }


    fun startGame(players: MutableList<SchwimmenPlayer>, deckCards: MutableList<SchwimmenCard>) {
    //we reset the passCounter and change teh gameMode to Active and we initialize the Players and give every player 3 cards from the deck
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

        //setting up the first player to be the current player
        game.currentPlayer=players[0]

        //assigning three cards to the table

        if (gameDeck != null) {
            rootService.currentGame?.tableCards =gameDeck.extractThreeCards()
        }

        onAllRefreshables { refreshAfterGameStart() }

    }


    fun checkEndGame(): Boolean {
        return !rootService.currentGame?.gameActive!!
    }

    //we initializePlayers and check if there's between 2 and 4 Players
    private fun initializePlayers(players: MutableList<SchwimmenPlayer>) {
        if (players.size < 2 || players.size > 4) {
            println("players number is not valid")
            return;
        }

        for (player in players) {
            rootService.currentGame?.addPlayer(player)
        }
        //assigning the current player the first player

        rootService.currentGame?.currentPlayer =players[0]

    }
    //returns the amount of players in the game
    fun getPlayersSize(): Int? {
        return rootService.currentGame?.players?.size
    }
}