package view

import Refreshable
import service.RootService
import tools.aqua.bgw.components.uicomponents.Button
import tools.aqua.bgw.components.uicomponents.Label
import tools.aqua.bgw.core.MenuScene
import tools.aqua.bgw.util.Font
import tools.aqua.bgw.visual.ColorVisual
import java.awt.Color

class ScoreScene(private val rootService: RootService): MenuScene(1920, 1080), Refreshable {

    private val headlineLabel = Label(
        width = 500, height = 100, posX = 700, posY = 50,
        text = "Scores",
        font = Font(size = 44)
    )

    private val p1Score = Label(width = 400, height = 35, posX = 800, posY = 225 ,font = Font(size = 28))

    private val p2Score = Label(width = 400, height = 35, posX = 800, posY = 270 ,font = Font(size = 28))

    private val p3Score = Label(width = 400, height = 35, posX = 800, posY = 315 ,font = Font(size = 28))

    private val p4Score = Label(width = 400, height = 35, posX = 800, posY = 360 ,font = Font(size = 28))

    private val gameWinner = Label(width = 700, height = 35, posX =650, posY = 150,font = Font(size = 33))



    val quitButton = Button(width = 200, height = 70, posX = 760, posY = 430,
        font = Font(size = 24),
        text = "Quit"
    ).apply {
        visual = ColorVisual(Color(221, 136, 136))
    }

    val newGameButton = Button(width = 200, height = 70, posX = 1000, posY = 430,
        font = Font(size = 24),text= "New Game"
    ).apply {
        visual = ColorVisual(Color(136, 221, 136))
    }

    init {
        background = ColorVisual(0, 219, 201)
        opacity = .2
        addComponents(headlineLabel, p1Score, p2Score, p3Score, p4Score,gameWinner, newGameButton, quitButton)
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
            p1Score.text = "${names[0]} scored: ${scores[0]} points"
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
        val winner=scores.maxOrNull()
        if(scores[0]==winner){
            gameWinner.text=" ${names[0]} is the winner with the Score ${scores[0]}"
        }
        if(scores[1]==winner){
            gameWinner.text=" ${names[1]} is the winner with the Score ${scores[1]}"
        }
        if(scores[2]==winner){
            gameWinner.text=" ${names[2]} is the winner with the Score ${scores[2]}"
        }
        if(scores[3]==winner){
            gameWinner.text=" ${names[3]} is the winner with the Score ${scores[3]}"
        }





    }
}


