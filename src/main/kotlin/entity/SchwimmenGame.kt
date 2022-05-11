package entity

class SchwimmenGame(var passCounter: Int=0, val gameLoop: Boolean,var gameActive:Boolean,var deckCards: Deck)
{

   var players:MutableList<SchwimmenPlayer> = mutableListOf()

   var currentPlayer:SchwimmenPlayer?= null
   get() = field
   set(value) {currentPlayer = value
   }

    lateinit var tableCards:MutableList<SchwimmenCard>;

//   init{
//      tableCards=deckCards.extractThreeCards();
//      for(player in players){
//         player.dealtHandCards = deckCards.extractThreeCards()
//      }
//   }

   fun incrementPassCounter(){
      passCounter++
   }

   fun endGame(){
      gameActive=false
   }

   fun goToNextTurn(){
      val indexOfCurrentPlayer=players.indexOf(currentPlayer)
      currentPlayer=players[(indexOfCurrentPlayer+1)%players.size]
   }

   fun addPlayer(player:SchwimmenPlayer){
      players.add(player)
   }




}



