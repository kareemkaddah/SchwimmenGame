package entity

/**
 * @param playerName name des Spielers
 * @param position gibt das Positon der spieler
 * @param hasKnocked zeigt ob der spieler geklopft hat oder nicht
 * @param DealtHandCards gibt die hand karten in einem array
 *@param checkHandScore calculates the score for the hand cards
 */
class SchwimmenPlayer (private val playerName: String,private val position:Int, private var hasKnocked:Boolean=false){

    //TODO check
    public lateinit var handCards :MutableList<SchwimmenCard>


    fun getName():String{
        return  this.playerName
    }

    //TODO  change this
//    var chosenHandIndex:Int = 10
//    var chosenTableIndex:Int=10
//
//
//    fun setHandIndex(handCard: SchwimmenCard):Unit{
//        val indexOfHandCard=handCards.indexOf(handCard)
//        chosenHandIndex=indexOfHandCard;
//    }
//
//    fun setTableIndex(tableCard: SchwimmenCard):Unit{
//        val indexOfHandCard=handCards.indexOf(tableCard)
//        chosenHandIndex=indexOfHandCard;
//    }




    //
    fun checkHandScore(): Double {
        val clubsGroup = mutableListOf<SchwimmenCard>()
        val spadesGroup = mutableListOf<SchwimmenCard>()
        val heartsGroup = mutableListOf<SchwimmenCard>()
        val diamondsGroup = mutableListOf<SchwimmenCard>()

        var clubsPoints:Double = 0.0
        var spadesPoints:Double = 0.0
        var heartsPoints :Double = 0.0
        var diamondsPoints :Double = 0.0
        //a temporary variable to store if a hand has the same Card values
        var tmp = 0.0

        for (card in handCards) {
            //we check here which  cardSuit we have and we put it in the appropriate List
            if (card.getSuit() == CardSuit.CLUBS) {
                clubsGroup.add(card)
            }
            if (card.getSuit() == CardSuit.SPADES) {
                spadesGroup.add(card)
            }
            if (card.getSuit() == CardSuit.HEARTS) {
                heartsGroup.add(card)
            }
            if (card.getSuit() == CardSuit.DIAMONDS) {
                diamondsGroup.add(card)
            }
        }
    //we calculate the values in every list to see which one have the max amount in it
        for (card in clubsGroup) {
            clubsPoints += card.getValue()
        }
        for (card in heartsGroup) {
            heartsPoints += card.getValue()
        }
        for (card in spadesGroup) {
            spadesPoints += card.getValue()
        }
        for (card in diamondsGroup) {
            diamondsPoints += card.getValue()
        }
    //after we compare the results of the lists we put the maximum amount in score
        val score = maxOf(clubsPoints, heartsPoints, spadesPoints, diamondsPoints)

        //Three cards of the same value will return an 30.5
        if (handCards[0].getValue() == handCards[1].getValue() &&
            (handCards[1].getValue() == handCards[2].getValue())
        ) {
            tmp = 30.5
        }
    //we check if the score that we calculated is bigger than tmp or not and we give the bigger one back
        return if (tmp > score) {
            tmp
        } else {
            score
        }

    }


    fun hasKnocked():Boolean{
        return hasKnocked
    }

    fun didKnock(){
        hasKnocked=true
    }

}