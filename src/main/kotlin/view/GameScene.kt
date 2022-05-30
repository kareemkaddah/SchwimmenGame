package view

import Refreshable
import entity.SchwimmenCard
import service.CardImageLoader
import service.RootService
import tools.aqua.bgw.components.gamecomponentviews.CardView
import tools.aqua.bgw.components.uicomponents.Button
import tools.aqua.bgw.components.uicomponents.Label
import tools.aqua.bgw.core.BoardGameScene
import tools.aqua.bgw.util.BidirectionalMap
import tools.aqua.bgw.visual.ColorVisual
import tools.aqua.bgw.visual.ImageVisual

class GameScene(private val rootService: RootService): BoardGameScene(1920, 1080), Refreshable {

    private val tableDeck = CardsHolderPlace(posX = 1600, posY = 400, "Deck")

    private val tableCardOne = CardsHolderPlace(posX = 700, posY = 400, "Table Card One")
    private val tableCardTwo = CardsHolderPlace(posX = 850, posY = 400, "Table Card Two")
    private val tableCardThree = CardsHolderPlace(posX = 1000, posY = 400, "Table Card Three")

    private val playerCardOne = CardsHolderPlace(posX = 700, posY = 830, "Player Card One")
    private val playerCardTwo = CardsHolderPlace(posX = 850, posY = 830, "Player Card Two")
    private val playerCardThree = CardsHolderPlace(posX = 1000, posY = 830, "Player Card Three")

    private val activePlayer = Label(width = 300, height = 35, posX = 100, posY = 100)

    private val deckCardsAmount=Label(width = 300, height = 35, posX = 100, posY = 200)


    private val cardMap: BidirectionalMap<SchwimmenCard, CardView> = BidirectionalMap()

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

    private val swapCardButton11 = Button(
        width = 100, height = 50,
        posX = 700, posY = 750,
        text = "3",
    ).apply {
        visual = ColorVisual(221, 136, 136)
        onMousePressed = {
            rootService.playerActionService.changeOneCard(
                rootService.currentGame?.currentPlayer!!.handCards[0]
                , rootService.currentGame!!.tableCards[0]
            )
        }
    }

    private val swapCardButton12 = Button(
        width = 100, height = 50,
        posX = 700, posY = 700,
        text = "2",
    ).apply {
        visual = ColorVisual(221, 136, 136)
        onMousePressed = {
            rootService.playerActionService.changeOneCard(
                rootService.currentGame?.currentPlayer!!.handCards[0]
                , rootService.currentGame!!.tableCards[1]
            )
        }
    }
    private val swapCardButton13 = Button(
        width = 100, height = 50,
        posX = 700, posY = 650,
        text = "1",
    ).apply {
        visual = ColorVisual(221, 136, 136)
        onMousePressed = {
            rootService.playerActionService.changeOneCard(
                rootService.currentGame?.currentPlayer!!.handCards[0]
                , rootService.currentGame!!.tableCards[2]
            )
        }
    }
    private val swapCardButton21 = Button(
        width = 100, height = 50,
        posX = 850, posY = 750,
        text = "3",
    ).apply {
        visual = ColorVisual(221, 136, 136)
        onMousePressed = {
            rootService.playerActionService.changeOneCard(
                rootService.currentGame?.currentPlayer!!.handCards[1]
                , rootService.currentGame!!.tableCards[0]
            )
        }
    }
    private val swapCardButton22 = Button(
        width = 100, height = 50,
        posX = 850, posY = 700,
        text = "2",
    ).apply {
        visual = ColorVisual(221, 136, 136)
        onMousePressed = {
            rootService.playerActionService.changeOneCard(
                rootService.currentGame?.currentPlayer!!.handCards[1]
                , rootService.currentGame!!.tableCards[1]
            )
        }
    }
    private val swapCardButton23 = Button(
        width = 100, height = 50,
        posX = 850, posY = 650,
        text = "1",
    ).apply {
        visual = ColorVisual(221, 136, 136)
        onMousePressed = {
            rootService.playerActionService.changeOneCard(
                rootService.currentGame?.currentPlayer!!.handCards[1]
                , rootService.currentGame!!.tableCards[2]
            )
        }
    }
    private val swapCardButton31 = Button(
        width = 100, height = 50,
        posX = 1000, posY = 750,
        text = "3",
    ).apply {
        visual = ColorVisual(221, 136, 136)
        onMousePressed = {
            rootService.playerActionService.changeOneCard(
                rootService.currentGame?.currentPlayer!!.handCards[2]
                , rootService.currentGame!!.tableCards[0]
            )
        }
    }
    private val swapCardButton32 = Button(
        width = 100, height = 50,
        posX = 1000, posY = 700,
        text = "2",
    ).apply {
        visual = ColorVisual(221, 136, 136)
        onMousePressed = {
            rootService.playerActionService.changeOneCard(
                rootService.currentGame?.currentPlayer!!.handCards[2]
                , rootService.currentGame!!.tableCards[1]
            )
        }
    }
    private val swapCardButton33 = Button(
        width = 100, height = 50,
        posX = 1000, posY = 650,
        text = "1",
    ).apply {
        visual = ColorVisual(221, 136, 136)
        onMousePressed = {
            rootService.playerActionService.changeOneCard(
                rootService.currentGame?.currentPlayer!!.handCards[2]
                , rootService.currentGame!!.tableCards[2]
            )
        }
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
            deckCardsAmount,
            swapThreeCards,
            exitButton,
            swapCardButton11,
            swapCardButton12,
            swapCardButton13,
            swapCardButton21,
            swapCardButton22,
            swapCardButton23,
            swapCardButton31,
            swapCardButton32,
            swapCardButton33
        )
    }

    override fun refreshAfterTurn() {
        val game=rootService.currentGame
        checkNotNull(game)

        val cardImageLoader = CardImageLoader()

        //Initialize table cards
        initializeCard(game.tableCards[0], tableCardOne, cardImageLoader)
        initializeCard(game.tableCards[1], tableCardTwo, cardImageLoader)
        initializeCard(game.tableCards[2], tableCardThree, cardImageLoader)



        //Initialize current player hand

        val activePlayerHand=game.currentPlayer!!.handCards

        initializeCard(activePlayerHand[0], playerCardOne, cardImageLoader)
        initializeCard(activePlayerHand[1], playerCardTwo, cardImageLoader)
        initializeCard(activePlayerHand[2], playerCardThree, cardImageLoader)


        //setting up the active player name

        activePlayer.text = (game.currentPlayer!!.getName())

        deckCardsAmount.text="remaining deck cards: ${game.deckCards.size}"
    }



    override fun refreshAfterGameStart() {
        val game=rootService.currentGame
        checkNotNull(game)

        val cardImageLoader = CardImageLoader()

        //Initialize table cards
        initializeCard(game.tableCards[0], tableCardOne, cardImageLoader)
        initializeCard(game.tableCards[1], tableCardTwo, cardImageLoader)
        initializeCard(game.tableCards[2], tableCardThree, cardImageLoader)

        //Initialize current player hand

        val activePlayerHand=game.currentPlayer!!.handCards

        initializeCard(activePlayerHand[0], playerCardOne, cardImageLoader)
        initializeCard(activePlayerHand[1], playerCardTwo, cardImageLoader)
        initializeCard(activePlayerHand[2], playerCardThree, cardImageLoader)

        //Initializing Deck

        //TODO check if this is correct
        initializeDeck(game.deckCards.cards[0], tableDeck, cardImageLoader)


        //setting up the active player name

        activePlayer.text = (game.currentPlayer!!.getName())

        deckCardsAmount.text="remaining deck cards: ${game.deckCards.size}"

    }


    private fun initializeCard(card: SchwimmenCard, cardHolderView: CardsHolderPlace, cardImageLoader: CardImageLoader) {
        cardHolderView.clear()
        val cardView = CardView(
            height = 200,
            width = 130,
            front = ImageVisual(cardImageLoader.frontImageFor(card.getSuit(), card.getViewValue()))
        )
        cardHolderView.add(cardView)
        cardMap.add(card to cardView)
    }



    private fun initializeDeck(card: SchwimmenCard, cardHolderView: CardsHolderPlace, cardImageLoader: CardImageLoader) {
        cardHolderView.clear()
        val cardView = CardView(
            height = 200,
            width = 130,
            front = ImageVisual(cardImageLoader.frontImageFor(card.getSuit(), card.getViewValue())),
            back = ImageVisual(cardImageLoader.backImage)
        )
        cardHolderView.add(cardView)
        cardMap.add(card to cardView)
    }

}




