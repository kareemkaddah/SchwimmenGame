package view

import tools.aqua.bgw.components.container.CardStack
import tools.aqua.bgw.components.gamecomponentviews.CardView
import tools.aqua.bgw.visual.ColorVisual
import tools.aqua.bgw.visual.CompoundVisual
import tools.aqua.bgw.visual.TextVisual
import java.awt.Color

class CardsHolderPlace(posX: Number, posY: Number, label: String = "") :
    CardStack<CardView>(height = 200, width = 130, posX = posX, posY = posY) {

    init {
        visual = CompoundVisual(
            ColorVisual(Color(255, 255, 255, 50)),
            TextVisual(label)
        )
    }

}