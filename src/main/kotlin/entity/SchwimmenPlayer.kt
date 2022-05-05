package entity

/**
 * @param playerName name des Spielers
 * @param position gibt das Positon der spieler
 * @param hasKnocked zeigt ob der spieler geklopft hat oder nicht
 * @param DealtHandCards gibt die hand karten in einem array
 *
 */
class SchwimmenPlayer (private val playerName: String,private val position:Int, private val hasKnocked:Boolean){
    private val dealtHandCards: ArrayDeque<SchwimmenCard> = ArrayDeque(3)
    val DealtHandCards: ArrayDeque<SchwimmenCard> get() = dealtHandCards

   /* public fun checkHandScore():Double{

    }*/

    public fun hasKnocked():Boolean{
        return hasKnocked
    }
}