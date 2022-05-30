package entity

import kotlin.random.Random

class Deck(  pCards:MutableList<SchwimmenCard>,private val random: Random = Random ){
    val cards:MutableList<SchwimmenCard>

    init {
        if(pCards.size==32){
            cards = pCards;
        }else{
            throw IllegalArgumentException("cards size has to be exactly 32");
        }
    }
    /**
     * the amount of cards in this stack
     */
    val size: Int get() = cards.size

    /**
     * Returns `true` if the stack is empty, `false` otherwise.
     */
    val isEmpty: Boolean get() = cards.isEmpty()




    fun extractThreeCards(): MutableList<SchwimmenCard> {
        require ( 3 in 1..cards.size) { "can't draw 3 cards from $cards" }
        return MutableList(3) { cards.removeFirst() }
    }



}

