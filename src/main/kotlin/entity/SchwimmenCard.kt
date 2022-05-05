package entity
/**
@param toString gibt das karte als String zurück
 @param getSuit gibt Suit zurück
 @param getValue gibt Value zurück

*/
class SchwimmenCard( private val suit: CardSuit ,private val value: CardValue ) {
    override fun toString()="$suit$value"

    fun getSuit(): CardSuit {
        return this.suit
    }

    fun getValue():CardValue{
        return this.value
    }

}