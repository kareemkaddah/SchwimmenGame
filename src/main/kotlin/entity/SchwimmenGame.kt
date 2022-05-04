package entity

class SchwimmenGame(val passCounter: Int, val gameLoop: Boolean)
{
   private var players: ArrayDeque<SchwimmenPlayer> = ArrayDeque(4)

    val tableCards: ArrayDeque<SchwimmenCard> = ArrayDeque(3)

   val deckCards:Deck

   private var currentPlayer:SchwimmenPlayer?= null

   public fun setPlayers(newPlayer:ArrayDeque<SchwimmenPlayer>){
      players=newPlayer
   }


}



