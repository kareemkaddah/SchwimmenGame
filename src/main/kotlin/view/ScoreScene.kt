package view

import Refreshable
import service.RootService
import tools.aqua.bgw.components.uicomponents.Button
import tools.aqua.bgw.components.uicomponents.Label
import tools.aqua.bgw.core.MenuScene
import tools.aqua.bgw.util.Font
import tools.aqua.bgw.visual.ColorVisual
import java.awt.Color

class ScoreScene(private val rootService: RootService): MenuScene(400, 1080), Refreshable {

    private val headlineLabel = Label(
        width = 300, height = 50, posX = 50, posY = 50,
        text = "Scores",
        font = Font(size = 22)
    )

    private val p1Score = Label(width = 300, height = 35, posX = 50, posY = 125)

    private val p2Score = Label(width = 300, height = 35, posX = 50, posY = 160)

    private val p3Score = Label(width = 300, height = 35, posX = 50, posY = 195)

    private val p4Score = Label(width = 300, height = 35, posX = 50, posY = 230)

    private val gameResult = Label(width = 300, height = 35, posX = 50, posY = 195).apply {
    }

    val quitButton = Button(width = 140, height = 35, posX = 50, posY = 265, text = "Quit").apply {
        visual = ColorVisual(Color(221, 136, 136))
    }

    val newGameButton = Button(width = 140, height = 35, posX = 210, posY = 265, text = "New Game").apply {
        visual = ColorVisual(Color(136, 221, 136))
    }

    init {
        opacity = .5
        addComponents(headlineLabel, p1Score, p2Score, p3Score, p4Score, gameResult, newGameButton, quitButton)
    }

    override fun refreshAfterGameEnd() {

        val names = mutableListOf<String>()
        val scores = mutableListOf<Double>()
        val playersList= rootService.currentGame?.players

        if (playersList != null) {
            for(player in playersList){
                names.add(player.getName())
                scores.add(player.checkHandScore())

            }
        }

        if (names.size >= 1) {
            p1Score.text = "${names[0]}scored: ${scores[0]} points"
        }

        if (names.size >= 2) {
            p2Score.text = "${names[1]} scored ${scores[1]} points"
        }
        if (names.size >= 3) {
            p3Score.text = "${names[2]} scored ${scores[2]} points"
        }
        if (names.size >= 4) {
            p4Score.text = "${names[3]} scored ${scores[3]} points"
        }

    }
}