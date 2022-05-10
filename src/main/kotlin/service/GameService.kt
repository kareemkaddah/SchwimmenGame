package service

import entity.*

class GameService(private val rootService:RootService): AbstractRefreshingService() {
    fun endGame(){
        val game= rootService.currentGame
        checkNotNull(game)
        game.checkHandScore()
        onAllRefreshables{refreshAfterGameEnd()}
    }
}