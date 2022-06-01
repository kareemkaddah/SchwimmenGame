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
import tools.aqua.bgw.util.Font
import tools.aqua.bgw.visual.ColorVisual
import tools.aqua.bgw.visual.ImageVisual

class GameScene(private val rootService: RootService): BoardGameScene(1920, 1080), Refreshable {
    //the deck that we extract three cards from
    private val tableDeck = CardsHolderPlace(posX = 1600, posY = 300, "Deck")
    //the three cards in the middle of the table
    private val tableCardOne = CardsHolderPlace(posX = 700, posY = 300, "Table Card One")
    private val tableCardTwo = CardsHolderPlace(posX = 850, posY = 300, "Table Card Two")
    private val tableCardThree = CardsHolderPlace(posX = 1000, posY = 300, "Table Card Three")
    //hand cards every player got 3 of them
    private val playerCardOne = CardsHolderPlace(posX = 700, posY = 750, "Player Card One")
    private val playerCardTwo = CardsHolderPlace(posX = 850, posY = 750, "Player Card Two")
    private val playerCardThree = CardsHolderPlace(posX = 1000, posY = 750, "Player Card Three")
    //shows the players name
    private val activePlayer = Label(width = 300, height = 35, posX = 800, posY = 1000 ,
    font = Font(size=34)
    )
    //shows the amount of cards left in the deck
    private val deckCardsAmount=Label(width = 300, height = 35, posX = 1525, posY = 525 ,
    font = Font(size=34)
    )


    private val cardMap: BidirectionalMap<SchwimmenCard, CardView> = BidirectionalMap()
    //the pass button is responsible for the pass operation if all the left players click pass too then we will change the Table cards
    private val passButton = Button(
        width = 180, height = 70, posX = 1300, posY = 910,
        font = Font(size = 34),
        text = "Pass"
    ).apply {
        visual = ColorVisual(69, 147, 182)
        onMousePressed = { rootService.playerActionService.pass() }
    }
    //after a player presses the Knock Button the game will end at the end of the round
    private val knockButton = Button(
        width = 180, height = 70, posX = 1480, posY = 910,
        font = Font(size = 34),
        text = "knock"
    ).apply {
        visual = ColorVisual(69, 147, 182)
        onMousePressed = { rootService.playerActionService.knock() }

    }
    //when the player press oh this button we will swap his hand cards with the tableCards
    private val swapThreeCards = Button(
        width = 180, height = 70, posX = 1660, posY = 910,
        font = Font(size = 34),
        text = "swap 3"
    ).apply {
        visual = ColorVisual(69, 147, 182)
        onMousePressed = { rootService.playerActionService.changeAllCards() }
    }
    //change the hand card on the left with the table card on the left
    private val swapCardButton11 = Button(
        width = 125, height = 75, posX = 700, posY = 650,
        text = "3",
    ).apply {
        visual = ColorVisual(221, 136, 136)
        onMousePressed = {
            rootService.playerActionService.changeOneCard(
                rootService.currentGame?.currentPlayer!!.handCards[0]
                , rootService.currentGame!!.tableCards[2]
            )
        }
    }
    //change the hand card on the left with the table card in the middle
    private val swapCardButton12 = Button(
        width = 125, height = 75, posX = 700, posY = 600,
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
    //change the hand card on the left with the table card on the right
    private val swapCardButton13 = Button(
        width = 125, height = 75, posX = 700, posY = 550,
        text = "1",
    ).apply {
        visual = ColorVisual(221, 136, 136)
        onMousePressed = {
            rootService.playerActionService.changeOneCard(
                rootService.currentGame?.currentPlayer!!.handCards[0]
                , rootService.currentGame!!.tableCards[0]
            )
        }
    }
    //change the hand card in the middle with the table card on the left
    private val swapCardButton21 = Button(
        width = 125, height = 75, posX = 850, posY = 650,
        text = "3",
    ).apply {
        visual = ColorVisual(221, 136, 136)
        onMousePressed = {
            rootService.playerActionService.changeOneCard(
                rootService.currentGame?.currentPlayer!!.handCards[1]
                , rootService.currentGame!!.tableCards[2]
            )
        }
    }
    //change the hand card in the middle with the table card in the middle
    private val swapCardButton22 = Button(
        width = 125, height = 75, posX = 850, posY = 600,
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
    //change the hand card in the middle with the table card on the right
    private val swapCardButton23 = Button(
        width = 125, height = 75, posX = 850, posY = 550,
        text = "1",
    ).apply {
        visual = ColorVisual(221, 136, 136)
        onMousePressed = {
            rootService.playerActionService.changeOneCard(
                rootService.currentGame?.currentPlayer!!.handCards[1]
                , rootService.currentGame!!.tableCards[0]
            )
        }
    }
    //change the hand card on the right with the table card on the left
    private val swapCardButton31 = Button(
        width = 125, height = 75, posX = 1000, posY = 650,
        text = "3",
    ).apply {
        visual = ColorVisual(221, 136, 136)
        onMousePressed = {
            rootService.playerActionService.changeOneCard(
                rootService.currentGame?.currentPlayer!!.handCards[2]
                , rootService.currentGame!!.tableCards[2]
            )
        }
    }
    //change the hand card on the right with the table card in the middle
    private val swapCardButton32 = Button(
        width = 125, height = 75, posX = 1000, posY = 600,
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
    //change the hand card on the right with the table card on the right
    private val swapCardButton33 = Button(
        width = 125, height = 75, posX = 1000, posY = 550,
        text = "1",
    ).apply {
        visual = ColorVisual(221, 136, 136)
        onMousePressed = {
            rootService.playerActionService.changeOneCard(
                rootService.currentGame?.currentPlayer!!.handCards[2]
                , rootService.currentGame!!.tableCards[0]
            )
        }
    }
    //we end the game and check the score
    private val exitButton = Button(
        width = 180, height = 70,
        posX = 1600, posY = 10,
        font = Font(size = 24),
        text = "exit"
    ).apply {
        visual = ColorVisual(69, 147, 182)
        onMousePressed = { rootService.gameService.endGame() }
    }
    init {
        // dark green for "Casino table" flair
        background = ColorVisual(0, 219, 201)
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

        deckCardsAmount.text="remaining Cards:${game.deckCards.size}"
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

        deckCardsAmount.text="Cards:${game.deckCards.size}"

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




