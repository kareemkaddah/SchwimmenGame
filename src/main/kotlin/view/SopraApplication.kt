package view

import Refreshable
import entity.SchwimmenPlayer
import service.RootService
import tools.aqua.bgw.core.BoardGameApplication

class SopraApplication : BoardGameApplication("SoPra Game") , Refreshable {

    private val rootService=RootService()

    private lateinit var gameScene:GameScene;


    private val newGameMenuScene = NewGameScene(rootService).apply {
        quitButton.onMouseClicked = {
            exit()
        }
    }

   init {

       gameScene= GameScene(rootService)

       this.showGameScene(gameScene)
       this.showMenuScene(newGameMenuScene, 0)


       //TODO add score scene to refresh
      rootService.addRefreshables(
           this,
           gameScene,
           newGameMenuScene
       )

    }



    override fun refreshAfterGameStart() {
        this.hideMenuScene()
    }

    override fun refreshAfterTurn() {
        TODO("Not yet implemented")
    }

    override fun refreshAfterGameEnd() {
        TODO("Not yet implemented")
    }

}

