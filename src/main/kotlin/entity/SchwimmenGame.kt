package entity

class SchwimmenGame(val passCounter: Int=0, val gameLoop: Boolean, var tableCards:MutableList<SchwimmenCard>)
{
   private var players: ArrayDeque<SchwimmenPlayer> = ArrayDeque(4)

   val deckCards: ArrayDeque<SchwimmenCard> get() = deckCards


   private var currentPlayer:SchwimmenPlayer?= null

   public fun setPlayers(newPlayer:ArrayDeque<SchwimmenPlayer>){
      players=newPlayer
   }



}



