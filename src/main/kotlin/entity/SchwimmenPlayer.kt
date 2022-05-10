package entity

/**
 * @param playerName name des Spielers
 * @param position gibt das Positon der spieler
 * @param hasKnocked zeigt ob der spieler geklopft hat oder nicht
 * @param DealtHandCards gibt die hand karten in einem array
 *
 */
class SchwimmenPlayer (private val playerName: String,private val position:Int, private val hasKnocked:Boolean){

    fun checkHandScore(): Double {

    }


    fun hasKnocked():Boolean{

        
        return hasKnocked
    }

    var dealtHandCards:List<SchwimmenCard> = listOf<SchwimmenCard>()
    get() = field
    set(value) {dealtHandCards= value}
}