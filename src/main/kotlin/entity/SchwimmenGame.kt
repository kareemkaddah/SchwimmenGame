package entity

class SchwimmenGame(var passCounter: Int=0, val gameLoop: Boolean,var gameActive:Boolean,var deckCards: Deck, var Players:ArrayDeque<SchwimmenPlayer>)
{

   var currentPlayer:SchwimmenPlayer?= null
   get() = field
   set(value) {currentPlayer = value
   }

    var tableCards:MutableList<SchwimmenCard>;

   init{
      tableCards=deckCards.extractThreeCards();
      for(player in Players){
         player.dealtHandCards = deckCards.extractThreeCards()
      }
   }

   fun incrementPassCounter(){
      passCounter++
   }

   fun endGame(){
      gameActive=false
   }


}



