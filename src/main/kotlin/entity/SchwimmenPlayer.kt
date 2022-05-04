package entity

class SchwimmenPlayer (private val playerName: String,private val position:Int, private val hasKnocked:Boolean){
    private val dealtHandCards: ArrayDeque<SchwimmenCard> = ArrayDeque(3)
    val DealtHandCards: ArrayDeque<SchwimmenCard> get() = dealtHandCards

   /* public fun checkHandScore():Double{

    }*/

    public fun hasKnocked():Boolean{
        return hasKnocked
    }
}