package view
import Refreshable
import entity.*
import service.GameService
import service.RootService
import tools.aqua.bgw.components.uicomponents.Button
import tools.aqua.bgw.components.uicomponents.Label
import tools.aqua.bgw.components.uicomponents.TextField
import tools.aqua.bgw.core.MenuScene
import tools.aqua.bgw.util.Font
import tools.aqua.bgw.visual.ColorVisual

class NewGameScene(private val rootService: RootService) : MenuScene(400, 1080), Refreshable{


    private val headlineLabel = Label(
        width = 300, height = 50, posX = 50, posY = 50,
        text = "Start New Game",
        font = Font(size = 22)
    )
    private val p1Label = Label(
        width = 100, height = 35,
        posX = 50, posY = 125,
        text = "Player 1:"
    )


    // type inference fails here, so explicit  ": TextField" is required
    // see https://discuss.kotlinlang.org/t/unexpected-type-checking-recursive-problem/6203/14
    private val p1Input: TextField = TextField(
        width = 200, height = 35,
        posX = 150, posY = 125,
        text = listOf("Homer", "Marge", "Bart", "Lisa", "Maggie").random()
    ).apply {
        onKeyTyped = {
            startButton.isDisabled = this.text.isBlank() || p2Input.text.isBlank()
        }
    }

    private val p2Label = Label(
        width = 100, height = 35,
        posX = 50, posY = 170,
        text = "Player 2:"
    )

    // type inference fails here, so explicit  ": TextField" is required
    // see https://discuss.kotlinlang.org/t/unexpected-type-checking-recursive-problem/6203/14
    private val p2Input: TextField = TextField(
        width = 200, height = 35,
        posX = 150, posY = 170,
        text = listOf("Fry", "Bender", "Leela", "Amy", "Zoidberg").random()
    ).apply {
        onKeyTyped = {
            startButton.isDisabled = p1Input.text.isBlank() || this.text.isBlank()
        }
    }

    private val p3Label = Label(
        width = 100, height = 35,
        posX = 50, posY = 215,
        text = "Player 3:"
    )

    // type inference fails here, so explicit  ": TextField" is required
    // see https://discuss.kotlinlang.org/t/unexpected-type-checking-recursive-problem/6203/14
    private val p3Input: TextField = TextField(
        width = 200, height = 35,
        posX = 150, posY = 215,
        text = listOf("Fry", "Bender", "Leela", "Amy", "Zoidberg").random()
    )

    // type inference fails here, so explicit  ": TextField" is required
    // see https://discuss.kotlinlang.org/t/unexpected-type-checking-recursive-problem/6203/14
    private val p4Input: TextField = TextField(
        width = 200, height = 35,
        posX = 150, posY = 260,
        text = listOf("Fry", "Bender", "Leela", "Amy", "Zoidberg").random()
    )

    private val p4Label = Label(
        width = 100, height = 35,
        posX = 50, posY = 260,
        text = "Player 4:"
    )

    val quitButton = Button(
        width = 140, height = 35,
        posX = 50, posY = 330,
        text = "Quit"
    ).apply {
        visual = ColorVisual(221, 136, 136)
    }

    private val startButton = Button(
        width = 140, height = 35,
        posX = 210, posY = 330,
        text = "Start"
    ).apply {
        visual = ColorVisual(136, 221, 136)
        onMouseClicked = {
            rootService.gameService.startGame(
                generateplayers(mutableListOf(p1Input.text.trim(),
                    p2Input.text.trim(),
                    p3Input.text.trim(),
                    p4Input.text.trim())),
                createCards()

            )
        }
    }

    init {
        opacity = .5
        addComponents(
            headlineLabel,
            p1Label, p1Input,
            p2Label, p2Input,
            p3Label, p3Input,
            p4Label, p4Input,
            startButton, quitButton
        )
    }


    fun generateplayers(playersName:MutableList<String>)  :MutableList<SchwimmenPlayer>  {
        val players= mutableListOf<SchwimmenPlayer>()
        for(index in 0..playersName.size - 1){

            players.add(SchwimmenPlayer(playersName[index],index))

        }
        return players
    }

    private fun createCards(): ArrayDeque<SchwimmenCard> {
        val deck = ArrayDeque<SchwimmenCard>();
        val cardsList= mutableListOf<SchwimmenCard>()



        for (index in 0..31) {

            cardsList.add(
                SchwimmenCard(
                    CardSuit.values()[index / 8],
                    CardValue.values()[(index % 8 + 5)]
                )
            )


        }

        cardsList.shuffle()

        for(card in cardsList){
            deck.addFirst((card))
        }
        return deck
    }




}

