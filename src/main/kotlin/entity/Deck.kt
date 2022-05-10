package entity

import kotlin.random.Random

class Deck( pCards:ArrayDeque<SchwimmenCard>,private val random: Random = Random ){
    val cards:ArrayDeque<SchwimmenCard>

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
    val empty: Boolean get() = cards.isEmpty()

    /**
     * Shuffles the cards in this stack
     */
    fun shuffle() {
        cards.shuffle(random)
    }
    fun putOnTop(cards: List<SchwimmenCard>) {
        cards.forEach(this.cards::addFirst)
    }

    /**
     * puts the given card on top of this card stack
     */
    fun putOnTop(card: SchwimmenCard) {
        cards.addFirst(card)
    }

    fun extractThreeCards(): List<SchwimmenCard> {
        require ( 3 in 1..cards.size) { "can't draw 3 cards from $cards" }
        return List(3) { cards.removeFirst() }
    }

}