package view

import Refreshable
import entity.SchwimmenPlayer
import service.RootService
import tools.aqua.bgw.core.BoardGameApplication

class SopraApplication : BoardGameApplication("SoPra Game") , Refreshable {

    private val rootService=RootService()

    private var gameScene:GameScene;



    // This menu scene is shown after each finished game (i.e. no more cards to draw)

    private val scoreScene = ScoreScene(rootService).apply {
        newGameButton.onMouseClicked = {
            this@SopraApplication.showMenuScene(newGameMenuScene)
        }
        quitButton.onMouseClicked = {
            exit()
        }
    }

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
            scoreScene,
            newGameMenuScene
        )

    }



    override fun refreshAfterGameStart() {
        this.hideMenuScene()
    }
    override fun refreshAfterGameEnd() {
        this.showMenuScene(scoreScene)
    }


}