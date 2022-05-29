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


    fun getViewValue():CardValue{
        return this.value
    }

    fun getValue():Double{
        when (this.value) {
            CardValue.ACE -> { return 11.0}
            CardValue.KING -> { return 10.0}
            CardValue.QUEEN -> { return 10.0}
            CardValue.JACK -> { return 10.0}
            CardValue.TEN -> { return 10.0}
            CardValue.NINE -> { return 9.0}
            CardValue.EIGHT -> { return 8.0}
            CardValue.SEVEN -> { return 7.0}
            CardValue.SIX -> { return 6.0}
            CardValue.FIVE -> { return 5.0}
            CardValue.FOUR -> { return 4.0}
            CardValue.THREE-> { return 3.0}
            CardValue.TWO -> { return 2.0}

            else -> {return 0.0}
        }
    }

}