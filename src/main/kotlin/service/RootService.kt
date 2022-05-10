package service

import Refreshable
import entity.SchwimmenGame


class RootService {
    val gameService=GameService(this)
    val playerActionService = PlayerActionService(this)

    var currentGame : SchwimmenGame? = null

    fun addRefreshable(newRefreshable: Refreshable){
        gameService.addRefreshable(newRefreshable)
        playerActionService.addRefreshable(newRefreshable)
    }


    fun addRefreshables(vararg newRefreshables:Refreshable){
        newRefreshables.forEach{addRefreshable(it) }
    }

}