package view

import Refreshable
import service.RootService
import tools.aqua.bgw.components.uicomponents.Button
import tools.aqua.bgw.components.uicomponents.Label
import tools.aqua.bgw.core.BoardGameScene
import tools.aqua.bgw.visual.ColorVisual

class GameScene(private val rootService: RootService): BoardGameScene(1920, 1080), Refreshable {

    private val tableDeck = CardsHolderPlace(posX = 1600, posY = 400, "Deck")

    private val tableCardOne = CardsHolderPlace(posX = 700, posY = 400, "Player Card One")
    private val tableCardTwo = CardsHolderPlace(posX = 850, posY = 400, "Player Card Two")
    private val tableCardThree = CardsHolderPlace(posX = 1000, posY = 400, "Player Card Three")

    private val playerCardOne = CardsHolderPlace(posX = 700, posY = 830, "Table Card One")
    private val playerCardTwo = CardsHolderPlace(posX = 850, posY = 830, "Table Card Two")
    private val playerCardThree = CardsHolderPlace(posX = 1000, posY = 830, "Table Card Three")

    private val activePlayer = Label(width = 300, height = 35, posX = 100, posY = 100)


    private val passButton = Button(
        width = 180, height = 70,
        posX = 1600, posY = 840,
        text = "Pass"
    ).apply {
        visual = ColorVisual(221, 136, 136)
        onMousePressed = { rootService.playerActionService.pass() }
    }
    private val knockButton = Button(
        width = 180, height = 70,
        posX = 1600, posY = 910,
        text = "knock"
    ).apply {
        visual = ColorVisual(221, 136, 136)
        onMousePressed = { rootService.playerActionService.knock() }

    }
    private val swapThreeCards = Button(
        width = 180, height = 70,
        posX = 1600, posY = 980,
        text = "swap three cards"
    ).apply {
        visual = ColorVisual(221, 136, 136)
        onMousePressed = { rootService.playerActionService.changeAllCards() }
    }
    private val exitButton = Button(
        width = 180, height = 70,
        posX = 1600, posY = 10,
        text = "exit"
    ).apply {
        visual = ColorVisual(221, 136, 136)
        onMousePressed = { rootService.gameService.endGame() }
    }
    init {
        // dark green for "Casino table" flair
        background = ColorVisual(108, 168, 59)
        addComponents(
            tableDeck,
            tableCardOne,
            tableCardTwo,
            tableCardThree,
            playerCardOne,
            playerCardTwo,
            playerCardThree,
            passButton,
            knockButton,
            activePlayer,
            swapThreeCards,
            exitButton
        )
    }
    
    override fun refreshAfterTurn() {
        TODO("Not yet implemented")
    }

    override fun refreshAfterGameEnd() {
        TODO("Not yet implemented")
    }

}